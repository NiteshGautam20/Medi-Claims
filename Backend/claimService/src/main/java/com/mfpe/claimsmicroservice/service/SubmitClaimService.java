package com.mfpe.claimsmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.claimsmicroservice.client.PolicyClient;
import com.mfpe.claimsmicroservice.dto.BenefitsDTO;
import com.mfpe.claimsmicroservice.dto.ClaimAmountDTO;
import com.mfpe.claimsmicroservice.dto.ClaimDTO;
import com.mfpe.claimsmicroservice.dto.ClaimStatusDTO;
import com.mfpe.claimsmicroservice.dto.ProviderDTO;
import com.mfpe.claimsmicroservice.exceptions.PolicyException;
import com.mfpe.claimsmicroservice.model.Benefits;
import com.mfpe.claimsmicroservice.model.Claim;
import com.mfpe.claimsmicroservice.model.Hospital;
import com.mfpe.claimsmicroservice.repository.ClaimRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubmitClaimService {
	@Autowired
	private ClaimRepo claimRepo;
	@Autowired
	private PolicyClient policyClient;

	private boolean checkProvider(ClaimDTO claimDTO, String token) {
		ProviderDTO providerDTO = policyClient.getChainOfProviders(claimDTO.getPolicyId(), token).getBody();
			log.info("came here");
			
			if (providerDTO !=null && providerDTO.getProviders() != null) {
			for (Hospital hospitalDetails : providerDTO.getProviders()) {
				if (claimDTO.getHospitalId().equalsIgnoreCase(hospitalDetails.getHospitalId())) {
					return true;
				}
			}
			}
		
		return false;
	}

	private boolean checkBenefit(ClaimDTO claimDTO, String token) {
		BenefitsDTO benefitsDTO = policyClient
				.getEligibleBenefits(claimDTO.getPolicyId(), claimDTO.getMemberId(), token).getBody();
		if (benefitsDTO != null &&  benefitsDTO.getBenefits() !=null) {
		for (Benefits benefits : benefitsDTO.getBenefits()) {
			if (claimDTO.getBenefitId().equalsIgnoreCase(benefits.getBenefitId())) {
				return true;
			}
		}
		}
		return false;
	}

	private boolean checkAmount(ClaimDTO claimDTO, String token) {
		ClaimAmountDTO claimAmountDTO = policyClient
				.getEligibleAmount(claimDTO.getPolicyId(), claimDTO.getMemberId(), token).getBody();
		if (claimAmountDTO != null) {
		return (claimDTO.getClaimAmount() <= claimAmountDTO.getEligibleAmount());
		}
		return false;
	}

	public ResponseEntity<ClaimStatusDTO> submitClaim(ClaimDTO claimDTO, String token) throws NullPointerException {
		boolean hospitalFlag = false;
		boolean benefitFlag = false;
		boolean amountFlag = false;
		try {
		log.info("inside the submit claim service method : BEGIN");
		log.info("checking the provider : BEGIN");
		hospitalFlag = checkProvider(claimDTO, token);
		log.info("checking of provider : ENDED");

		log.info("checking the Benefit : BEGIN");
		benefitFlag = checkBenefit(claimDTO, token);
		log.info("checking of Benefit : ENDED");

		log.info("checking the Amount : BEGIN");
		amountFlag = checkAmount(claimDTO, token);
		log.info("checking of provider : ENDED");
		}catch(PolicyException pe) {
			throw new PolicyException("Policy Serivce is Not working Properly");
		}
		log.info("creating claim and setting the status : BEGIN");
		Claim claim = new Claim();
		claim.setClaimId(claimDTO.getClaimId());
		claim.setBenefitId(claimDTO.getBenefitId());
		claim.setClaimAmount(claim.getClaimAmount());
		claim.setHospitalId(claimDTO.getHospitalId());
		claim.setMemberId(claimDTO.getMemberId());
		claim.setPolicyId(claimDTO.getPolicyId());
		claim.setRemarks(claim.getRemarks());
		if (hospitalFlag && benefitFlag && amountFlag) {
			claim.setStatus("Pending Action");
			claim.setDescription("All the fields are successfully verified! Please wait for furthur action");
		} else {
			claim.setStatus("Claim Rejected");
			if (!hospitalFlag) {
				claim.setDescription("Providers Details are not valid");
			} else if (!benefitFlag) {
				claim.setDescription("Benefits Details are not valid");
			} else {
				claim.setDescription("Claim amount is not valid");
			}
		}
		log.info("setting the status : ENDED");
		if (hospitalFlag && benefitFlag && amountFlag) {
			claimRepo.save(claim);
		}

		ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO();
		claimStatusDTO.setClaimStatus(claim.getStatus());
		claimStatusDTO.setClaimDescription(claim.getDescription());
		claimStatusDTO.setClaimId(claim.getClaimId());
		return new ResponseEntity<>(claimStatusDTO, HttpStatus.OK);
	}

}

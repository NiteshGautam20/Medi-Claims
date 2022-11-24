package com.policy.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.policy.microservice.dto.ClaimAmountDTO;
import com.policy.microservice.exception.ExpiredPolicyException;
import com.policy.microservice.exception.InvalidMemberIdException;
import com.policy.microservice.exception.InvalidPolicyId;
import com.policy.microservice.model.Policy;
import com.policy.microservice.repository.PolicyRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClaimAmountService {
	
	@Autowired
	private PolicyRepo policyRepo;
	
	@Autowired
	private MemberPolicyService memberPolicyService;
	
	public ClaimAmountDTO getClaimAmount(String policyId, String memberId) throws InvalidPolicyId{
		
		log.info("Inside get claim amount method in claim amount service...");
		
		Optional<Policy> policy = policyRepo.findById(policyId);
		
		if(!policy.isPresent() )
		{
			throw new InvalidPolicyId("Invalid Policy Id...");
		}
		
		if(!memberPolicyService.isValidMember(memberId))
		{
			throw new InvalidMemberIdException("Invalid Member Id...");
		}
		
		if(!memberPolicyService.isPremiumPaid(memberId))
		{
			throw new ExpiredPolicyException("Premium is not paid...");
		}
		
		log.info("Exiting get claim amount method in claim amount service...");
		
		return new ClaimAmountDTO(policy.get().getSumInsured());
	}
	
	
	

}

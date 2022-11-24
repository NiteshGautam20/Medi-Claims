package com.policy.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.microservice.dto.BenefitsDTO;
import com.policy.microservice.exception.ExpiredPolicyException;
import com.policy.microservice.exception.InvalidMemberIdException;
import com.policy.microservice.exception.InvalidPolicyId;
import com.policy.microservice.model.Policy;
import com.policy.microservice.repository.PolicyRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BenefitsService {
	
	@Autowired
	private PolicyRepo policyRepo;
	
	@Autowired
	private MemberPolicyService memberPolicyService;

	public BenefitsDTO getBenefits(String policyId, String memberId){
		
			log.info("Inside get benefits method in benefits service...");
			
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
				throw new ExpiredPolicyException("Premium not paid...");
			}
						
			log.info("Exiting get benefits method in benefits service...");
			
			return new BenefitsDTO(policy.get().getBenefits());
				
	}

}

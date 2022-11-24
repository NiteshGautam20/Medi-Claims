package com.policy.microservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.microservice.model.MemberPolicy;
import com.policy.microservice.repository.MemberPolicyRepo;

@Service
public class MemberPolicyService {
	
	@Autowired
	private MemberPolicyRepo memberPolicyRepo;
	
	public boolean isValidMember(String memberId) {
		
		Optional<MemberPolicy> member = memberPolicyRepo.findById(memberId);
		
		return member.isPresent();
	}
	
	public boolean isPremiumPaid(String memberId)
	{
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Optional<MemberPolicy> member = memberPolicyRepo.findById(memberId);
		
		LocalDate today = LocalDate.now();
		
		if(member.isPresent())
		{
			LocalDate lastDate = LocalDate.parse(member.get().getPremiumLastDate(),df);
	
			if(lastDate.plusYears(1).compareTo(today) >= 0)
				return true;
		}
		
		return false;
	}
}

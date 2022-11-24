package com.policy.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.microservice.model.MemberPolicy;

public interface MemberPolicyRepo extends JpaRepository<MemberPolicy,String>{
	

}

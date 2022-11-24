package com.policy.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.Benefits;

@Repository
public interface BenefitsRepo extends JpaRepository<Benefits,String>{
	
}

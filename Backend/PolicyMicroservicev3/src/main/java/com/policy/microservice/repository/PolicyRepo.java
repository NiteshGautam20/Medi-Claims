package com.policy.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy,String>{
	
}

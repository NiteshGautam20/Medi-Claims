package com.policy.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital,String>{
	
}

package com.mfpe.claimsmicroservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfpe.claimsmicroservice.model.Claim;

@Repository
@Transactional
public interface ClaimRepo extends JpaRepository<Claim, Integer> {
	@Query(value = "select status from Claim c where c.claimId=?1")
	String getStatus(String id);

	@Query(value = "select description from Claim c where c.claimId=?1")
	String getDescription(String id);

}

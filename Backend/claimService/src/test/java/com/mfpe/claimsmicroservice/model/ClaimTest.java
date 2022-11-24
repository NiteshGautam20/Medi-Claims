package com.mfpe.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class ClaimTest {

	Claim claim=new Claim();
	
	@Test
	@DisplayName("checking if Claim Class is loading or not")
	void ClaimIsLoadedOrNot() {
		assertThat(claim).isNotNull();
	}
	
	@Test
	@DisplayName("Checking every getter and setter of Claim Class")
	void testingClaim() {
		Claim claim=new Claim("C101","Pending","Verified","Nothing",10200.0,"H101","B101","P1001","M101");
		
		claim.setClaimId("C102");
		claim.setStatus("Rejected");
		claim.setDescription("Invalid Details");
		claim.setRemarks("Nothing");
		claim.setClaimAmount(10000.0);
		claim.setHospitalId("H102");
		claim.setBenefitId("B102");
		claim.setPolicyId("P1002");
		claim.setMemberId("M102");
		
		
		assertEquals("C102",claim.getClaimId());
		assertEquals("Rejected",claim.getStatus());
		assertEquals("Invalid Details",claim.getDescription());
		assertEquals("Nothing",claim.getRemarks());
		assertEquals(10000.0,claim.getClaimAmount());
		assertEquals("H102",claim.getHospitalId());
		assertEquals("B102",claim.getBenefitId());
		assertEquals("P1002",claim.getPolicyId());
		assertEquals("M102",claim.getMemberId());
	
	}
}

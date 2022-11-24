package com.mfpe.claimsmicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClaimDTOTest {

	
ClaimDTO claimDTO=new ClaimDTO();
	
	@Test
	@DisplayName("checking if ClaimDTO Class is loading or not")
	void ClaimIsLoadedOrNot() {
		assertThat(claimDTO).isNotNull();
	}
	
	@Test
	@DisplayName("Checking every getter and setter of ClaimDTO Class")
	void testingClaim() {
		ClaimDTO claimDTO=new ClaimDTO("C101","Pending","Verified","Nothing",10200.0,"H101","B101","P1001","M101");
		
		claimDTO.setClaimId("C102");
		claimDTO.setStatus("Rejected");
		claimDTO.setDescription("Invalid Details");
		claimDTO.setRemarks("Nothing");
		claimDTO.setClaimAmount(10000.0);
		claimDTO.setHospitalId("H102");
		claimDTO.setBenefitId("B102");
		claimDTO.setPolicyId("P1002");
		claimDTO.setMemberId("M102");
		
		
		assertEquals("C102",claimDTO.getClaimId());
		assertEquals("Rejected",claimDTO.getStatus());
		assertEquals("Invalid Details",claimDTO.getDescription());
		assertEquals("Nothing",claimDTO.getRemarks());
		assertEquals(10000.0,claimDTO.getClaimAmount());
		assertEquals("H102",claimDTO.getHospitalId());
		assertEquals("B102",claimDTO.getBenefitId());
		assertEquals("P1002",claimDTO.getPolicyId());
		assertEquals("M102",claimDTO.getMemberId());
	
	}
}

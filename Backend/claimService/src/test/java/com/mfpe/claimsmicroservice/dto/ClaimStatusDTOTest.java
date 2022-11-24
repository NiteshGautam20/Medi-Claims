package com.mfpe.claimsmicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClaimStatusDTOTest {

	ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
	
	@Test
	@DisplayName("Checking if claimStatusDTO class is loaded or not")
	void claimStatusDTOIsLoadingOrNot() {
		assertThat(claimStatusDTO).isNotNull();
	}
	
	@Test
	@DisplayName("Checking if all the getter and setter are working ")
	void checkClaimStatusDTO() {
		
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO("C101","Pending","Verified");
		
		claimStatusDTO.setClaimId("C102");
		claimStatusDTO.setClaimDescription("Invalid Details");
		claimStatusDTO.setClaimStatus("Rejected");
		
		assertEquals("C102", claimStatusDTO.getClaimId());
		assertEquals("Rejected", claimStatusDTO.getClaimStatus());
		assertEquals("Invalid Details", claimStatusDTO.getClaimDescription());
	}
	
}

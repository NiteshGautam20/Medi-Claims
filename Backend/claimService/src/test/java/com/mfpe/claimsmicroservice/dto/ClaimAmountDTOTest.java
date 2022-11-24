package com.mfpe.claimsmicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class ClaimAmountDTOTest {

	 ClaimAmountDTO claimAmountDTO=new ClaimAmountDTO();
	 
	 @Test
	 @DisplayName("Checking if claimAmountDTO class is loading or not")
	 void claimAmountDTOisLoadingOrNot() {
		 assertThat(claimAmountDTO).isNotNull();
	 }
	 
	 @Test
	 @DisplayName("Checking all the getter and setter method")
	 void checkClaimAmountDTO() {
		 
		 ClaimAmountDTO claimAmountDTO=new ClaimAmountDTO(10000.0);
		 
		 claimAmountDTO.setEligibleAmount(12000.0);
		 
		 assertEquals(12000.0, claimAmountDTO.getEligibleAmount());
	 }
}

package com.mfpe.claimsmicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidatingDTOTest {

	ValidatingDTO validatingDTO=new ValidatingDTO();
	
	@Test
	@DisplayName("Checking if ValidatingDTO class is loading or not")
	void validatingDTOIsLoadingOrNot() {
		assertThat(validatingDTO).isNotNull();
	}
	
	@Test
	@DisplayName("Checking all the getter and setter ")
	void checkValidatingDTO() {
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		
		validatingDTO.setValidStatus(false);
		
		assertEquals(false, validatingDTO.isValidStatus());
	}
	
}

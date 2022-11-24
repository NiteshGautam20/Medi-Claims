package com.mfpe.claimsmicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.claimsmicroservice.model.Benefits;

@SpringBootTest
 class BenefitsDTOTest {
	BenefitsDTO benefitsDTO=new BenefitsDTO();
	
	@Test
	@DisplayName("Checking if benefitsDTO is loading or not")
	void benefitsDTOIsLoadedOrNot() {
		assertThat(benefitsDTO).isNotNull();
	}
	
	@Test
	@DisplayName("Checking BenefitsDTO setter and getter")
	void checkBenefitsDTO() {
		List<Benefits> list=new ArrayList<Benefits>();
		list.add(new Benefits("B101","Coverage for COVID-19"));
		list.add(new Benefits("B102","Coverage for hospitalization at home"));
		list.add(new Benefits("B103","Ambulance charges upto 2000 covered"));
		BenefitsDTO benefitsDTO=new BenefitsDTO(list);
		
		benefitsDTO.setBenefits(list);
		
		assertEquals(3, benefitsDTO.getBenefits().size());
	}
	
	
}

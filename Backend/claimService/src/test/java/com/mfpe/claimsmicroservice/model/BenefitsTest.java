package com.mfpe.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class BenefitsTest {

	Benefits benefits=new Benefits();
	
	@Test
    @DisplayName("Checking if Benefits class is loading or not.")
     void benefitsIsLoadedOrNot() {
        assertThat(benefits).isNotNull();
    }
	
	@DisplayName("Checking if Benefits class is responding correctly or not.")
    @Test
     void testingBenefits(){
		Benefits benefits=new Benefits("B101","Coverage for COVID-19");
    	benefits.setBenefitId("B102");
    	benefits.setBenefitName("Coverage for hospitalization at home");
       
        assertEquals("B102",benefits.getBenefitId());
        assertEquals("Coverage for hospitalization at home",benefits.getBenefitName());
    }
} 

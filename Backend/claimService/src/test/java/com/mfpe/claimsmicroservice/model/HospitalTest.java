package com.mfpe.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class HospitalTest {

	Hospital hospital=new Hospital();
	
	@Test
	@DisplayName("Checking if Hospital class is Loading or not")
	void hospitalIsLoadingOrNot() {
		assertThat(hospital).isNotNull();
	}
	
	@Test
	@DisplayName("Checking of all the getter and setter are working")
	void checkHospital() {
		Hospital hospital=new Hospital("H101","Apollo Hospital","Delhi-Indraprastha");
		hospital.setHospitalId("H102");
		hospital.setName("Artemis Hospital");
		hospital.setLocation("Gurgaon");
		
		assertEquals("H102", hospital.getHospitalId());
		assertEquals("Artemis Hospital",hospital.getName());
		assertEquals("Gurgaon",hospital.getLocation());
		
	}
}

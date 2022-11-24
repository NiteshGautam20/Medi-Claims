package com.mfpe.claimsmicroservice.exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.claimsmicroservice.exceptions.ErrorDetails;

@SpringBootTest
class ErrorDetailsTest {

	ErrorDetails errorDetails=new ErrorDetails();
	
	@Test
	@DisplayName("Checking if ErroDetails Class is loading or not")
	void errorDetailsIsLoadingOrNot() {
		assertThat(errorDetails).isNotNull();
	}
	
	@Test
	@DisplayName("Checking if all the setters and getters is working")
	void checkErrorDetails() {
		ErrorDetails errorDetails=new ErrorDetails(new Date(),"Message","SomeURL");
		errorDetails.setDate(new Date(02));
		errorDetails.setMessage("There is an error");
		errorDetails.setRequestURL("URL");
		
		assertEquals(new Date(02),errorDetails.getDate());
		assertEquals("There is an error", errorDetails.getMessage());
		assertEquals("URL", errorDetails.getRequestURL());
	}
	
}

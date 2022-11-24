package com.mfpe.claimsmicroservice.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.claimsmicroservice.exceptions.InvalidClaimIdException;

@SpringBootTest
class InvalidClaimIdExceptionTest {

	InvalidClaimIdException invalidClaimIdException=new InvalidClaimIdException("Exception");
	
	@Test
	@DisplayName("Checking if InvalidClaimIdException class is loading or not")
	void invalidClaimIdExceptionIsLoadingOrNot() {
		assertThat(invalidClaimIdException).isNotNull();
	}
}

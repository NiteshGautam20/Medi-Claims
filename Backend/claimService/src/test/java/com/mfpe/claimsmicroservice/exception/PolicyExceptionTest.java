package com.mfpe.claimsmicroservice.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.claimsmicroservice.exceptions.PolicyException;

@SpringBootTest
class PolicyExceptionTest {

PolicyException policyException=new PolicyException("Exception");
	
	@Test
	@DisplayName("Checking if PolicyException class is loading or not")
	void policyExceptionIsLoadingOrNot() {
		assertThat(policyException).isNotNull();
	}
}

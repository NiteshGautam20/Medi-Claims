package com.mfpe.memberService.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvalidMemberIdExceptionTest {
	InvalidMemberIdException invalidMemberIdException = new InvalidMemberIdException("Exception");
	@Test
	 void testComponentTyepNotFoundExceptionTest() {
		
		assertThat(invalidMemberIdException).isNotNull();    
	}
	
}
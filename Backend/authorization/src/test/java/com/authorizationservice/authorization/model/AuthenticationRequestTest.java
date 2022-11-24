package com.authorizationservice.authorization.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootApplication
class AuthenticationRequestTest
{
   @Autowired
   @Mock
   private AuthenticationRequest authenticationRequest;

   @Test
   @DisplayName("Checking for AuthenticationRequest - if it is loading or not")
   void authenticationRequestNotNullTest(){
       assertThat(authenticationRequest).isNull();
   }

	@Test
	void testUserLoginBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(AuthenticationRequest.class);
	}


	@Test
	void testUserTokenBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(AuthenticationResponse.class);
	}

	@Test
	void testUserTokenEqualsAndHashCode2() {
		EqualsVerifier.simple().forClass(AuthenticationResponse.class).verify();
	}

	@Test
	void testUserLoginAllArgs() {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("adyasha", "dummy");
		assertEquals("adyasha", authenticationRequest.getUsername());
		assertEquals("dummy", authenticationRequest.getPassword());
	}

}

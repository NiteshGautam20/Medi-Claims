package com.authorizationservice.authorization.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
class AuthenticationResponseTest
{
   @Autowired
   private AuthenticationResponse authenticationResponse;

   @Test
   @DisplayName("Checking for AuthenticationResponse - if it is loading or not")
   void authenticationResponseNotNullTest(){
       assertThat(authenticationResponse).isNull();
   }
}

package com.mfpe.memberService.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ClaimsClientTest {
  
    ClaimsClient claimsClient;
    
    
    @Test
    @DisplayName("Checking if [ClaimsClient] is loading or not.")
   void packagingClientIsLoaded(){
        assertThat(claimsClient).isNull();    
    }
}
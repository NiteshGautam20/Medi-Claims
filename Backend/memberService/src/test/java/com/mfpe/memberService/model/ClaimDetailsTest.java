package com.mfpe.memberService.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClaimDetailsTest {

 
    ClaimDetails claimDetailsObj = new ClaimDetails();

    @Test
    @DisplayName("Checking if ClaimDetails class is loading or not.")
     void processingRequestIsLoadedOrNot() {
        assertThat(claimDetailsObj).isNotNull();
    }

    @DisplayName("Checking if ClaimDetails class is responding correctly or not.")
    @Test
     void testingClaimDetails() throws ParseException{
    
        claimDetailsObj = new ClaimDetails("AAA-BBB-CCC","Pending", "Need to Submit More Documents","something",65600,"H121","B1","P123","1");
        
        claimDetailsObj.setMemberId("121");
        claimDetailsObj.setPolicyId("P123");
        claimDetailsObj.setBenefitId("B1");
        claimDetailsObj.setClaimAmount(0);
        claimDetailsObj.setDescription("NA");
        claimDetailsObj.setHospitalId("H121");
        claimDetailsObj.setRemarks("Anything");
        claimDetailsObj.setClaimId("AAA-BBB-CCC");
        claimDetailsObj.setStatus("OK");
        
        
        assertEquals("121",claimDetailsObj.getMemberId());
        assertEquals("P123",claimDetailsObj.getPolicyId());
        assertEquals("B1",claimDetailsObj.getBenefitId());
        assertEquals(0,claimDetailsObj.getClaimAmount());
        assertEquals("NA",claimDetailsObj.getDescription());
        assertEquals("H121",claimDetailsObj.getHospitalId());
        assertEquals("Anything",claimDetailsObj.getRemarks());
        assertEquals("AAA-BBB-CCC",claimDetailsObj.getClaimId());
        assertEquals("OK",claimDetailsObj.getStatus());
        
     
    }
}

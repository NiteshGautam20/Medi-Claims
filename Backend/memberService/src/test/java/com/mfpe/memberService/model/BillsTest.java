package com.mfpe.memberService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BillsTest {

 
    Bills billsObj=new Bills();

    @Test
    @DisplayName("Checking if Bills class is loading or not.")
     void processingRequestIsLoadedOrNot() {
        assertThat(billsObj).isNotNull();
    }

    @DisplayName("Checking if Bills class is responding correctly or not.")
    @Test
     void testingBills() throws ParseException{
    	Date d1 = Date.valueOf("2021-05-04");
    	Date d2 = Date.valueOf("2020-06-04");
    	Date d3 = Date.valueOf("2011-07-02");
    	
        billsObj= new Bills("221","P2314", d3,65600,1200,d2);
        
        billsObj.setMemberId("121");
        billsObj.setPolicyId("P2314");
        billsObj.setLastPaidDate(d1);
        billsObj.setDueAmount(65600);
        billsObj.setLateCharge(1200);
        billsObj.setDueDate((java.sql.Date)d2);
        
        
        assertEquals("121",billsObj.getMemberId());
        assertEquals("P2314",billsObj.getPolicyId());
        assertEquals(d1,billsObj.getLastPaidDate());
        assertEquals(65600,billsObj.getDueAmount());
        assertEquals(1200,billsObj.getLateCharge());
        assertEquals((java.sql.Date)d2,billsObj.getDueDate());
     
    }
}

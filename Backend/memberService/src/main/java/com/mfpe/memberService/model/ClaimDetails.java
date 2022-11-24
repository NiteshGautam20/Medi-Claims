package com.mfpe.memberService.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClaimDetails {
	

	private String claimId;
	
	private String status;

	private String description;
    

	private String remarks;
	
	private double claimAmount;


    private String hospitalId;
    

    private String benefitId;
    

    private String policyId;
    

    private String memberId;
	
}

package com.mfpe.claimsmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClaimStatusDTO {
	private String claimId;
	private String claimStatus;
	
	private String claimDescription;

}
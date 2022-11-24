package com.mfpe.claimsmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClaimAmountDTO {
	
	@JsonProperty
	private double eligibleAmount;

	@JsonIgnore
	public double getEligibleAmount() {
		return eligibleAmount;
	}
	
	@JsonIgnore
	public void setEligibleAmount(double eligibleAmount) {
		this.eligibleAmount = eligibleAmount;
	}
	
	@JsonIgnore
	public ClaimAmountDTO(double eligibleAmount) {
		super();
		this.eligibleAmount = eligibleAmount;
	}
	
	
	
	
	

}
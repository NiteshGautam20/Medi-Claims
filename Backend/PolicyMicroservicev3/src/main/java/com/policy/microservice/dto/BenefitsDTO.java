package com.policy.microservice.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.policy.microservice.model.Benefits;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BenefitsDTO {
	
	@JsonProperty
	 private Set<Benefits> benefits;

	@JsonIgnore
	public Set<Benefits> getBenefits() {
		return benefits;
	}

	@JsonIgnore
	public void setBenefits(Set<Benefits> benefits) {
		this.benefits = benefits;
	}

	@JsonIgnore
	public BenefitsDTO(Set<Benefits> benefits) {
		super();
		this.benefits = benefits;
	}
	
	
	
	
	

}

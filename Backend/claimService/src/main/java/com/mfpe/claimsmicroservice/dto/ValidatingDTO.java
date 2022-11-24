package com.mfpe.claimsmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	public class ValidatingDTO {
	   
	   @JsonProperty
	    private boolean validStatus;
	    
	}



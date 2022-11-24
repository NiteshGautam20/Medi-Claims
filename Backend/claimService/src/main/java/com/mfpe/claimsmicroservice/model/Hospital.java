package com.mfpe.claimsmicroservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Hospital {

	private String hospitalId;
	
	
	private String name;

	private String location;
	

	public Hospital(String hospitalId, String name, String location) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.location = location;
	}
	
}

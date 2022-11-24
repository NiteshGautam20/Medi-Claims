package com.policy.microservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="policy")
@Getter
@Setter
@NoArgsConstructor
public class Policy{
	
	@Id
	@Column(name="PID")
	private String policyId;
	
	@Column(name="Policy_Type")
	private String policyType;
	
	@Column(name="Cap_Amount")
	private double sumInsured;
	
	@Column(name="Premium")
	private double premium;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="provider_policy", joinColumns= @JoinColumn(name="policyId"),
								  inverseJoinColumns= @JoinColumn(name="hospitalId"))
	private Set<Hospital> hospitals = new HashSet<>();
	
	@JsonIgnore	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="policy_benefits", joinColumns= @JoinColumn(name="policyId"),
					  inverseJoinColumns= @JoinColumn(name="benefitID"))
	private Set<Benefits> benefits = new HashSet<>();
	
	public Policy(String policyId, String policyType, double sumInsured, double premium) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.sumInsured = sumInsured;
		this.premium = premium;
	}
}
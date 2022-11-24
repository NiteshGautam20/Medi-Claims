package com.mfpe.memberService.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Bills")

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Bills {
	
	@Id
    @Column(name="MID")
	private String memberId;
	
    @Column(name="PID")	
	private String policyId;
    
    @Column(name="LastPaidDate")	
	private Date  lastPaidDate;
    
    @Column(name="DueAmount")	
	private int dueAmount;
    
    @Column(name="LateCharge")	
	private int  lateCharge;
    
    @Column(name="DueDate")	
	private Date  dueDate;
	
	
}
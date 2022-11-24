package com.mfpe.memberService.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	
	  private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;

}

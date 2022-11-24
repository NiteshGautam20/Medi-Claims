package com.policy.microservice.exception;

public class InvalidMemberIdException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidMemberIdException(String msg) {
		super(msg);
	}

}

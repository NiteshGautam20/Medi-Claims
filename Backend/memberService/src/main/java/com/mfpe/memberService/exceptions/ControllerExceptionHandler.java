package com.mfpe.memberService.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mfpe.memberService.model.ErrorMessage;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	
	@ExceptionHandler(value=InvalidClaimIdException.class)
	public ResponseEntity<ErrorMessage> invalidPolicyId(InvalidClaimIdException e, WebRequest request){
		
		log.info("Inside invalid claim id exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage(),request.getDescription(false));
		
		log.info("Exiting invalid policy id exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
		
	}
	
	
	@ExceptionHandler(value=InvalidMemberIdException.class)
	public ResponseEntity<ErrorMessage> invalidMemberId(InvalidMemberIdException e, WebRequest request){
		
		log.info("Inside invalid member id exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage(),request.getDescription(false));
		
		log.info("Exiting invalid member id exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
		
	}
	
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorMessage> feignExceptionHandling(FeignException e, WebRequest request){
		
		log.info("Inside feign exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(), "Token is either expired or invalid...", request.getDescription(false));
		
		log.info("Exiting feign exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
}

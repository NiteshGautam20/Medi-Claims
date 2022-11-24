package com.mfpe.claimsmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.claimsmicroservice.client.AuthClient;
import com.mfpe.claimsmicroservice.dto.ClaimDTO;
import com.mfpe.claimsmicroservice.dto.ClaimStatusDTO;
import com.mfpe.claimsmicroservice.exceptions.InvalidClaimIdException;
import com.mfpe.claimsmicroservice.exceptions.InvalidTokenException;
import com.mfpe.claimsmicroservice.service.ClaimStatusService;
import com.mfpe.claimsmicroservice.service.SubmitClaimService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/claimModule")
@Api(value = "For dealing with claim ")
public class ClaimsController {

	@Autowired
	private ClaimStatusService claimStatusService;
	@Autowired
	private SubmitClaimService submitClaimService;
	
	@Autowired
	private AuthClient authClient;
	
	@GetMapping(path="/getClaimStatus/{id}")
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable("id") String id,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidClaimIdException,InvalidTokenException {
		log.info(token);
		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		
		log.info("inside the get Claim Status : BEGIN");
		return claimStatusService.getClaimStatus(id); 
	}
	

	
	@PostMapping(path ="/submitClaim")
	public ResponseEntity<ClaimStatusDTO> submitClaim(@RequestBody ClaimDTO claimDTO,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidTokenException,NullPointerException {
		log.info(token);
		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		log.info("inside the submit Claim : BEGIN");
		return submitClaimService.submitClaim(claimDTO,token);
	}
	
}

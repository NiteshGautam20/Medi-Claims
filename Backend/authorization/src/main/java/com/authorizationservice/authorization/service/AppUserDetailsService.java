package com.authorizationservice.authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	AuthRequestRepo authRequestRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("BEGIN - [loadUserByUsername()]");
		log.debug("Username : " + userName);
		AuthenticationRequest authenticationRequest;
		
		if(authRequestRepo.findById(userName).get() != null) {
			authenticationRequest = authRequestRepo.findById(userName).get();
			UserDetails user = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
					new ArrayList<>());
			log.debug("User : " + user);
			log.info("END - [loadUserByUsername()]");
			return user;
		}
		
		throw new UsernameNotFoundException("User not found!!");
	}

	public AuthenticationRequest getUser(String userName) {
		return authRequestRepo.findById(userName).get();
	}

	public void saveUser(AuthenticationRequest user) {
		authRequestRepo.save(user);
	}

}

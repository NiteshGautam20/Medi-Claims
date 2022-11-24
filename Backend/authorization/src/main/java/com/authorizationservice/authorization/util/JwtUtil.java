package com.authorizationservice.authorization.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtUtil {

    private static final String SECRET_KEY = "abcABC09";
    private long currentTime;
    private long expirationTime;

    public String extractUsername(String token) {
        log.info("BEGIN - [extractUsername(token)]");
		log.info("END - [extractUsername(token)]");
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        log.info("BEGIN - [extractExpiration(token)]");
        log.info("END - [extractUsername(token)]");
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        log.info("BEGIN - [extractClaims()]");
        final Claims claims = extractAllClaims(token);
        log.info("END - [extractClaims()]");
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        log.info("BEGIN - [extractAllClaims(token)]");
        log.info("END - [extractAllClaims()]");
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        log.info("BEGIN - [isTokenExpired(token)]");
        log.info("END - [isTokenExpired(token)]");
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        log.info("BEGIN - [generateToken(userDetails)]");
        Map<String, Object> claims = new HashMap<>();
        log.debug("CLaims" + claims);
        log.info("END - [generateToken(userDetails)]");
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        log.info("BEGIN - [createToken()]");
        log.info("END - [createToken()]");
        
        setCurrentTime(System.currentTimeMillis());
        setExpirationTime(getCurrentTime() + 1000 * 60 * 30);
        
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(getExpirationTime()))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token,UserDetails userDetails) {
        log.info("BEGIN - [validateToken(token,userDetails)]");
        final String username = extractUsername(token);
        log.debug("Username " + username);
        log.info("END - [validateToken(token,userDetails)]");
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}
    
    
}

package com.pk.publisher.security;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author navi
 *
 */
@Component
public class JwtProvider {

  private String secretKey;
  private long validityInMilliseconds;
  
  /**
   * 
   * @param secretKey
   * @param milliseconds
   */
  @Autowired
  public JwtProvider(@Value("${security.jwt.token.secret-key}") String secretKey,
      @Value("${security.jwt.token.expiration}") long milliseconds) {

    this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    this.validityInMilliseconds = milliseconds;
  }
  
  /**
   * 
   * @param username
   * @return token string
   */
  public String createToken(String username) {
    Claims claims = Jwts.claims().setSubject(username);

    Date now = new Date();
    return Jwts.builder().setClaims(claims).setIssuedAt(now)
        .setExpiration(new Date(now.getTime() + validityInMilliseconds))
        .signWith(SignatureAlgorithm.HS256, secretKey).compact();
  }
}

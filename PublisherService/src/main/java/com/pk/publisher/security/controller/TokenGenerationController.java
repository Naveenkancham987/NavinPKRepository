package com.pk.publisher.security.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pk.publisher.model.SignInDto;
import com.pk.publisher.security.JwtProvider;

/**
 * 
 * @author navi
 *
 */
@RestController
public class TokenGenerationController {
  private static final Logger log = LoggerFactory.getLogger(TokenGenerationController.class);

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtProvider jwtProvider;

  /**
   * 
   * @param signInDto
   * @return string token
   */
  @PostMapping("/token")
  public String signIn(@RequestBody @Valid SignInDto signInDto) {
    log.info("in signIn method{}", "Generate token");
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          signInDto.getUsername(), signInDto.getPassword()));
      return jwtProvider.createToken(signInDto.getUsername());
    } catch (AuthenticationException e) {
      log.error("Log in failed for user, {}", signInDto.getUsername());
    }
    return "";
  }
}

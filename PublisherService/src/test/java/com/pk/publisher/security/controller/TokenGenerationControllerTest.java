package com.pk.publisher.security.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import com.pk.publisher.model.SignInDto;
import com.pk.publisher.security.JwtProvider;

@RunWith(MockitoJUnitRunner.class)
public class TokenGenerationControllerTest {
  
  @InjectMocks
  private TokenGenerationController tokenGenerationController;
  @Mock
  private AuthenticationManager authenticationManager;
  
  @Mock
  private JwtProvider jwtProvider;
  
  @Test
  public void testTokenGenerationController() {
    
    SignInDto signInDto = new SignInDto("navi","navi");
    
  when(jwtProvider.createToken(signInDto.getUsername())).thenReturn("454884-584848498-4894848-8488984");
    assertNotNull(tokenGenerationController.signIn(new SignInDto("navi","navi")));  
  }
  
  @Test(expected=Exception.class)
  public void testTokenGenerationControllerException() {
    authenticationManager=null;
    jwtProvider=null; 
  SignInDto signInDto = new SignInDto("navi","navi");
  when(jwtProvider.createToken(signInDto.getUsername())).thenReturn("1234-45657-789");
  tokenGenerationController.signIn(new SignInDto("navi1","navi1"));
  }

}

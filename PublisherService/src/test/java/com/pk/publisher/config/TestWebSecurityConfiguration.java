package com.pk.publisher.config;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class TestWebSecurityConfiguration {
  
  @MockBean
  private UserDetailsService userDetailsService;
  
  @InjectMocks
  private WebSecurityConfiguration webSecurityConfiguration;
 
  @Test
  public void testUserDetailsService() throws Exception {
    assertNotNull(webSecurityConfiguration.userDetailsService());
  }
  
  
}

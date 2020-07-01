package com.pk.publisher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.pk.publisher.security.JwtTokenFilter;
import com.pk.publisher.utility.PublisherServiceConstants;

/**
 * 
 * @author navi
 *
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Value("${security.jwt.token.secret-key}")
  private String secret;

  @Autowired
  private UserDetailsService userDetailsService;

  /**
   * @param HttpSecurity
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().requestMatchers().antMatchers("/publish").and()
    .authorizeRequests().antMatchers("/token").permitAll().anyRequest()
     .authenticated().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   

    http.addFilterBefore(new JwtTokenFilter(userDetailsService, secret),
        UsernamePasswordAuthenticationFilter.class);
  }
  /**
   * @return AuthenticationManager
   */
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
  /**
   * @return  UserDetailsService
   */
  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    UserDetails user =
        User.withDefaultPasswordEncoder().username(PublisherServiceConstants.USER_NAME).password(PublisherServiceConstants.PASSWORD)
        .roles(PublisherServiceConstants.USER).build();

    return new InMemoryUserDetailsManager(user);
  }
}

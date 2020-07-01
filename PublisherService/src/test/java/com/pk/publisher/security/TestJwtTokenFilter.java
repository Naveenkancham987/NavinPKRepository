package com.pk.publisher.security;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.publisher.model.Address;
import com.pk.publisher.model.Customer;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestJwtTokenFilter {

  @Autowired
  private MockMvc mvc;
  
    @Test
  public void testDoFilter() throws Exception {
    String token = "Bearer " + testToken();
    mvc.perform(MockMvcRequestBuilders.post("/publish").accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON_VALUE)  .content(asJsonString())
        .header("Authorization", token)).andExpect(status().is5xxServerError());
  }


  @Test
  public void testDoFilterInvalid() throws Exception {
    String token = "Bearer " + testTokenInvalid();
    assertNotNull(token);
  }



  public String testToken() throws Exception {
    String body = authenticationUnameAndPassword();
    MvcResult result = mvc
        .perform(MockMvcRequestBuilders.post("/token").accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
        .andExpect(status().isOk()).andReturn();
    String response = result.getResponse().getContentAsString();
    response = response.replace("{\"access_token\": \"", "");
    String token = response.replace("\"}", "");
    return token;
  }

  public String testTokenInvalid() throws Exception {
    String body = authenticationUnameAndPassword1();
    MvcResult result = mvc
        .perform(MockMvcRequestBuilders.post("/token").accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
        .andExpect(status().isOk()).andReturn();
    String response = result.getResponse().getContentAsString();
    return response;
  }

  private String authenticationUnameAndPassword() {
    String username = "navi";
    String password = "navi";
    String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
    return body;
  }
  
  private String authenticationUnameAndPassword1() {
    String username = "";
    String password = "";
    String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
    return body;
  }

  private static String asJsonString() {
    Address address = new Address();
    address.setAddressLine1("gandhinagar");
    address.setPostalCode("50410");
    Customer cust = new Customer();
    cust.setCustomerNumber("C12345");
    cust.setCountryCode("IN");
    cust.setAddress(address);
    cust.setCountry("India");
    cust.setBirthdate(LocalDate.parse("06-06-1987",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    cust.setCustomerStatus("close");
    cust.email("navin27@gmail.com");
    cust.setFirstName("kanchamasd");
    cust.setLastName("kumardghjk");
    cust.setMobileNumber("9849558454");
    try {
      return new ObjectMapper().writeValueAsString(cust);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

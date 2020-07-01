package com.pk.publisher.utility;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.pk.publisher.model.CustomerDTO;

@RunWith(MockitoJUnitRunner.class)
public class TestPublisherUtilityService {


  private CustomerDTO cust;

  @Before
  public void init() {
    cust = new CustomerDTO();
    cust.setCustomerNumber("C12345");
    cust.setEmail("navin270587@gmail.com");
    cust.setBirthdate("06-06-1987");
  }

  @Test
  public void testMaskSecureInformation() {

    assertNotNull(PublisherUtilityService.maskSecureInformation(cust));
  }

  @Test
  public void testReplaceLastFourCharecters() {
    assertNotNull(PublisherUtilityService.replaceFirstFourCharecters(cust.getEmail(), 4));
  }
  @Test
  public void testReplaceLastFourCharectersNegative() {
    assertNotNull(PublisherUtilityService.replaceFirstFourCharecters("nav", 4));
  }

  @Test
  public void testReplaceFirstFourCharecters() {
    assertNotNull(PublisherUtilityService.replaceFirstFourCharecters(cust.getCustomerNumber(), 4));
  }
  @Test
  public void testReplaceFirstFourCharecterNegative() {
    assertNotNull(PublisherUtilityService.replaceLastFourCharecters("san"));
  }
  
  @Test
  public void testSuccessResponse() {
    assertNotNull(PublisherUtilityService.prepareSuccessResponse());
  }
}

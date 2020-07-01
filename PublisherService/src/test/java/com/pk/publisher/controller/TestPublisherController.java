package com.pk.publisher.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.pk.publisher.model.Customer;
import com.pk.publisher.model.SuccessResponse;
import com.pk.publisher.service.PublisherService;


@RunWith(MockitoJUnitRunner.class)
public class TestPublisherController {

  @InjectMocks
  private PublisherController publisherController;

  @Mock
  private PublisherService publisherService;
  @Mock
  private ResponseEntity<SuccessResponse> responseEntity;

  @Test
  public void testPublishCustomerInformation(){
    when(publisherService.publishCustomerObject(getCustomerInfo())).thenReturn(responseEntity);
    assertNotNull(publisherController.publishCustomerInformation(getCustomerInfo()));
  }

  private static Customer getCustomerInfo() {
    Customer customer = new Customer();
    customer.setCustomerNumber("C123456");
    customer.setFirstName("Naveen kumar");
    customer.setEmail("navin270587@gmail.com");
    return customer;
  }
}

package com.pk.publisher.service;

import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import com.pk.publisher.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class PublisherServiceTest {
  
  @InjectMocks
  private PublisherService publisherService;
  
  @Mock
  private KafkaTemplate<String, Customer> kafkatemplate;
  @Mock
  private  ModelMapper modelMapper;
  
 
  @Test
  public void testPublishCustomerObject() {
   assertNotNull( publisherService.publishCustomerObject(getCustomerInfo()));
  }
  
  private static Customer getCustomerInfo() {
    Customer customer = new Customer();
    customer.setCustomerNumber("C123456");
    customer.setEmail("navin270587@gmail.com");
    customer.setBirthdate(LocalDate.parse("06-06-1987",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    return customer;
  }
 }

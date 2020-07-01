package com.pk.publisher.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.pk.publisher.model.Customer;
import com.pk.publisher.model.CustomerDTO;
import com.pk.publisher.model.SuccessResponse;
import com.pk.publisher.utility.PublisherServiceConstants;
import com.pk.publisher.utility.PublisherUtilityService;

/**
 * 
 * @author navi
 *
 */

@Service
public class PublisherService {

  private static final Logger log = LoggerFactory.getLogger(PublisherService.class);

  @Autowired
  private KafkaTemplate<String, CustomerDTO> kafkatemplate;
  
  @Autowired
  private ModelMapper modelMapper;
   
  /**
   * 
   * @param customer
   * @return ResponseEntity
   */
  public ResponseEntity<SuccessResponse> publishCustomerObject(Customer customer) {
    CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
    PublisherUtilityService.maskSecureInformation(customerDTO);
    kafkatemplate.send(PublisherServiceConstants.TOPIC, customerDTO);
    log.info("published customerDTO object {}", customerDTO);
    SuccessResponse response = PublisherUtilityService.prepareSuccessResponse();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}

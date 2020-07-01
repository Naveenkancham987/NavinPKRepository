package com.pk.publisher.utility;

import com.pk.publisher.model.CustomerDTO;
import com.pk.publisher.model.SuccessResponse;

/**
 * 
 * @author Navi
 *
 */
public class PublisherUtilityService {
 
  
  /**
   * 
   * @param customerNumber
   * @param noOFDigits
   * @return
   */
  public static String replaceFirstFourCharecters(String customerNumber, int noOFDigits) {
    int length = customerNumber.length();
    if (length > noOFDigits) {
      return PublisherServiceConstants.PATTERN + customerNumber.substring(noOFDigits, length);
    }
    return customerNumber;
  }

  /**
   * 
   * @param customer
   */
  public static CustomerDTO maskSecureInformation(CustomerDTO customerDTO) {
    customerDTO.setCustomerNumber(replaceLastFourCharecters(customerDTO.getCustomerNumber()));
    customerDTO.setEmail(replaceFirstFourCharecters(customerDTO.getEmail(),4));
    customerDTO.setBirthdate(replaceFirstFourCharecters(customerDTO.getBirthdate(),4));
    return customerDTO;
  }
  
  /**
   * 
   * @return SuccessResponse object
   */
  public static SuccessResponse prepareSuccessResponse() {
    SuccessResponse response = new SuccessResponse();
    response.setMessage(PublisherServiceConstants.SUCCESSFULLY_PUBLISHED);
    response.setStatus(PublisherServiceConstants.SUCCESS);
    return response;
  }
  
  /**
   * 
   * @param customerNumber
   * @return
   */
  public static String replaceLastFourCharecters(String customerNumber) {
    int length = customerNumber.length();
    if (length > 4) {
      return customerNumber.substring(0, length - 4) + PublisherServiceConstants.PATTERN;
    }
    return customerNumber;
  }

}

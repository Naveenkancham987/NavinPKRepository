package com.pk.publisher.config;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestPublisherKakfaConfiguration {
  
  @InjectMocks
  private PublisherKakfaConfiguration publisherKakfaConfiguration;
  
  @Test
  public void testPublisherKakfaConfiguration() {
    assertNotNull(publisherKakfaConfiguration.kafkaTemplate());
  }
  
  /*
   * @Test public void testProducerFactory() {
   * assertNotNull(publisherKakfaConfiguration.producerFactory()); }
   */

}

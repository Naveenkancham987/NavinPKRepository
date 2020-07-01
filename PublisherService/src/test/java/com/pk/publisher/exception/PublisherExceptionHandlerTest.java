package com.pk.publisher.exception;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RunWith(MockitoJUnitRunner.class)
public class PublisherExceptionHandlerTest {
  
  @InjectMocks
  private PublisherExceptionHandler publisherExceptionHandler;
  
  @Test
  public void testHandleMethodArgumentException() {
    MethodArgumentNotValidException exception= mock(MethodArgumentNotValidException.class);
    assertNotNull(publisherExceptionHandler.handleMethodArgumentException(exception));
    }
  
  @Test
  public void testException() {
    assertNotNull(publisherExceptionHandler.handleException(new Exception()));
  }
}

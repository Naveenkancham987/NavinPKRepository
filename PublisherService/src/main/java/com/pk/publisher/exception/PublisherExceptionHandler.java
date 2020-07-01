package com.pk.publisher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pk.publisher.model.ErrorResponse;

/**
 * 
 * @author navi
 *
 */
@RestControllerAdvice
public class PublisherExceptionHandler {

  /**
   * 
   * @param methodArgumentNotValidException
   * @return ResponseEntity
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentException(
      MethodArgumentNotValidException methodArgumentNotValidException) {
    ErrorResponse error = new ErrorResponse();
    error.setErrorType(methodArgumentNotValidException);
    error.setMessage(methodArgumentNotValidException.getMessage());
    error.setStatus(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
 
  /**
   * 
   * @param exception
   * @return ResponseEntity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception exception) {
    ErrorResponse error = new ErrorResponse();
    error.setErrorType(exception.getClass().getName());
    error.setMessage(exception.getMessage());
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}

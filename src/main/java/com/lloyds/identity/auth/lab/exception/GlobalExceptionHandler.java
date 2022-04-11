package com.lloyds.identity.auth.lab.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
    }
    return new ResponseEntity<>(populateErrorResponse(ex), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({ResourceAccessException.class, SocketTimeoutException.class})
  public ResponseEntity<ErrorResponse> handleResourceAccessException(final SocketTimeoutException ex) {
    return new ResponseEntity<>(populateErrorResponse(ex), HttpStatus.GATEWAY_TIMEOUT);

  }

  @ExceptionHandler(InternalServerError.class)
  public ResponseEntity<ErrorResponse> handleInternalServerErrorException(final InternalServerError ex) {
    return new ResponseEntity<>(populateErrorResponse(ex), HttpStatus.INTERNAL_SERVER_ERROR);

  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(final Exception ex) {
    return new ResponseEntity<>(populateErrorResponse(ex), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * This method will populate and return the error response
   *
   * @param ex
   * @return
   */
  private ErrorResponse populateErrorResponse(Exception ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(ex.getMessage());
    errorResponse.setTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
    logger.error(ex.getMessage(), ex);
    return errorResponse;
  }
}

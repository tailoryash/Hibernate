package com.simform.interviewquestion.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

  @ExceptionHandler(value = {NotFoundRequestException.class})
  public ResponseEntity<Object> handleNotFoundException(NotFoundRequestException e){
    //TODO:create payload containing exception details
    NotFoundException notFoundException = new NotFoundException(
            e.getMessage(),
            HttpStatus.NOT_FOUND
    );
    //TODO:Return response entity
    return new ResponseEntity<>(notFoundException , HttpStatus.NOT_FOUND);
  }
}

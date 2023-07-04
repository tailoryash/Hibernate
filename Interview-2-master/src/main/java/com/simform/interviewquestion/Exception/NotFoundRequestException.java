package com.simform.interviewquestion.Exception;

public class NotFoundRequestException extends RuntimeException{
  public NotFoundRequestException(String message) {
    super(message);
  }

  public NotFoundRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}

package com.simform.interviewquestion.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundException {
  private final String message;

  private final HttpStatus httpStatus;

}

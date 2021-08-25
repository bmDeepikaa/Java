package com.example.MainTest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//This annotation makes the rest api throw this following message if its a not found exception


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{


  private static final long serialVersionUID = 1L;
  
  public ResourceNotFoundException(String message) {
    super(message);
  }

}
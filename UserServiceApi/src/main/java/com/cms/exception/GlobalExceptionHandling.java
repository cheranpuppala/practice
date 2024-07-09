package com.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?>  handlingIdNotFoundException(IdNotFoundException ee){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ee.getMessage());
	}

}

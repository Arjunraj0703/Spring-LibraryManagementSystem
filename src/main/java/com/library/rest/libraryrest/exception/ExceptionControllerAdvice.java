package com.library.rest.libraryrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(ServiceException.class)
	ResponseEntity<ErrorMessage> throwServiceEx(ServiceException ex) {
		
		ErrorMessage errorMsg=new ErrorMessage("001",ex.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMsg,HttpStatus.FAILED_DEPENDENCY);
	}
	
	@ExceptionHandler(NullPointerException.class)
	String throwServiceEx(NullPointerException ex) {
		
		return ex.getMessage();
	}
}

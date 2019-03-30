package com.oufaaa.MyPosts.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmptyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptySearchException.class)
	public ResponseEntity<ExceptionDetails> handleEmptyException (EmptySearchException ex,WebRequest wrequest) {
		ExceptionDetails edetails=new ExceptionDetails(ex.getMessage(),wrequest.getDescription(false),new Date());
		return new ResponseEntity<ExceptionDetails>(edetails,ex.getStatus());
	}


	
	
}

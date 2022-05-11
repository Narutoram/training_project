package com.sportyshoes.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sportyshoes.api.exception.SportyshoesNotFoundException;

@ControllerAdvice
public class SportyshoesExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SportyshoesErrorResponse> handleException(Exception exc) {
		SportyshoesErrorResponse error = new SportyshoesErrorResponse();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<SportyshoesErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<SportyshoesErrorResponse> handleException(SportyshoesNotFoundException exc) {
		SportyshoesErrorResponse error = new SportyshoesErrorResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<SportyshoesErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

}

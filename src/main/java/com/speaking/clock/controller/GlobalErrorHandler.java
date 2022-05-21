package com.speaking.clock.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.speaking.clock.exception.EmptyStringException;
import com.speaking.clock.exception.ErrorDetails;
import com.speaking.clock.exception.InValidTimeFormatException;
import com.speaking.clock.exception.InvalidStringException;

@ControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler(value = EmptyStringException.class)
	public ResponseEntity<ErrorDetails> EmptyStringExceptionHandler(Exception e) {
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidStringException.class)
	public ResponseEntity<ErrorDetails> InvalidStringExceptionHandler(Exception e) {
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InValidTimeFormatException.class)
	public ResponseEntity<ErrorDetails> InValidTimeFormatExceptionHandler(Exception e) {
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
}

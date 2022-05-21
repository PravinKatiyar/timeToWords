package com.speaking.clock.exception;

import org.springframework.http.HttpStatus;

public class EmptyStringException extends RuntimeException {

	public EmptyStringException(String message) {
		super(message);
	}

}

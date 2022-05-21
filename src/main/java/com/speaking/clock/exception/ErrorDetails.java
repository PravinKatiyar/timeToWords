package com.speaking.clock.exception;

import java.lang.management.RuntimeMXBean;
import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String message;

	public ErrorDetails(Date timestamp, String message) {

		this.timestamp = timestamp;
		this.message = message;

	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

}
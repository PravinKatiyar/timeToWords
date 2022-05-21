package com.speaking.clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speaking.clock.entity.Time;
import com.speaking.clock.exception.EmptyStringException;
import com.speaking.clock.service.TimeService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class SpeakingClockController {

	@Autowired
	private TimeService iService;

	@GetMapping(value = "/time")
	public ResponseEntity<String> convertTimeToWords() throws EmptyStringException {
		String str = iService.convertTimeToWords();
		return new ResponseEntity<String>(str, HttpStatus.OK);

	}

	@PostMapping(value = "/time", consumes = "application/json")
	public ResponseEntity<String> convertTimeInputToWords(@RequestBody Time time) throws EmptyStringException {
		String str = iService.convertTimeInputToWords(time);
		return new ResponseEntity<String>(str, HttpStatus.OK);

	}

}

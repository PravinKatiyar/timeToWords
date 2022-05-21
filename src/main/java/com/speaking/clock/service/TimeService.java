package com.speaking.clock.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.speaking.clock.entity.Time;
import com.speaking.clock.exception.EmptyStringException;


public interface TimeService {

	String convertTimeToWords() throws EmptyStringException;

	String convertTimeInputToWords(Time time) throws EmptyStringException;

}

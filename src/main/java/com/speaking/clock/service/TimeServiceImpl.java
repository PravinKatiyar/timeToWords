package com.speaking.clock.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.speaking.clock.entity.Time;
import com.speaking.clock.exception.EmptyStringException;
import com.speaking.clock.exception.InValidTimeFormatException;
import com.speaking.clock.exception.InvalidStringException;
import com.speaking.clock.utils.Regex;

@Service
public class TimeServiceImpl implements TimeService {

	Pattern pattern = Pattern.compile(Regex.PATTERN);
	Pattern midnight_Pattern = Pattern.compile(Regex.MIDNIGHT_PATTERN);
	Pattern midday_Pattern = Pattern.compile(Regex.MIDDAY_PATTERN);
	Pattern twelve_to_one_am_Pattern = Pattern.compile(Regex.TWELVE_TO_ONE_AM_PATTERN);
	Pattern full_hour_Pattern = Pattern.compile(Regex.FULL_HOUR_PATTERN);

	@Override
	public String convertTimeInputToWords(Time time) throws EmptyStringException {
		if (time.getTime().isEmpty()) {
			throw new EmptyStringException("String is Empty");
		}
		return TimeToWord(time);

	}

	public String convertTimeToWords() throws EmptyStringException {
		return getCurrentTime();

	}

	public String getCurrentTime() throws EmptyStringException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String dateTimeNow = dtf.format(now).toString();

		Matcher matcher = pattern.matcher(dateTimeNow);

		Matcher midnightmatcher = midnight_Pattern.matcher(dateTimeNow);

		Matcher middaymatcher = midday_Pattern.matcher(dateTimeNow);

		Matcher twelve_to_one_am_Patternmatcher = twelve_to_one_am_Pattern.matcher(dateTimeNow);

		Matcher full_hour_Patternmatcher = full_hour_Pattern.matcher(dateTimeNow);

		if (midnightmatcher.matches()) {
			return "It's Midnight";

		} else if (middaymatcher.matches()) {
			return "It's Midday";

		} else if (twelve_to_one_am_Patternmatcher.matches()) {
			String x = dateTimeNow.substring(3);
			return "It's twelve " + convert_to_words(x.toCharArray());

		} else if (full_hour_Patternmatcher.matches()) {
			String[] strArr = dateTimeNow.split(":");
			String hours = convert_to_words(strArr[0].toCharArray());
			return "It's " + hours;

		}

		else if (matcher.matches()) {
			String[] stringArray = dateTimeNow.split(":");
			String hours = convert_to_words(stringArray[0].toCharArray());
			String minutes = convert_to_words(stringArray[1].toCharArray());
			return "It's " + hours + " " + minutes;

		} else {
			throw new InValidTimeFormatException("Time " + dateTimeNow + " is invalid 24 Hours Format");
		}
	}

	public String TimeToWord(Time time) throws EmptyStringException {

		String dateTimeNow = time.getTime();

		Matcher matcher = pattern.matcher(dateTimeNow);

		Matcher midnightmatcher = midnight_Pattern.matcher(dateTimeNow);

		Matcher middaymatcher = midday_Pattern.matcher(dateTimeNow);

		Matcher twelve_to_one_am_Patternmatcher = twelve_to_one_am_Pattern.matcher(dateTimeNow);

		Matcher full_hour_Patternmatcher = full_hour_Pattern.matcher(dateTimeNow);

		if (midnightmatcher.matches()) {
			return "It's Midnight";

		} else if (middaymatcher.matches()) {
			return "It's Midday";

		} else if (twelve_to_one_am_Patternmatcher.matches()) {
			String x = dateTimeNow.substring(3);
			return "It's twelve " + convert_to_words(x.toCharArray());

		} else if (full_hour_Patternmatcher.matches()) {
			String[] strArr = dateTimeNow.split(":");
			String hours = convert_to_words(strArr[0].toCharArray());
			return "It's " + hours;

		}

		else if (matcher.matches()) {
			String[] strArr = dateTimeNow.split(":");
			String hours = convert_to_words(strArr[0].toCharArray());
			String minutes = convert_to_words(strArr[1].toCharArray());
			return "It's " + hours + " " + minutes;

		} else {
			throw new InValidTimeFormatException("Time " + dateTimeNow + " is invalid 24 Hours Format");

		}
	}

	static String convert_to_words(char[] digitArray) throws EmptyStringException {
		String finalString = "";

		int len = digitArray.length;

		if (len > 2) {
			throw new InvalidStringException("Not a valid string");
		}

		String[] singleDigitsArray = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven",
				"eight", "nine" };

		String[] twoDigitsArray = new String[] { "", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
				"sixteen", "seventeen", "eighteen", "nineteen" };

		String[] tensMultipleArray = new String[] { "", "", "twenty", "thirty", "forty", "fifty" };

		if (len == 1) {
			return singleDigitsArray[digitArray[0] - '0'];
		}

		int x = 0;
		while (x < digitArray.length) {

			if (len <= 2) {

				if (digitArray[x] - '0' == 0 && digitArray[x + 1] - '0' == 0) {

					return "zero";
				}
				if (digitArray[x] - '0' == 1) {
					int sum = digitArray[x] - '0' + digitArray[x + 1] - '0';
					return twoDigitsArray[sum];
				}

				else if (digitArray[x] - '0' == 2 && digitArray[x + 1] - '0' == 0) {
					return "twenty";
				}

				else {
					int i = (digitArray[x] - '0');
					if (i > 0)
						finalString = finalString + tensMultipleArray[i] + " ";
					else
						System.out.print("");
					++x;
					if (digitArray[x] - '0' != 0)
						finalString = finalString + singleDigitsArray[digitArray[x] - '0'];
				}
			}
			++x;
		}
		return finalString;
	}

}
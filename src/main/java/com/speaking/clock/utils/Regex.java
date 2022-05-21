package com.speaking.clock.utils;

public class Regex {
	public static final String PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	public static final String MIDNIGHT_PATTERN = "00:00";

	public static final String FULL_HOUR_PATTERN = "([01]?[0-9]|2[0-3]):00";

	public static final String MIDDAY_PATTERN = "12:00";

	public static final String TWELVE_TO_ONE_AM_PATTERN = "00:[0-5][0-9]";
}

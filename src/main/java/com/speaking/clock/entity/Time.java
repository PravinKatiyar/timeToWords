package com.speaking.clock.entity;

public class Time {

	private String time;

	public Time(String time) {
		
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Time() {
		
	}

	@Override
	public String toString() {
		return "Time [time=" + time + "]";
	}

}

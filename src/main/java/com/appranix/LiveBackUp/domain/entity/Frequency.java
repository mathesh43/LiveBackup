package com.appranix.LiveBackUp.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Transient;

public class Frequency {

	private String[] hourlyTime;
	
	private String datilyTime;
	
	private String[] weeklyTime;

	public String[] getHourlyTime() {
		return hourlyTime;
	}

	public void setHourlyTime(String[] hourlyTime) {
		this.hourlyTime = hourlyTime;
	}

	public String getDatilyTime() {
		return datilyTime;
	}

	public void setDatilyTime(String datilyTime) {
		this.datilyTime = datilyTime;
	}

	public String[] getWeeklyTime() {
		return weeklyTime;
	}

	public void setWeeklyTime(String[] weeklyTime) {
		this.weeklyTime = weeklyTime;
	}
}

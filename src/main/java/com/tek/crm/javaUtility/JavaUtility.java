package com.tek.crm.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getDataFromJavaUtility(String key) {
		Random rom = new Random();
		int randomNumber = rom.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateYYYYDDMM() {

		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Date = sdf.format(dateObj);
		return Date;
	}

	public String getRequiredDateYYYYDDMM(int days) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);

		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String endDate = simpleDate.format(cal.getTime());
		return endDate;

	}

}

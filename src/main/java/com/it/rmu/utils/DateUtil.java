package com.it.rmu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static String dateToString(Date date) {
		if (null != date) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

			return formatter.format(date);
		}
		return null;
	}

	public static Date genDateNext() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 5);
		dt = c.getTime();
		return dt;
	}

	public static Date stringToDate(String dateString) {

		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static String dateToString2(Date date) {
		if (null != date) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
			return formatter.format(date);
		}
		return null;
	}
}

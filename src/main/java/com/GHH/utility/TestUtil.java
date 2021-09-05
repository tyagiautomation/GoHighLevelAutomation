package com.GHH.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static long EXPLICIT_WAIT = 30;

	public static String datestamp() {

		Date date = new Date(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy_HHmmss");
		format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String formattedDate = format.format(date);
		return formattedDate;
	}
}

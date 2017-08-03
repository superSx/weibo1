package com.core.util;

import java.util.Calendar;

public class DateUtil {
	public static int getYear(){
		Calendar calendar=Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
}

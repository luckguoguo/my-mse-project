package cn.edu.sjtu.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parseDefaultFormatDate(String str) throws ParseException {
		return DEFAULT_DATE_FORMAT.parse(str);
	}
	
	public static String formatDefaultDate(Date date) {
		return DEFAULT_DATE_FORMAT.format(date);
	}
	
	public static Date addDays(Date date, int days) {
		return org.apache.commons.lang.time.DateUtils.addDays(date, days);
	}
	
}

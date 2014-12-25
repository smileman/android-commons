package org.kulabukhov.android.commons.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Helper for working with dates. Contains methods for formatting dates.
 */
public class DateHelper {

	public static final long MILLISECONDS_PER_SECOND = 1000;
	private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * MILLISECONDS_PER_SECOND;

	private static SimpleDateFormat sdf = new SimpleDateFormat();

	/**
	 * Returns human readable date string in the following format: <pre>dd MMMM yyyy</pre>
	 * @param date date to format
	 * @return human readable string
	 */
	public static String humanReadableDate(Date date) {
		return formatDateWithPattern(date, "dd MMMM yyyy");
	}

	/**
	 * Returns human readable time string in the following format: <pre>HH:mm</pre>
	 * @param date date to format
	 * @return human readable string
	 */
	public static String humanReadableTime(Date date) {
		return formatDateWithPattern(date, "HH:mm");
	}

	/**
	 * Returns human readable time string in the following format: <pre>HH:mm</pre>
	 * @param date date to format
	 * @param timeZone timezone to format with
	 * @return human readable string
	 */
	public static String humanReadableTime(Date date, String timeZone) {
		return formatDateWithPattern(date, "HH:mm", timeZone);
	}

	/**
	 * Returns human readable datetime string in the following format: <pre>HH:mm, dd MMMM yyyy</pre>
	 * @param date date to format
	 * @return human readable string
	 */
	public static String humanReadableDateTime(Date date) {
		return formatDateWithPattern(date, "HH:mm, dd MMMM yyyy");
	}

	/**
	 * Returns human readable string representation for given date
	 * @param date date to format
	 * @param pattern pattern to format with. Eg. <pre>dd MMMM yyyy</pre>
	 * @return human readable string
	 */
	public static String formatDateWithPattern(Date date, String pattern) {
		return formatDateWithPattern(date, pattern, null);
	}

	/**
	 * Returns human readable string representation for given date
	 * @param date date to format
	 * @param pattern pattern to format with. Eg. <pre>dd MMMM yyyy</pre>
	 * @param timeZone timezone to format with
	 * @return human readable string
	 */
	public static String formatDateWithPattern(Date date, String pattern, String timeZone) {
		if (date == null) {
			return null;
		}
		sdf.applyPattern(pattern);
		if (timeZone != null) {
			sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		}

		return sdf.format(date);
	}

}

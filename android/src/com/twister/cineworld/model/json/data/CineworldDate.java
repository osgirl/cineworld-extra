package com.twister.cineworld.model.json.data;

import java.util.Calendar;
import java.util.regex.*;

import android.util.Log;

import com.twister.cineworld.model.json.request.DatesRequest;

/**
 * <p>
 * This query returns a list of dates that have programmed performances. The results can be filtered by supplying
 * optional film, date and cinema parameters. These can all take multiple values, so for example it is possible to
 * search for all dates on which a cinema is showing a particular film.
 * </p>
 * <p>
 * Example JSON:
 * 
 * <pre>
 * &quot;20120811&quot;
 * </pre>
 * 
 * </p>
 * 
 * @see DatesRequest
 */
public class CineworldDate extends CineworldBase {
	private String	m_date; // TODO int or calendar or anything

	/**
	 * @return Date (format yyyymmdd) there is a performance scheduled
	 */
	public String getDate() {
		return m_date;
	}

	public void setDate(final String date) {
		m_date = date;
	}

	/**
	 * Convenience method<br>
	 * TODO Refactor
	 * 
	 * @return
	 */
	public Calendar getCalendar() {
		Calendar calendar = null;
		if (getDate() != null) {
			Pattern pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");
			Matcher matcher = pattern.matcher(getDate());
			if (matcher.find()) {
				calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, Integer.parseInt(matcher.group(1)));
				calendar.set(Calendar.MONTH, Integer.parseInt(matcher.group(2)) - 1);
				calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(matcher.group(3)));
				calendar.set(Calendar.HOUR, 0); // set 0 am in current time zone
				calendar.clear(Calendar.MINUTE); // not affected by time zone
				calendar.clear(Calendar.SECOND); // not affected by time zone
				calendar.clear(Calendar.MILLISECOND); // not affected by time zone
			} else {
				Log.w(CineworldDate.class.getName(), "Invalid date: " + getDate());
			}
		} else {
			Log.w(CineworldDate.class.getName(), "Empty date");
		}
		return calendar;
	}
}

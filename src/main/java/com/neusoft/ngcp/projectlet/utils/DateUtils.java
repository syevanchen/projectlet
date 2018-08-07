package com.neusoft.ngcp.projectlet.utils;

import com.neusoft.ngcp.projectlet.exception.AppException;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
	private static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

	public static LocalDate parseDate(final String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		return LocalDate.parse(date, DATE_FORMATTER);
	}

	public static LocalDate parseShortDate(final String date) {
		if (date == null) {
			return null;
		}
		return LocalDate.parse(date, SHORT_DATE_FORMATTER);
	}

	public static String formatDate(final LocalDate date) {
		if (date == null) {
			return null;
		}
		return DATE_FORMATTER.format(date);
	}

	public static int age(final String date) {
		final LocalDate birth = LocalDate.parse(date, DATE_FORMATTER);
		final LocalDate now = LocalDate.now();
		return Period.between(birth, now).getYears();
	}

	public static int ageTime(final String date) {
		final LocalDate birth = LocalDate.parse(date, DATE_TIME_FORMATTER);
		final LocalDate now = LocalDate.now();
		return Period.between(birth, now).getYears();
	}


	public static LocalDate checkShortDateFormat(final String date, final String message) {
		if (StringUtils.isNotBlank(date)) {
			try {
				return DateUtils.parseShortDate(date);
			} catch (final Exception e) {
				throw new AppException(6, message);
			}
		}
		return null;
	}

}

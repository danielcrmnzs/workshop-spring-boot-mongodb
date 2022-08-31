package com.dcoimbra.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
		try {
			return LocalDate.parse(textDate, DateTimeFormatter.ISO_LOCAL_DATE);
		} catch (DateTimeParseException ex) {
			return defaultValue;
		}
	}

}

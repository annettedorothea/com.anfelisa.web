/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package de.acegen;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.util.StdConverter;

public class DateTimeToStringConverter extends StdConverter<LocalDateTime, String> {
	@Override
	public String convert(LocalDateTime value) {
		return value.toString();
	}
}



/******* S.D.G. *******/




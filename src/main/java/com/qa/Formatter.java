package com.qa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;

public abstract class Formatter {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

	@Bean
	public String formatter(LocalDate date) {
		return date.format(formatter);
	}

}

package com.capgemini.conferenceTests;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.conference.Person;

public class PersonTests {
	
	@Test
	public void shouldCalculateTheRightAge() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate today = LocalDate.parse("2017-07-13", formatter);
		
		LocalDate date1 = LocalDate.parse("1991-07-20", formatter);
		
		LocalDate date2 = LocalDate.parse("1987-01-01", formatter);
		
		int[] expectedAges = new int[2];
		expectedAges[0] = 25;
		expectedAges[1] = 30;
		
		int[] actualAges = new int[2];
		actualAges[0] = Person.calculateAge(date1, today);
		actualAges[1] = Person.calculateAge(date2, today);
		
		assertArrayEquals(expectedAges,actualAges);
	}
	
}

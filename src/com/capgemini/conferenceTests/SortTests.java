package com.capgemini.conferenceTests;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.conference.Person;
import com.capgemini.conference.Sort;

public class SortTests {
	
	@Test
	public void shouldReturnAListSortedByFirstName() {
		List<Person> list = new ArrayList<Person>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate date1 = LocalDate.parse("1991-07-20", formatter);
		Person somebody1 = new Person("Adam", "Marczak", date1, 26);
		list.add(somebody1);
		
		LocalDate date2 = LocalDate.parse("1972-08-13", formatter);
		Person somebody2 = new Person("Marta", "Kaczmarek", date2, 45);
		list.add(somebody2);
		
		LocalDate date3 = LocalDate.parse("1987-01-01", formatter);
		Person somebody3 = new Person("Krzysztof", "Andrus", date3, 30);
		list.add(somebody3);
		
		LocalDate date4 = LocalDate.parse("1947-12-28", formatter);
		Person somebody4 = new Person("Krystian", "Adamiak", date4, 70);
		list.add(somebody4);
		
		List<Person> testList = new ArrayList<Person>();
		testList.add(somebody1);
		testList.add(somebody4);
		testList.add(somebody3);
		testList.add(somebody2);
		
		Object[] expectedPeople = testList.toArray();
		Object[] actualPeople = Sort.sortByFirstName(list).toArray();
		
		assertArrayEquals(expectedPeople, actualPeople);
	}
	
	@Test
	public void shouldReturnAListSortedBySurname() {
		List<Person> list = new ArrayList<Person>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate date1 = LocalDate.parse("1991-07-20", formatter);
		Person somebody1 = new Person("Adam", "Marczak", date1, 26);
		list.add(somebody1);
		
		LocalDate date2 = LocalDate.parse("1972-08-13", formatter);
		Person somebody2 = new Person("Marta", "Kaczmarek", date2, 45);
		list.add(somebody2);
		
		LocalDate date3 = LocalDate.parse("1987-01-01", formatter);
		Person somebody3 = new Person("Krzysztof", "Andrus", date3, 30);
		list.add(somebody3);
		
		LocalDate date4 = LocalDate.parse("1947-12-28", formatter);
		Person somebody4 = new Person("Krystian", "Adamiak", date4, 70);
		list.add(somebody4);
		
		List<Person> testList = new ArrayList<Person>();
		testList.add(somebody4);
		testList.add(somebody3);
		testList.add(somebody2);
		testList.add(somebody1);
		
		Object[] expectedPeople = testList.toArray();
		Object[] actualPeople = Sort.sortBySurname(list).toArray();
		
		assertArrayEquals(expectedPeople, actualPeople);
	}
	
}

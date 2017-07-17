package com.capgemini.conferenceTests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.conference.DataProcessing;
import com.capgemini.conference.Person;
import com.capgemini.conference.UserInt;

public class DataProcessingTests {

	@Test
	public void shouldReturnTheALetterSortedList() {
		List<Person> list = new ArrayList<Person>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		UserInt.userOption = "a";
		
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
		
		Object[] expectedPeople = testList.toArray();
		Object[] actualPeople = DataProcessing.dataProc(list).get(0).toArray();
		
		assertArrayEquals(expectedPeople, actualPeople);
	}

	@Test
	public void shouldReturnTwoSortedLists() {
		List<Person> list = new ArrayList<Person>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		UserInt.userOption = "2";
		
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
		Person somebody4 = new Person("Krystian", "Tomiak", date4, 70);
		list.add(somebody4);
		
		List<Person> testList1 = new ArrayList<Person>();
		testList1.add(somebody2);
		testList1.add(somebody1);
		
		List<Person> testList2 = new ArrayList<Person>();
		testList2.add(somebody3);
		testList2.add(somebody4);
		
		Object[] expectedPeople1 = testList1.toArray();
		Object[] actualPeople1 = DataProcessing.dataProc(list).get(0).toArray();
		
		Object[] expectedPeople2 = testList2.toArray();
		Object[] actualPeople2 = DataProcessing.dataProc(list).get(1).toArray();
		
		assertArrayEquals(expectedPeople1, actualPeople1);
		assertArrayEquals(expectedPeople2, actualPeople2);
	}

}

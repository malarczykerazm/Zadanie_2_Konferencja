package com.capgemini.conference;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * stores people's data imported from an outside file
 * @author EMALARCZ
 *
 */
public class Person{

	String firstName;
	String surname;
	LocalDate dateOfBirth;
	int age;

	public Person(String firstName, String surname, LocalDate dateOfBirth, int age) {
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
	}

	/**
	 * calculates the age of a person on the basis of two LocalDates
	 * @param DateOfBirth an input data from an outside file
	 * @param today a LocalDate type data
	 * @return int type age
	 */
	public static int calculateAge(LocalDate DateOfBirth, LocalDate today) {
		String strDateOfBirth = DateOfBirth.toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfBirth = LocalDate.parse(strDateOfBirth, formatter);
		
		int age = Period.between(dateOfBirth, today).getYears();
		return age;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public int getAge() {
		return age;
	}

}
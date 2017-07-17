package com.capgemini.conferenceTests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.capgemini.conference.DataValEnum;
import com.capgemini.conference.DataValidation;
import com.capgemini.conference.NoFileException;
import com.capgemini.conference.WrongInputException;

public class DataValidationTests {

	@Test
	public void shouldReturnCHAR() throws NoFileException {
		String input = "s";
		DataValEnum.dVE type = DataValidation.dataVal(input);
		assertEquals(DataValEnum.dVE.CHAR, type);
	}

	@Test
	public void shouldReturnNUMBER() throws NoFileException {
		String input = "15";
		DataValEnum.dVE type = DataValidation.dataVal(input);
		assertEquals(DataValEnum.dVE.NUMBER, type);
	}
	
	@Test (expected = WrongInputException.class)
	public void shouldThrowAnExceptionNotADivisor() throws NoFileException {
		String input = "14";
		DataValEnum.dVE type = DataValidation.dataVal(input);
		assertEquals(WrongInputException.class, type);
	}
	
	@Test (expected = WrongInputException.class)
	public void shouldThrowAnExceptionString() throws NoFileException {
		String input = "#$sdasa";
		DataValEnum.dVE type = DataValidation.dataVal(input);
		assertEquals(WrongInputException.class, type);
	}
	
	@Test (expected = WrongInputException.class)
	public void shouldThrowAnExceptionNegativeNumber() throws NoFileException {
		String input = "-3";
		DataValEnum.dVE type = DataValidation.dataVal(input);
		assertEquals(WrongInputException.class, type);
	}
	
}

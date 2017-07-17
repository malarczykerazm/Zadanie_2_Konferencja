package com.capgemini.conference;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceMain {

	public static void main (String[] args) throws FileNotFoundException {
		List<List<Person>> sortedList = new ArrayList<List<Person>>();
		boolean itsTheRightInput = false;
		
		while (!(itsTheRightInput)) {
			try {
				UserInt.userInput();
				sortedList = DataProcessing.dataProc(InOut.dataIn());
				itsTheRightInput = true;
			} catch(WrongInputException e) {
				System.out.println(e.getMessage());
			}			
		}
		
		Print.dataPrint(sortedList);
	
		InOut.dataOut(sortedList);
	}
	
}
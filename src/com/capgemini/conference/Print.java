package com.capgemini.conference;

import java.util.List;

/**
 * prints data to the console
 * @author EMALARCZ
 *
 */
public class Print {
	
	/**
	 * prints Person objects' data from into the console
	 * @param lists list of lists of Person objects 
	 */
	static void dataPrint(List<List<Person>> lists) {
		for (int i = 0; i < lists.size(); i++) {
			System.out.println("----- " + "Lista nr " + (i+1) + " -----");
			for (int j = 0; j < lists.get(i).size(); j++) {
				Person somebody = lists.get(i).get(j);
				System.out.print(somebody.getFirstName() + ", ");
				System.out.print(somebody.getSurname() + ", ");
				System.out.print(somebody.getDateOfBirth() + ", ");
				System.out.println(somebody.getAge());	
			}
		}
	}
	
}

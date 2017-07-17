package com.capgemini.conference;

import java.util.ArrayList;
import java.util.List;

/**
 * data processing
 * @author EMALARCZ
 *
 */
public class DataProcessing {
	
	/**
	 * create a list of lists of people with a first name starting with certain letter
	 * or splits the input list into certain number of lists
	 * @param list of Person objects (list of people)
	 * @return list of sorted lists
	 */
	public static List<List<Person>> dataProc(List<Person> list) {
		try {
			DataValEnum.dVE	inputType = DataValidation.dataVal(UserInt.userOption);
			
			switch (inputType) {
			
			case CHAR:		return namesStartWith(list);
			
			case NUMBER:	return devidedList(list);
			
			default: 		return wrongInput();
			}
			
		} catch (NoFileException e) {
			System.out.println(e.getMessage());
			return wrongInput();
		}
	}

	/**
	 * chooses people with surname starting with a certain letter
	 * @param list
	 * @return a list with one sorted list of chosen people
	 */
	private static List<List<Person>> namesStartWith(List<Person> list){
		List<Person> listByFirstName = new ArrayList<Person>();
		char ch = UserInt.userOption.charAt(0);
		for (int i = 0; i < list.size(); i++) {
			Person somebody = list.get(i);
			if (somebody.getSurname().toLowerCase().charAt(0) == ch) {
				listByFirstName.add(somebody);
			}
		}
		listByFirstName = Sort.sortByFirstName(listByFirstName);
		List<List<Person>> listOfListsByFirstName = new ArrayList<List<Person>>();
		listOfListsByFirstName.add(listByFirstName);
		return listOfListsByFirstName;
	}
	
	/**
	 * splits list of people into certain number of lists
	 * @param list of people
	 * @return list of sorted lists of people
	 */
	private static List<List<Person>> devidedList(List<Person> list){
				int numb = Integer.parseInt(UserInt.userOption);
		List<List<Person>> listOfListsBySurname = new ArrayList<List<Person>>();
		for (int i = 0; i < list.size() / numb; i++) {
			List<Person> listBySurname = new ArrayList<Person>();
			for (int j = 0; j < numb; j++) {
				Person somebody = list.get(i * numb + j);
				listBySurname.add(somebody);
			}
			listBySurname = Sort.sortBySurname(listBySurname);
			listOfListsBySurname.add(listBySurname);
		}
		return listOfListsBySurname;
	}
	
	private static List<List<Person>> wrongInput(){
		List<List<Person>> emptyList = new ArrayList<List<Person>>();
		return emptyList;
	}
	
}
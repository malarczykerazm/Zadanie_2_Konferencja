package com.capgemini.conference;

import java.util.List;

/**
 * sorts list of Person objects
 * @author EMALARCZ
 *
 */
public class Sort {
	
	/**
	 * sorts people alphabetically by their first name
	 * @param list of Person objects
	 * @return sorted list of Person objects
	 */
	public static List<Person> sortByFirstName(List<Person> list){
		Person temp;
		String name;
		String nextName;
		for (int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size()-1; j++) {
				name = list.get(j).getFirstName();
				nextName = list.get(j+1).getFirstName();
				if (name.compareToIgnoreCase(nextName) > 0) {
					temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}		
			} 
		}
		return list;
	}
	
	/**
	 * sorts people alphabetically by their surname
	 * @param list of Person objects
	 * @return sorted of Person objects
	 */
	public static List<Person> sortBySurname(List<Person> list){
		Person temp;
		String name;
		String nextName;
		for (int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size()-1; j++) {
				name = list.get(j).getSurname();
				nextName = list.get(j+1).getSurname();
				if (name.compareToIgnoreCase(nextName) > 0) {
					temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}		
			} 
		}
		return list;
	}
	
	
}

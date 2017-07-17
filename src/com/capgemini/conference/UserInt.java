package com.capgemini.conference;

import java.util.Scanner;

/**
 * user interface
 * @author EMALARCZ
 *
 */
public class UserInt {
	
	public static String userOption;
	
	/**
	 * gets user's input and saves it in the public static String
	 * @return user's input
	 */
	static String userInput() {
		System.out.print("Podaj literę lub liczbę: ");
		Scanner uI = new Scanner(System.in);
		userOption = uI.nextLine().toLowerCase();
		return userOption;
	}
	
}

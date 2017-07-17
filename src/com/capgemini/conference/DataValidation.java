package com.capgemini.conference;

/**
 * validates the data
 * @author EMALARCZ
 *
 */
public class DataValidation {
	
	/**
	 * checks if the input is a number, a letter or throws an exception in case
	 * of wrong input
	 * @param input
	 * @return enum value of NUMBER/CHAR or throws an exception
	 * @throws NoFileException
	 */
	public static DataValEnum.dVE dataVal(String input) throws NoFileException {
		if (input.matches("[\\d]+")) {
			return numVal(Integer.parseInt(input));	
		} else {
			return textVal(input);
		}
	}
	
	private static DataValEnum.dVE numVal(int numInput) throws NoFileException {
		if (numInput <= 0) {
			throw new WrongInputException("Wprowadzona liczba musi być dodatnia. Spróbuj ponownie.");
		} else if ((InOut.dataIn().size() % numInput) != 0) {
			throw new WrongInputException("Wprowadzona liczba nie jest dzielnikiem liczby uczestników konferencji. Spróbuj ponownie.");			
		} else {
			return DataValEnum.dVE.NUMBER;
		}
	}
	
	private static DataValEnum.dVE textVal(String input) throws NoFileException {
		if (input.charAt(0) >= 'a' && input.charAt(0) <= 'z' && input.length() == 1) {
			return DataValEnum.dVE.CHAR;
		} else {
			throw new WrongInputException("Wprowadzono błędne dane (ciąg znaków, liczbę ujemną, bądź liczbę niecałkowitą). Spróbuj ponownie.");			
		}
	}

}
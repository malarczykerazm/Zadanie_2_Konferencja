package com.capgemini.conference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * I/O service
 * @author EMALARCZ
 *
 */
public class InOut {
	
	static File file = new File("konferencja.csv");

	/**
	 * create a list of people on the basis of the file
	 * @return list of people
	 * @throws NoFileException in case of no file
	 */
	static List<Person> dataIn() throws NoFileException {
		Person somebody;
		ArrayList<Person> list = new ArrayList<Person>();
		Scanner inputData;
		try {
			inputData = new Scanner(file);
		} catch(FileNotFoundException e) {
			throw new NoFileException("Nie znaleziono pliku \"konferencja.csv\". Wprowadź plik do folderu z programem i spróbuj ponownie.");
		}
		String[] line;

		while (inputData.hasNextLine()) {
				line = inputData.nextLine().split(",");	

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateOfBirth = LocalDate.parse(line[2], formatter);
			
				int age = Person.calculateAge(dateOfBirth, LocalDate.now());
			
				somebody = new Person(line[0], line[1], dateOfBirth, age);
		
				list.add(somebody);
		}
		inputData.close();
		return list;
	}

	/**
	 * output list of lists of Person objects into *.csv files
	 * @param lists list of lists of Person objects
	 * @throws FileNotFoundException
	 */
	static void dataOut(List<List<Person>> lists) throws FileNotFoundException {
		Person somebody;
		String fileTitle;
		DataValEnum.dVE type = DataValidation.dataVal(UserInt.userOption);
			
		for (int i = 0; i < lists.size(); i++) {

			switch (type) {
			
				case CHAR:		fileTitle = ("uczestnicy_" + (UserInt.userOption).toUpperCase() + ".csv");
								break;
			
				case NUMBER:	fileTitle = ("uczestnicy_" + "lista_nr_" + (i+1) + ".csv");
								break;
									
				default: 		fileTitle = ("uczestnicy.csv");
								break;
			}					
					
			PrintWriter outputData;
			
			outputData = new PrintWriter(new File(fileTitle));
			
			for (int j = 0; j < lists.get(i).size(); j++) {
				somebody = lists.get(i).get(j);
				outputData.print(somebody.getFirstName() + ",");
				outputData.print(somebody.getSurname() + ",");
				outputData.println(somebody.getAge());	
			}
			outputData.close();
		}
	}
	
}

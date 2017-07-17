package com.capgemini.conference;

import java.io.FileNotFoundException;

public class NoFileException extends FileNotFoundException {

	private static final long serialVersionUID = 1L;

	public NoFileException(String message) {
		super(message);
	}
}



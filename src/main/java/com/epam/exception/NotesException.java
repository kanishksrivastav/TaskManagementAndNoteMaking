package com.epam.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotesException extends Exception{
	private static Logger LOGGER=LogManager.getLogger(NotesException.class);
	public NotesException() {
		
	}

	public NotesException(String message) {
		LOGGER.error(message);
	}
	
}

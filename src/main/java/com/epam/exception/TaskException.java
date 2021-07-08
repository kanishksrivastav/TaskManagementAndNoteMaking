package com.epam.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskException extends Exception {
	private static Logger LOGGER=LogManager.getLogger(TaskException.class);
	public TaskException() {
		
	}

	public TaskException(String message) {
		LOGGER.error(message);
	}
}

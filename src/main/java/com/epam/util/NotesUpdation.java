package com.epam.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.exception.NotesException;
import com.epam.model.Notes;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class NotesUpdation implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(NotesUpdation.class);
	public void updateNotes(FindTask obj) {
		Task tmp = obj.findTask();
		if(tmp == null) {
			return ;
		}
		LOGGER.info(Constants.ENTER_NOTES_ID);
		int notesId = sc.nextInt();
		sc.nextLine();
		LOGGER.info(notesId);
		try {
			Notes obj2 = tmp.getNotesList().get(notesId-1);
			LOGGER.info(Constants.ENTER_NEW_NOTES_DESCRIPTION);
			obj2.setNotesDescription(sc.nextLine());
			LOGGER.info(Constants.NOTES_UPDATED_SUCCESSFULLY);
		}catch(Exception e) {
			try {
				throw new NotesException(Constants.NOTES_ID_NOT_FOUND);
			}catch(NotesException e1) {LOGGER.info(e1);}
		}
	}
}

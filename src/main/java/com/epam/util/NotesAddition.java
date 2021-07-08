package com.epam.util;

import javax.persistence.EntityTransaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
//import com.epam.dao.NotesDaoImpl;
import com.epam.model.Notes;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class NotesAddition implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(NotesAddition.class);
	public int NOTES_ID = 1;

	public void addNotesToTask(FindTask obj) {
		Task tmp = obj.findTask();
		if(tmp != null) {
			Notes note = new Notes();
			LOGGER.info(Constants.ENTER_NOTES_DESCRIPTION);
			note.setNotesID(NOTES_ID++);
			note.setNotesDescription(sc.nextLine());
			tmp.addNotes(note);
			
			LOGGER.info(Constants.NOTES_ADDED_SUCCESSFULLY);
		}
	}
}

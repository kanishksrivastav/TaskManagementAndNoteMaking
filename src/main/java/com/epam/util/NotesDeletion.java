package com.epam.util;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.exception.NotesException;
import com.epam.model.Notes;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class NotesDeletion implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(NotesDeletion.class);
	
	public void deleteNotes(FindTask obj) {
		Task tmp = obj.findTask();
		if(tmp == null) {
			return ;	
		}
		List<Notes> notesList = tmp.getNotesList();
		try {
			if(notesList.isEmpty()){
				throw new NotesException(Constants.EMPTY_NOTES_LIST);
			}
		}catch(Exception e) {
			LOGGER.info(e);
			return ;
		}
		LOGGER.info(Constants.ENTER_NOTES_ID_TO_BE_DELETED);
		int notesId = sc.nextInt();
		sc.nextLine();
		LOGGER.info(notesId);
		try {
			Iterator<Notes> itr = notesList.iterator();
			while(itr.hasNext()) {
				Notes tempNote = itr.next();
				if(tempNote.getNotesID() == notesId) {
					notesList.remove(tempNote);
					LOGGER.info(Constants.NOTES_DELETED_SUCCESSFULLY);
					return ;
				}
			}
			throw new NotesException(Constants.NOTES_ID_NOT_FOUND);
		}catch(Exception e) {
			LOGGER.info(e);
		}
	}	
}

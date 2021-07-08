package com.epam.ui;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.formatter.TextTable;
import com.epam.model.Notes;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;
import com.epam.util.FindTask;

public class DisplayNotes implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(DisplayNotes.class);
	private String[][] tableData;
	
	public void displayNotes(FindTask obj) {
		EntityTransaction trans = eManager.getTransaction();
		trans.begin();
		Task tmp = obj.findTask();
		if(tmp == null) {
			return ;
		}
		List<Notes> li = tmp.getNotesList();
		if(li.isEmpty()) {
			LOGGER.info(Constants.EMPTY_NOTES_LIST);
			return ;
		}
		int k=0;
		this.tableData = new String[li.size()+1][];
		this.tableData[0] = new String[]{Constants.ID, Constants.NOTES};
		Iterator<Notes> itr = li.iterator();
		while(itr.hasNext()) {
			this.tableData[++k] = itr.next().toStringArray();
		}
		TextTable.printTable(this.tableData);
		trans.commit();
	}
}

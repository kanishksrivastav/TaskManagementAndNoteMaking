package com.epam.ui;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.exception.TaskException;
import com.epam.formatter.TextTable;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class AllTasksDisplay  implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(AllTasksDisplay.class);
	private String[][] tableData;
	public void displayAllTasks() {
		try {

			if(taskList.isEmpty())
				throw new TaskException(Constants.EMPTY_TASK_LIST);
			else {
				this.tableData = new String[taskList.size()+1][];
				int k=0;
				this.tableData[0] = new String[]{Constants.ID, Constants.TITLE, Constants.START_DATE_TIME, Constants.END_DATE_TIME, Constants.STATUS, Constants.NOTES};
				Iterator<Task> itr = taskList.iterator();
				while(itr.hasNext()) {
					this.tableData[++k] = itr.next().toStringArray();

				}
				TextTable.printTable(this.tableData);
			}
		}catch(TaskException e) {
			LOGGER.info(e);
		}
	}
}

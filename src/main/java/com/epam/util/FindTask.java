package com.epam.util;

import java.util.Iterator;

import javax.persistence.EntityTransaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.exception.TaskException;
import com.epam.formatter.TextTable;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class FindTask implements TaskServiceVariables{
	private String[][] tableData;
	private Logger LOGGER=LogManager.getLogger(FindTask.class);
	
	public void findTaskUtil() {
		
		Task task = findTask();
		if(task == null) {
			return ;
		}
		this.tableData = new String[2][];
		this.tableData[0] = new String[]{Constants.ID, Constants.TITLE, Constants.START_DATE_TIME, Constants.END_DATE_TIME, Constants.STATUS, Constants.NOTES};
		this.tableData[1] = task.toStringArray();
		TextTable.printTable(this.tableData);
	}
	
	public Task findTask(int... params) {
		int taskId;
		EntityTransaction trans = eManager.getTransaction();
		trans.begin();
		
		if(params.length == 0) {
			LOGGER.info(Constants.ENTER_TASK_ID);
			taskId = sc.nextInt();
			
			sc.nextLine();		
			Task task=eManager.find(Task.class, taskId);
			System.out.println(task);
		}
		else{
			taskId = params[0];
		}
		Iterator<Task> itr = taskList.iterator();
		Task task = null;
		while(itr.hasNext()) {
			Task tmp = itr.next();
			if(tmp.getTaskID() ==  taskId) {
				task =  tmp;
				break;
			}
		}
		if(task == null) {
			try {
				throw new TaskException(Constants.TASK_ID_NOT_FOUND);
			}catch(TaskException e) {
				LOGGER.info(e);
			}
		}
		eManager.getTransaction().commit();
		return task;
	}
}

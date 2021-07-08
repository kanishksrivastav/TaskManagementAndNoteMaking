package com.epam.util;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class TaskDeletion implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(TaskDeletion.class);

	public void deleteTask(FindTask obj, SlotsRemoval obj2, int... params){
		Task tmp = obj.findTask(params);
		if(tmp != null) {
			LocalDateTime[] tempTimeSlot = {tmp.getTaskStartDateTime(), tmp.getTaskEndDateTime()};
			obj2.removeSlot(tempTimeSlot);
			taskList.remove(tmp);
			LOGGER.info(Constants.TASK_DELETED);
		}
	}	

}

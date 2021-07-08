package com.epam.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.exception.TaskException;
import com.epam.model.Task;
import com.epam.service.DateTimeValidation;
import com.epam.service.TaskServiceVariables;
public class TaskUpdation implements TaskServiceVariables{
	private Logger LOGGER=LogManager.getLogger(TaskUpdation.class);
	public void updateTask(FindTask obj, SlotsRemoval obj2, int... params) {
		Task task = obj.findTask(params);
		Map<Integer, Runnable> updateMenu = new HashMap<>();
		updateMenu.put(1, ()->updateTitle(task));
		updateMenu.put(2, ()->updateDateTime(task, obj2));
		updateMenu.put(3, ()->updateStatus(task));
		if(task == null) {
			try {
				throw new TaskException(Constants.TASK_ID_NOT_FOUND);
			}catch(TaskException e) {
				LOGGER.info(e);
			}
			return ;
		}
		LOGGER.info(Constants.ENTER_CHOICE);
		LOGGER.info(Constants.EDIT_TASK_TITLE);
		LOGGER.info(Constants.EDIT_TASK_DATETIME);
		LOGGER.info(Constants.EDIT_TASK_STATUS);
		int choice = sc.nextInt();
		sc.nextLine();
		LOGGER.info(choice);
		updateMenu.get(choice).run();
	}
	public void updateTitle(Task task) {
		LOGGER.info(Constants.ENTER_NEW_TASK_TITLE);
		task.setTaskTitle(sc.nextLine());
		LOGGER.info(Constants.TITLE_UPDATED_SUCCESSFULLY);
	}
	public void updateDateTime(Task task, SlotsRemoval obj2) {
		LocalDateTime[] tempTimeSlot = {task.getTaskStartDateTime(), task.getTaskEndDateTime()};
		LocalDateTime start = null;
		LocalDateTime end = null;
		LOGGER.info(Constants.ENTER_NEW_START_DATETIME);
		start = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
		LOGGER.info(start);
		LOGGER.info(Constants.ENTER_NEW_END_DATETIME);
		end = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
		LOGGER.info(end);
		while(!DateTimeValidation.isDateTimeValid(start, end)) {
			LOGGER.info(Constants.ENTER_DATETIME_IN_CORRECT_FORMAT);
			LOGGER.info(Constants.ENTER_NEW_START_DATETIME);
			start = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
			LOGGER.info(start);
			LOGGER.info(Constants.ENTER_NEW_END_DATETIME);
			end = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
			LOGGER.info(end);
		}
		LocalDateTime[] timeSlot = new LocalDateTime[]{start, end};
		while(!DateTimeValidation.isDateTimeNotConflicting(timeSlot)) {
			LOGGER.info(Constants.SLOT_OCCUPIED);
			LOGGER.info(Constants.ENTER_NEW_START_DATETIME);
			start = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
			LOGGER.info(start);
			LOGGER.info(Constants.ENTER_NEW_END_DATETIME);
			end = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
			LOGGER.info(end);
			while(!DateTimeValidation.isDateTimeValid(start, end)) {
				LOGGER.info(Constants.ENTER_DATETIME_IN_CORRECT_FORMAT);
				LOGGER.info(Constants.ENTER_NEW_START_DATETIME);
				start = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
				LOGGER.info(start);
				LOGGER.info(Constants.ENTER_NEW_END_DATETIME);
				end = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
				LOGGER.info(end);
			}
			timeSlot = new LocalDateTime[]{start, end};
		}
		obj2.removeSlot(tempTimeSlot);
		task.setTaskStartDateTime(start);
		task.setTaskEndDateTime(end);

		LOGGER.info(Constants.DATETIME_UPDATED);
	}
	public void updateStatus(Task task) {
		LOGGER.info(Constants.ENTER_NEW_TASK_STATUS);
		task.setTaskStatus(sc.nextLine());
		LOGGER.info(Constants.TASK_STATUS_UPDATED);
	}
}

package com.epam.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.model.Task;
import com.epam.service.DateTimeValidation;
import com.epam.service.TaskServiceVariables;
public class TaskCreation implements TaskServiceVariables{
	static private int TASK_ID;
	static DateTimeFormatter dateTimeFormat = Task.getDatetimeformat();
	private Logger LOGGER=LogManager.getLogger(TaskCreation.class);
	public Task createTask() {
		Task task = null;
		EntityTransaction entityTransaction = null;	
		try {
			entityTransaction = eManager.getTransaction();
			entityTransaction.begin();
			
			task = new Task();
			task.setTaskID(TASK_ID++);
			LOGGER.info(Constants.ENTER_TASK_TITLE);
			String title=sc.nextLine();
			task.setTaskTitle(title);
			LOGGER.info(title);
			LocalDateTime start = null;
			LocalDateTime end = null;
			LOGGER.info(Constants.ENTER_START_DATETIME);
			start = LocalDateTime.parse(sc.nextLine(), dateTimeFormat);
			LOGGER.info(start);
			LOGGER.info(Constants.ENTER_END_DATETIME);
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
			task.setTaskStartDateTime(start);
			task.setTaskEndDateTime(end);
			LOGGER.info(Constants.ENTER_TASK_STATUS);
			String status=sc.nextLine();
			task.setTaskStatus(status);
			LOGGER.info(status);
			taskList.add(task);		
	
			eManager.merge(task);
			entityTransaction.commit();
			
			LOGGER.info(Constants.TASK_CREATED+task.getTaskID());
		}catch(Exception e) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
				throw e;
			}
			LOGGER.info(e);  
			TASK_ID--;
			return null;
		}
		return task;
	}
}

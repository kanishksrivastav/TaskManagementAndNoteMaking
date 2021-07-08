package com.epam.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class FindTaskOnDate implements TaskServiceVariables{
	
	private Logger LOGGER=LogManager.getLogger(FindTaskOnDate.class);
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public List<Task> findTasksWithStartDate() {
		LOGGER.info("Enter Start Date as dd/MM/yyyy");
		LocalDate date = LocalDate.parse(sc.nextLine(), dateFormat);
		LOGGER.info(date);
		List<Task> response = new ArrayList<Task>();
		Iterator<Task> itr = taskList.iterator();
		while(itr.hasNext()) {
			Task temp = itr.next();
			if(temp.getTaskStartDateTime().toLocalDate().equals(date)) {
				response.add(temp);
			}
		}
		return response;
	}
	
	public List<Task> findTasksWithEndDate() {
		LOGGER.info("Enter End Date Time as dd/MM/yyyy");
		LocalDate date = LocalDate.parse(sc.nextLine(), dateFormat);
		LOGGER.info(date);
		List<Task> response = new ArrayList<Task>();
		Iterator<Task> itr = taskList.iterator();
		while(itr.hasNext()) {
			Task temp = itr.next();
			if(temp.getTaskEndDateTime().toLocalDate().equals(date)) {
				response.add(temp);
			}
		}
		return response;
	}
}
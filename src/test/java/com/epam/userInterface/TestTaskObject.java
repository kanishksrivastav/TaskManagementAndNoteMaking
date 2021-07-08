package com.epam.userInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class TestTaskObject {
	public static DateTimeFormatter dateTimeFormat = Task.getDatetimeformat();
	public static Task task;
	
	public static Task getTestObject() {
		task = new Task();
		task.setTaskID(101);
		task.setTaskTitle("MyTestTask");
		task.setTaskStartDateTime(LocalDateTime.parse("27/07/2021 10:00", dateTimeFormat));
		task.setTaskEndDateTime(LocalDateTime.parse("27/07/2021 12:00", dateTimeFormat));
		task.setTaskStatus("active");
		return task;
	}
	
	public static Task getUpdatedTitleTestObject() {
		task = getTestObject();
		task.setTaskTitle("MyUpdatedTestTask");
		return task;
	}
	
	public static Task getUpdatedDateTimeTestObject() {
		task = getTestObject();
		task.setTaskStartDateTime(LocalDateTime.parse("27/07/2021 14:00", dateTimeFormat));
		task.setTaskEndDateTime(LocalDateTime.parse("27/07/2021 16:00", dateTimeFormat));
		return task;
	}
	
	public static Task getUpdatedStatusTestObject() {
		task = getTestObject();
		task.setTaskStatus("done");
		return task;
	}
	
	public static void addTestObject(Task task) {
		TaskServiceVariables.taskList.add(task);
	}
	
	public static void removeTestObject(Task task) {
		TaskServiceVariables.taskList.remove(task);
	}

}

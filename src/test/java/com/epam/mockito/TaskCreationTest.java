package com.epam.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.model.Task;
import com.epam.userInterface.TestTaskObject;
import com.epam.util.TaskCreation;

class TaskCreationTest {
	EntityManager entityManager;
	TaskCreation taskCreation;
	static DateTimeFormatter dateTimeFormat;
	public static Task task;

	@BeforeEach
	void setup() {
		entityManager=mock(EntityManager.class);
		taskCreation=mock(TaskCreation.class);
	}
//	public static Task getTestObject() {
//		task = new Task();
//		task.setTaskID(101);
//		task.setTaskTitle("MyTestTask");
//		task.setTaskStartDateTime(LocalDateTime.parse("27/07/2021 10:00", dateTimeFormat));
//		task.setTaskEndDateTime(LocalDateTime.parse("27/07/2021 12:00", dateTimeFormat));
//		task.setTaskStatus("active");
//		return task;
//	}
	@Test
	void createTaskTest() {
		Task expectedTask=TestTaskObject.getTestObject();
		doNothing().when(entityManager).persist(expectedTask);
		Task actualTask=new TaskCreation().createTask();
		assertEquals(expectedTask,actualTask);
	}
}


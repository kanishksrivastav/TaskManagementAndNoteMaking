package com.epam.userInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.epam.model.Task;
import com.epam.util.TaskCreation;

class TaskCreationTest {

	@Test
	void testCreateTask() {
		Task expected = TestTaskObject.getTestObject();
		
		TaskCreation obj = new TaskCreation();
		Task actual = obj.createTask();
		
		assertEquals(expected, actual);
	}
	
	@AfterEach
	void afterTestSetup() {
		TestTaskObject.removeTestObject(TestTaskObject.getTestObject());
	}

}

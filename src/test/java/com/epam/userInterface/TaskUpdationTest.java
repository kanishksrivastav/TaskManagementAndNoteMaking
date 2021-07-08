package com.epam.userInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.model.Task;
import com.epam.util.FindTask;
import com.epam.util.SlotsRemoval;
import com.epam.util.TaskUpdation;

class TaskUpdationTest {
	
	Task task;
	
	@BeforeEach
	void beforeTestSetup() {
		task = TestTaskObject.getTestObject();
		TestTaskObject.addTestObject(task);
	}

	@Test
	void testUpdateTitle() {
		TaskUpdation obj = new TaskUpdation();
		obj.updateTask(new FindTask(), new SlotsRemoval(), 101);
		
		//Task expected = TestTaskObject.getUpdatedTitleTestObject();
		Task actual = new FindTask().findTask(101);
		
		assertEquals(task, actual);
	}
	
	@Test
	void testUpdateDateTime() {
		TaskUpdation obj = new TaskUpdation();
		obj.updateTask(new FindTask(), new SlotsRemoval(), 101);
		
		//Task expected = TestTaskObject.getUpdatedDateTimeTestObject();
		Task actual = new FindTask().findTask(101);
		assertEquals(task, actual);	
	}
	
	@Test
	void testUpdateStatus() {
		TaskUpdation obj = new TaskUpdation();
		obj.updateTask(new FindTask(), new SlotsRemoval(), 101);
		
		//Task expected = TestTaskObject.getUpdatedStatusTestObject();
		Task actual = new FindTask().findTask(101);
		
		assertEquals(task, actual);
	}

	@AfterEach
	void afterTestSetup() {
		//Task task = TestTaskObject.getTestObject();
		TestTaskObject.removeTestObject(task);
	}

}

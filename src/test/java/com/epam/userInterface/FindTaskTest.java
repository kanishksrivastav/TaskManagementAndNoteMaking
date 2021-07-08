package com.epam.userInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.model.Task;
import com.epam.util.FindTask;

class FindTaskTest {
	
	Task task;
	
	@BeforeEach
	void beforeTestSetup() {
		task = TestTaskObject.getTestObject();
		TestTaskObject.addTestObject(task);
	}

	@Test
	void test() {
		FindTask findTask = new FindTask();
		Task actual = findTask.findTask(101);
		assertEquals(task, actual);
	}
	
	@AfterEach
	void afterTestSetup() {
		TestTaskObject.removeTestObject(task);
	}
}

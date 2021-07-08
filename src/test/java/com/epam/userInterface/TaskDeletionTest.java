package com.epam.userInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;
import com.epam.util.FindTask;
import com.epam.util.SlotsRemoval;
import com.epam.util.TaskDeletion;

class TaskDeletionTest {
	
	@BeforeEach
	void beforeTestSetup(){
		Task task = TestTaskObject.getTestObject();
		TestTaskObject.addTestObject(task);
	}

	@Test
	void test() {
		int beforeDeletionSize = TaskServiceVariables.taskList.size();
		
		TaskDeletion obj = new TaskDeletion();
		obj.deleteTask(new FindTask(), new SlotsRemoval(), 101);
		
		int afterDeletionSize = TaskServiceVariables.taskList.size();
		
		if(beforeDeletionSize-1 != afterDeletionSize) {
			fail();
		}	
	}
	

}

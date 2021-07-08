package com.epam.userInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.model.Notes;
import com.epam.model.Task;
import com.epam.util.FindTask;
import com.epam.util.NotesAddition;

class NotesAdditionTest {
	
	Notes obj; Task task;

	@BeforeEach
	void beforeTestSetup() {
		task= TestTaskObject.getTestObject();
		obj= new Notes();
		obj.setNotesID(1);
		obj.setNotesDescription("SampleNotes");
		task.addNotes(obj);
	}
	
	@Test
	void notesAdditionTest() {
		Task task= TestTaskObject.getTestObject();
		TestTaskObject.addTestObject(task);
		NotesAddition obj = new NotesAddition();
		obj.addNotesToTask(new FindTask());
		assertEquals(this.task, task);
		
	}

}

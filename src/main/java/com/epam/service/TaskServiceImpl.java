package com.epam.service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.exception.TaskException;
import com.epam.formatter.TextTable;
import com.epam.model.Task;
import com.epam.ui.AllTasksDisplay;
import com.epam.ui.DisplayMenu;
import com.epam.ui.DisplayNotes;
import com.epam.ui.Exit;
import com.epam.util.FindTask;
import com.epam.util.FindTaskOnDate;
import com.epam.util.GetTaskList;
import com.epam.util.NotesAddition;
import com.epam.util.NotesDeletion;
import com.epam.util.NotesUpdation;
import com.epam.util.SlotsRemoval;
import com.epam.util.TaskCreation;
import com.epam.util.TaskDeletion;
import com.epam.util.TaskUpdation;

public class TaskServiceImpl implements TaskService{
	
	Logger logger=LogManager.getLogger(TaskServiceImpl.class);
	
	AllTasksDisplay allTasksDisplay;
	DisplayMenu displayMenu;
	DisplayNotes displayNotes;
	Exit exit;
	FindTask findTask;
	GetTaskList getTaskList;
	NotesAddition notesAddition;
	NotesDeletion notesDeletion;
	NotesUpdation notesUpdation;
	SlotsRemoval slotsRemoval;
	TaskCreation taskCreation;
	TaskDeletion taskDeletion;
	TaskUpdation taskUpdation;
	FindTaskOnDate findTaskOnDate;
	

	public TaskServiceImpl() {
		this.allTasksDisplay = new AllTasksDisplay();
		this.displayMenu = new DisplayMenu();
		this.displayNotes = new DisplayNotes();
		this.exit = new Exit();
		this.findTask = new FindTask();
		this.getTaskList = new GetTaskList();
		this.notesAddition = new NotesAddition();
		this.notesDeletion = new NotesDeletion();
		this.notesUpdation = new NotesUpdation();
		this.slotsRemoval = new SlotsRemoval();
		this.taskCreation = new TaskCreation();
		this.taskDeletion = new TaskDeletion();
		this.taskUpdation = new TaskUpdation();
		this.findTaskOnDate = new FindTaskOnDate();
		
	}

	@Override
	public void showMenu() {
		this.displayMenu.showMenu();
	}

	@Override
	public void createTask() {
		
		this.taskCreation.createTask();
	}

	@Override
	public Task findTask() {
		return this.findTask.findTask();
	}
	
	@Override
	public void findTaskUtil() {
		Task task = findTask();
		if(task == null) {
			return ;
		}
		String[][] tableData = new String[2][];
		tableData[0] = new String[]{Constants.ID, Constants.TITLE, Constants.START_DATE_TIME, Constants.END_DATE_TIME, Constants.STATUS, Constants.NOTES};
		tableData[1] = task.toStringArray();
		TextTable.printTable(tableData);
	}

	@Override
	public void removeSlot(LocalDateTime[] tempTimeSlot) {

		this.slotsRemoval.removeSlot(tempTimeSlot);
	}

	@Override
	public void deleteTask() {
		this.taskDeletion.deleteTask(this.findTask, this.slotsRemoval);
	}

	@Override
	public void updateTask() {
		this.taskUpdation.updateTask(this.findTask, this.slotsRemoval);
	}

	@Override
	public List<Task> getTaskList() {
		List<Task> taskList = this.getTaskList.getTaskList();
		String[][] tableData;
		try {
			if(taskList.isEmpty())
				throw new TaskException(Constants.EMPTY_TASK_LIST);
			else {
				tableData = new String[taskList.size()+1][];
				int k=0;
				tableData[0] = new String[]{Constants.ID, Constants.TITLE, Constants.START_DATE_TIME, Constants.END_DATE_TIME, Constants.STATUS, Constants.NOTES};
				Iterator<Task> itr = taskList.iterator();
				while(itr.hasNext()) {
					tableData[++k] = itr.next().toStringArray();
				}
				TextTable.printTable(tableData);
			}
		}catch(TaskException e) {
			logger.error(e);
		}
		return taskList;
	}

	@Override
	public void addNotesToTask() {
		this.notesAddition.addNotesToTask(this.findTask);
	}

	@Override
	public void displayNotes() {
		this.displayNotes.displayNotes(this.findTask);
	}

	@Override
	public void deleteNotes() {
		this.notesDeletion.deleteNotes(this.findTask);
	}

	@Override
	public void updateNotes() {
		this.notesUpdation.updateNotes(this.findTask);
	}

	@Override
	public void exit() {
		this.exit.exit();
	}
	@Override
	public List<Task> findTasksOnStartDate() {
		List<Task> taskList = this.findTaskOnDate.findTasksWithStartDate();
		String[][] tableData;
		try {
			if(taskList.isEmpty())
				throw new TaskException("No tasks found");
			else {
				tableData = new String[taskList.size()+1][];
				int k=0;
				tableData[0] = new String[]{"ID", "Title", "Start DateTime", "End DateTime", "Status", "Notes"};
				Iterator<Task> itr = taskList.iterator();
				while(itr.hasNext()) {
					tableData[++k] = itr.next().toStringArray();
				}
				TextTable.printTable(tableData);
			}
		}catch(TaskException e) {
			logger.error(e);
		}
		return taskList;
	}

	@Override
	public List<Task> findTasksOnEndDate() {
		List<Task> taskList = this.findTaskOnDate.findTasksWithEndDate();
		String[][] tableData;
		try {
			if(taskList.isEmpty())
				throw new TaskException("No tasks found");
			else {
				tableData = new String[taskList.size()+1][];
				int k=0;
				tableData[0] = new String[]{"ID", "Title", "Start DateTime", "End DateTime", "Status", "Notes"};
				Iterator<Task> itr = taskList.iterator();
				while(itr.hasNext()) {
					tableData[++k] = itr.next().toStringArray();
				}
				TextTable.printTable(tableData);
			}
		}catch(TaskException e) {
			logger.error(e);
		}
		return taskList;
	}

}

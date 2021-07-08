package com.epam.service;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.model.Task;

public interface TaskService{
	public void showMenu();
	public void createTask();
    public Task findTask();
    public void findTaskUtil();
    public void removeSlot(LocalDateTime[] tempTimeSlot);
	public void deleteTask();
	public void updateTask();
	public List<Task> getTaskList();
	public void addNotesToTask();
	public void displayNotes();
	public void deleteNotes();
	public void updateNotes();
	public void exit();
	public List<Task> findTasksOnEndDate();
	public List<Task> findTasksOnStartDate();
}
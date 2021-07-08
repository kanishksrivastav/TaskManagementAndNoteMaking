package com.epam.util;

import java.util.List;

import com.epam.model.Task;
import com.epam.service.TaskServiceVariables;

public class GetTaskList implements TaskServiceVariables{
	public List<Task> getTaskList(){
		return taskList;
	}
}
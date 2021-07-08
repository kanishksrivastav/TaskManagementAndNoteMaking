package com.epam.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epam.constants.Constants;


@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int TASK_ID;
	private String taskTitle;
	private LocalDateTime taskStartDateTime;
	private LocalDateTime taskEndDateTime;
	private String taskStatus;
	
	@OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Notes> notesList;
	protected final static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(Constants.DATETIME_PATTERN);
	public Task() {
		
	}
	public Task(int TASK_ID){
		this.TASK_ID=TASK_ID;
	}
	
	public Task(String taskTitle) {
		super();
		this.taskTitle = taskTitle;
	}

	public Task(LocalDateTime taskStartDateTime) {
		super();
		this.taskStartDateTime = taskStartDateTime;
	}
	public void setTaskID(int TASK_ID) {
		this.TASK_ID=TASK_ID;
	}
	public int getTaskID() {
		return TASK_ID;
	}
	public static DateTimeFormatter getDatetimeformat() {
		return dateTimeFormat;
	}
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public LocalDateTime getTaskStartDateTime() {
		return taskStartDateTime;
	}
	public LocalDateTime getTaskEndDateTime() {
		return taskEndDateTime;
	}
	public void setTaskStartDateTime(LocalDateTime taskStartDateTime) {
		this.taskStartDateTime = taskStartDateTime;
	}
	public void setTaskEndDateTime(LocalDateTime taskEndDateTime) {
		this.taskEndDateTime = taskEndDateTime;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public List<Notes> getNotesList() {
		return this.notesList;
	}

	public void setNotesList(List<Notes> notesList) {
		this.notesList = notesList;
	}
	public void addNotes(Notes note) {
		if(this.notesList==null)
			this.notesList=new ArrayList<>();
		notesList.add(note);
	}
	public String[] toStringArray() {
		String[] arr = new String[6];
		arr[0] = this.TASK_ID+""; arr[1] = this.taskTitle;
		arr[2] = this.taskStartDateTime.format(dateTimeFormat).toString();
		arr[3] = this.taskEndDateTime.format(dateTimeFormat).toString();
		arr[4] = this.taskStatus;
		StringBuffer sb = new StringBuffer();
		if(this.notesList!=null) {
			for(Notes note : this.notesList) {
				sb.append(note.toString());
				sb.append(";");
			}
		}
		if(sb.length()==0)
			sb.append("No Notes");
		arr[5] = sb.toString();
		return arr;
	}
	@Override
	public String toString() {
		String sb =  "Task [TASK_ID=" + TASK_ID + ", taskTitle=" + taskTitle + ", taskStartTime="
				+ taskStartDateTime + ", taskEndTime=" + taskEndDateTime + ", taskStatus=" + taskStatus;
		if(notesList.size()>0) {
			sb += notesList;
		}
		sb+="]";
		return sb;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TASK_ID;
		result = prime * result + ((notesList == null) ? 0 : notesList.hashCode());
		result = prime * result + ((taskEndDateTime == null) ? 0 : taskEndDateTime.hashCode());
		result = prime * result + ((taskStartDateTime == null) ? 0 : taskStartDateTime.hashCode());
		result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
		result = prime * result + ((taskTitle == null) ? 0 : taskTitle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (TASK_ID != other.TASK_ID)
			return false;
		if (notesList == null) {
			if (other.notesList != null)
				return false;
		} else if (!notesList.equals(other.notesList))
			return false;
		if (taskEndDateTime == null) {
			if (other.taskEndDateTime != null)
				return false;
		} else if (!taskEndDateTime.equals(other.taskEndDateTime))
			return false;
		if (taskStartDateTime == null) {
			if (other.taskStartDateTime != null)
				return false;
		} else if (!taskStartDateTime.equals(other.taskStartDateTime))
			return false;
		if (taskStatus == null) {
			if (other.taskStatus != null)
				return false;
		} else if (!taskStatus.equals(other.taskStatus))
			return false;
		if (taskTitle == null) {
			if (other.taskTitle != null)
				return false;
		} else if (!taskTitle.equals(other.taskTitle))
			return false;
		return true;
	}
	
}
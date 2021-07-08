package com.epam.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.constants.Constants;
import com.epam.model.Task;

public interface TaskServiceVariables {
	public Scanner sc = new Scanner(System.in);
	public DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(Constants.DATETIME_PATTERN);
	public List<LocalDateTime[]> dateTimeSlots = new ArrayList<LocalDateTime[]>();
	public List<Task> taskList = new ArrayList<>();
	public EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("my-local-mysql");
	public EntityManager eManager=emFactory.createEntityManager();	


}

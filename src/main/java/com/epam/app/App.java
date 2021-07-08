package com.epam.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;
import com.epam.service.TaskServiceImpl;
import com.epam.service.TaskServiceVariables;

public class App{
	
	static final Scanner sc = new Scanner(System.in);
	private static Logger logger=LogManager.getLogger(App.class);
	public static void main(String[] args) {
		logger.info(Constants.WELCOME);
//		EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("my-local-mysql");
//		EntityManager eManager=emFactory.createEntityManager();
		boolean flag = true;
		TaskServiceImpl taskManager = new TaskServiceImpl();
		
		Map<Integer, Runnable> menu = new HashMap<>();

		menu.put(1, taskManager::createTask);
		menu.put(2, taskManager::findTaskUtil);
		menu.put(3, taskManager::findTasksOnStartDate);
		menu.put(4, taskManager::findTasksOnEndDate);
		menu.put(5, taskManager::getTaskList);
		menu.put(6, taskManager::deleteTask);
		menu.put(7, taskManager::updateTask);
		menu.put(8, taskManager::addNotesToTask);
		menu.put(9, taskManager::displayNotes);
		menu.put(10, taskManager::deleteNotes);
		menu.put(11, taskManager::updateNotes);
		menu.put(12, taskManager::exit);
		while(flag) {
			taskManager.showMenu();
			int choice = sc.nextInt();
			logger.info(choice);
			sc.nextLine();
			Runnable service = menu.get(choice);
			if(service == null) {
				logger.info(Constants.WRONG_CHOICE);
			}
			else {
				service.run();
			}
			logger.info(Constants.CONTINUE);
			flag = sc.next().toLowerCase().contains(Constants.N) ? false : true;
			logger.info(flag);
			if(!flag) {
				logger.info(Constants.THANK_YOU);
				logger.info(Constants.ADIOS_AMIGOS);
				break;
			}
		}
	}
}
package com.epam.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;

public class DisplayMenu{
	private Logger LOGGER=LogManager.getLogger(DisplayMenu.class);
	public void showMenu() {
		LOGGER.info(Constants.ENTER_CHOICE);
		LOGGER.info(Constants._1_NEW_TASK);
		LOGGER.info(Constants._2_FIND_TASK);
		LOGGER.info(Constants._3_DISPLAY_TASKS_ON_START_DATE);
		LOGGER.info(Constants._4_DISPLAY_TASKS_ON_END_DATE);
		LOGGER.info(Constants._5_DISPLAY_ALL);
		LOGGER.info(Constants._6_DELETE_TASK);
		LOGGER.info(Constants._7_UPDATE_TASK);
		LOGGER.info(Constants._8_ADD_NOTES);
		LOGGER.info(Constants._9_DISPLAY_NOTES);
		LOGGER.info(Constants._10_DELETE_NOTES);
		LOGGER.info(Constants._11_UPDATE_NOTES);
		LOGGER.info(Constants._12_EXIT);	
	}
}

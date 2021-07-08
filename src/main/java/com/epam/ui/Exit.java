package com.epam.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.Constants;

public class Exit {
	public void exit(){
		Logger LOGGER=LogManager.getLogger(Exit.class);
		LOGGER.info(Constants.THANK_YOU);
		LOGGER.info(Constants.ADIOS_AMIGOS);
		System.exit(0);	}
}

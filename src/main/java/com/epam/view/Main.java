package com.epam.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CategoryView.java - The code below is contain Main of this project. which directly call Index.
 * @author Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */
public class Main {
	private static Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		logger.info("Main() started");
		new Index();
	}
}

package org.ssglobal.training.codes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Divide {
	
	private static Logger logger = Logger.getLogger(Divide.class.getName());
	
	public Divide() {
		logger.setLevel(Level.OFF);
	}
// testing nito together with the mathematics
	public int div(int x, int y) throws ArithmeticException, Exception{
		logger.info("execute div"); // dapat kasamang nalolog ang mga inputs
		
		logger.info("Validation: denominator should not be 0");
		// description of the nested if or if-else or loop
		if (y == 0) {
			logger.severe("Error: division by zero not allowed");
			// pag mga throw new di na nilalagyan ng logger.info(exit with errors)
			throw new ArithmeticException("division by zero not allowed");
		}
		logger.info("exit without errors div");
		return 0;
	}
}

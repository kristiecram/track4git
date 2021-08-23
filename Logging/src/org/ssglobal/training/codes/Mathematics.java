package org.ssglobal.training.codes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mathematics {
	
	private static Logger logger = Logger.getLogger(Mathematics.class.getName());
	private Divide divide;

	public Mathematics(Divide divide) {
		logger.setLevel(Level.INFO);
		this.divide = divide;
	}
	
	public double complexOp(int x, int y) {
		double formula = 0.0;
		try {
			formula = (2000.0/divide.div(x, y)) - divide.div(x, y);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 2 times sa line above tinawag si divide.div yan yung nasa times
		return formula;
	}
}

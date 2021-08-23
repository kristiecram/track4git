package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFunList {

	private FunList funList;

	@BeforeEach
	public void setup() {
		funList = new FunList("test/config/test.txt");
	}
	
	@Test
	public void testEnableDisplay() {
		funList.enableDisplay();
	}
	
	@AfterEach
	public void teardown() {
		funList = null;
	}
}

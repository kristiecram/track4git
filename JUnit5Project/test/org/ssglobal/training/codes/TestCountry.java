package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class TestCountry {

	private Country cnt;
	
	@BeforeEach
	public void setup() {
		cnt = new Country();
	}
	
	// SUNNY DAY
	
	@ParameterizedTest
	@EnumSource(value = Country.Choice.class) // choice is an inner class
	public void testGreetPerCountry(Country.Choice option) {
		String result = cnt.sayGreet(option);
		Assertions.assertNotNull(result);
	}
	
	// RAINY DAY
	
	@ParameterizedTest
	@EnumSource(value = Country.Choice.class)
	public void testGreetPerCountryRainy(Country.Choice option) {
		String result = cnt.sayGreet(option);
		Assertions.assertNull(result);
		
	}
	
	@AfterEach
	public void teardown() {
		cnt = null;
	}
	
	// Structures of test data(POJO, enum, array)
	
	
}

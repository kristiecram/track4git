package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestGradeBook {

	private GradeBook gb;
	
	@BeforeEach
	public void setup() {
		gb = new GradeBook();
		System.out.println("initializing");
	}
	
	// SUNNY DAY TESTING - no negatives or null (sa rainy day to eh)
	@ParameterizedTest // parang repeatedTest na 5 independent tests so di mafufulfill thru this ang adding talaga
	@ValueSource(doubles = {95.5, 90.5, 70.5, 50.6, 68.6}) // laging kasama to sa parameterizedTest
	// control-spacebar para alam mo kasi tulad ng yan sa double, may 's' siya
	// di pwedeng array ang ilagay jan, kasi isa lang talaga, bawal makulit lol
	public void testAddFiveGrades(double testData) {
		gb.addGrade(testData);
		gb.printGrades();
	}
// no calling of test methods with each other
	
	@ParameterizedTest
	@ValueSource(doubles = {40.5, 30.5, 25.5, 52.6, 50.6})
	public void testAddFiveGrades1(double testData){
		gb.addGrade(testData);
		gb.printGrades();
	}
	
	@ParameterizedTest
	public void testAddTenGrades() {
		
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {40.5, 30.5, 25.5, 52.6, 50.6})
	public void testDeleteGrade(double testData) {
		gb.addGrade(testData);
		gb.delGrade(testData);
		gb.printGrades();
	}
	
	@AfterEach
	public void teardown() {
		gb = null;
	}
	
	
}

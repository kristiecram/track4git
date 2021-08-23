package org.ssglobal.training.codes;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestMathematics {

	private Mathematics math;
	
	@BeforeEach
	public void setup() {
		math = new Mathematics();
	}
	
	@ParameterizedTest
	@MethodSource(value = "mathProvider") // kung marami: (value = {"", ""})
	// kung isa lang naman siya: @MethodSource (<value>)
	public void testDivideCorrectData(int[] testdata) {// exception testing talaga to
		Assertions.assertDoesNotThrow(()->{
			int result = math.divide(testdata[0], testdata[1]);
			Assertions.assertEquals(testdata[2], result);
		}); // wag kang magsurround try-catch ITO GAMITIN MO
	}
	
	// RAINY DAY
	
	@ParameterizedTest
	@MethodSource(value = "mathProvider2") 
	public void testDivideIncorrectData(int[] testdata) {
		Assertions.assertThrows(ArithmeticException.class,()->{
			int result = math.divide(testdata[0], testdata[1]);
			Assertions.assertNotEquals(testdata[2], result);
		});
	}
	
	@AfterEach
	public void teardown() {
		math = null;
	}
	
	// Custom test data
	// always static
	private static Stream<int[]> mathProvider(){
		return Stream.of(new int[] {1, 2, 0}, new int[] {5, 2, 2}, 
						new int[] {10, 2, 5});
	}
	
	private static Stream<int[]> mathProvider2(){
		return Stream.of(new int[] {1, 2, 1}, new int[] {5, 0, 0}, 
						new int[] {-10, -2, -5});
	}
}

/*
 * we dont use collections here kasi pwede siyang makaapekto sa performance
 */

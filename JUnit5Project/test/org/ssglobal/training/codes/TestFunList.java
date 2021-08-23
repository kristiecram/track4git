package org.ssglobal.training.codes;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

// no extends but annotation

/*
 * beforeeach dapat fresh ang data everytime na gagawin ang ang isang test method
 * kung di kailangang baguhin o di naman need na fresh kada execution ang data,
 * use BeforeAll and AfterAll (need nga lang na static sila)
 * mas preferred ang beforeEach and afterEach kasi hindi static
 */
public class TestFunList {
	
	private FunList funList;
	
	@BeforeEach
	public void setup() { // need na static para gumana
		System.out.println("initialization");
		funList = new FunList("test/config/test.txt");
	}
	
	// SUNNY DAY TESTING
	
	@Test
	public void testCountEqualsValue() {
		long count = funList.countWords();
	//	Assertions.assertEquals(1, count);// dito ka lang pwede makaparetrieve ng failures
	//	Assertions.assertTrue( count >= 0);
		Assertions.assertEquals(8, count);
// 1 assert = 1 method	
	// kung saan nagkafailure titigil na yung parserenginer mo so di na niya gagawin
	// yung succeeding lines
	}
// di nagwork so there is an algorithm with the problem	
	@Disabled
	@Test
	public void testCountNonNegativeFile1() {
		long count = funList.countWords();
		Assertions.assertTrue(count >= 0);
	}
	
	@Disabled
	@Test
	public void testCountNonNegativeFile2() {
		FunList funList = new FunList("test/config/test2.txt");
		long count = funList.countWords();
		Assertions.assertEquals(0, count);
		funList = null; // needed kasi local vars are not part of teardown
	}
	
	@Disabled // attached on specified full-blown valid method para di na mag-eexecute
	// di magwowork kung walang @Test
	@Test
	public void testContentListNotNull() {
		List<String> temp = funList.getContentList();
		Assertions.assertNull(temp);
	}
	
	// Enum, constants object, or pointers pointing to one object
	@Test
	public void testSameContentArrays() {
		Assertions.assertDoesNotThrow(()->{
			String[] content = {"The quick brown fox jumps over the lazy dog."};
			String[] temp = funList.getContentAray();
			Assertions.assertSame(content, temp);
		});
		 // expected muna bago derived
		// checks the memory address and not the content
		// pwede ring same address pero paiba-iba lang talaga ng pointer
	}

	@Test
	public void testSameContentArraysValue() {
		String[] content = {"The quick brown fox jumps over the lazy dog."};
		String[] temp = funList.getContentAray();
		Assertions.assertArrayEquals(content, temp);
	}
	
	// RAINY DAY TESTING
	
	@Test
	public void testCountNonNegativeFile1Rainy() {
		long count = funList.countWords();
		Assertions.assertFalse(count <= 0);
	} // gawin ang hindi pinpagawa so dapat mag-green yan jan
	
	@Test
	public void testCountNonNegativeFile2Rainy() {
		FunList funList = new FunList("test/config/test2.txt");
		long count = funList.countWords();
		Assertions.assertNotEquals(6, count);
		funList = null;
	} 
	
	@Test
	public void testSameContentArraysRainy() {
		Assertions.assertThrows(ClassCastException.class, ()->{
			String[] content = {"The quick brown fox jumps over the lazy dog."};
			String[] temp = funList.getContentAray();
			Assertions.assertSame(content, temp);
		}); 
	}
	
	@Test
	public void testSameContentArraysValueRainy() {
		String[] content = {"The quick brown fox jumps over the lazy dog"};
		String[] temp = funList.getContentAray();
		Assertions.assertNotEquals(content, temp);
	}
	
	@Test
	public void testContentListNotNullRainy() {
		List<String> temp = funList.getContentList();
		Assertions.assertNull(temp);
	}
	
// di marurun kung walang @Test	
	@Test
	public void testDisplayInSeconds() {
		Assertions.assertTimeout(Duration.ofSeconds(2), ()->{
			funList.showLines();
		});// Executable parang runnable lang yan so lambda expression lang yan
	}
	
	@Test
	public void testDisplayInMillis() {
		Assertions.assertTimeout(Duration.ofMillis(10), ()->{
			funList.showLines();
		});// Executable parang runnable lang yan so lambda expression lang yan
	}

	@RepeatedTest(value = 5) // usually ginagawa sa mga threads
// number of repeats is specified by you or the boss will configure it for you	
	public void testSameContentArraysValueRepeat() {
		String[] content = {"The quick brown fox jumps over the lazy dog."};
		String[] temp = funList.getContentAray();
		Assertions.assertArrayEquals(content, temp);
	}
	
// every test, inieexecute ang beforeEach and afterEach	
	@AfterEach
	public void teardown() {
// bibilangin ang number of objects na na-initialize mo sa setUp		
		System.out.println("destroyer");
		funList = null;
	}
	
}

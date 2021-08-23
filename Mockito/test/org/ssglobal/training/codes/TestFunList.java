package org.ssglobal.training.codes;

// kapag specific ka sa type kasi delikado
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn; // wag na wag daw gagamitin lol
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestFunList {

	@Mock
	private FunList mockFunList;
	
	@Mock
	private List<String> arrayList;
	
	@Test
	public void testProcessStr() {
		// Mocking area - Arrange
		when(mockFunList.processStr("str1", "str2")).thenReturn("str1 str2");
	/*	when(mockFunList.processStr("str1", "str2")).thenReturn("Anna Dimak");
		when(mockFunList.processStr("str1", "str2")).thenReturn("Lorna Dimak");
		when(mockFunList.processStr("str1", "str2")).thenReturn("Fe Dimak");
		*/ // isang input assumption lang and isang assume output lang
		// 1 at a time
		// SUT - Act
		String result1 = mockFunList.processStr("str1", "str2");
		Assertions.assertEquals("str1 str2", result1);
	}
	
	@Test
	public void testRetrieveDataList() {
		
		when(arrayList.get(anyInt())).thenReturn("Anna", "Lorna", "Fe");
		String result1 = arrayList.get(1);
		Assertions.assertEquals("Anna", result1);
		String result2 = arrayList.get(1);
		Assertions.assertEquals("Lorna", result2);
		String result3 = arrayList.get(10);
		Assertions.assertEquals("Fe", result3);
	}
	
	@Disabled // ignore
	@Test
	public void testRetrieveDataList2() {
		doReturn(100).when(arrayList.get(anyInt()));
// di nag-eerror si compiler kahit na integer ang nasa doReturn at <String> ang type
		// ni arrayList
	}
	
	@Test
	public void testGetEmpty() {
		when(arrayList.get(anyInt())).thenReturn("Anna");
		when(arrayList.isEmpty()).thenReturn(false);
		
		Assertions.assertEquals(false, arrayList.isEmpty());
		Assertions.assertEquals("Anna", arrayList.get(20));
	}
	
	@Test // di gumagana lol
	public void testShowLines() {
		
		doNothing().when((arrayList)).add(anyInt(), isA(String.class));
		
		arrayList.add(10, "Anna");
		verify(arrayList, times(2)).add(10, "Anna");
	}
	
	@Test // di gumagana lol
	public void testShowLines2() {
		
		doNothing().when(mockFunList).showLines();
		mockFunList.showLines();
		verify(mockFunList, times(1)).showLines();
	}
	
}

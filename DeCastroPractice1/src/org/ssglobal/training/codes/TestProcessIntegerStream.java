package org.ssglobal.training.codes;

public class TestProcessIntegerStream {

	public static void main(String[] args) {
		int[] data = {15, 18, 19, 20, 33, 50, 9, 3, 1, 25, 100, 2, 82, 98};
		IntegerData test = new IntegerData();
		Integer[] result1 = test.getDivByTwo(data);
		
		for (Integer i : result1) {
			System.out.println(i);
		}
		System.out.println();
		
		Integer[] result2 = test.getDivByThree(data);
		for (Integer i : result2) {
			System.out.println(i);
		}
		System.out.println();
		
		Integer[] result3 = test.getDivByFive(data);
		for (Integer i : result3) {
			System.out.println(i);
		}
		System.out.println();
		
	}

}

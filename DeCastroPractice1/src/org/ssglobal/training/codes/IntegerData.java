package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class IntegerData {

	private static Integer[] data = new Integer[0];
	
	public ProcessIntegerStream input(Integer[] x) {
		data = x;
		
		return new ProcessIntegerStream() {

			@Override
			public ProcessIntegerStream filter(Predicate<Integer> filter) {
				Integer[] temp = new Integer[data.length];
				int i = 0;
				for(Integer j : data) {
					if(filter.test(j)) {
						temp[i] = j;
						i++;
					}
				}
				Integer[] result = Arrays.copyOf(temp, i);
				data = result;
				result = null;
				return this;
			}

			@Override
			public ProcessIntegerStream sort(Comparator<Integer> comparator) {
				System.out.printf("First of the original array: %d\n",  data[0]);
				Arrays.sort(data, comparator);
				return this;
			}

			@Override
			public List<Integer> toList() {
				return new ArrayList<Integer>(Arrays.asList(data));
			}

			@Override
			public Integer[] toArray() {
				return data;
			}
		};
	}
	
	public Integer[] getDivByTwo(int[] num) {
		Integer[] copy = new Integer[num.length];
		int j = 0;
		for (int i : num) {
			copy[j] = i;
			j++;
		}
		Predicate<Integer> test = (item) -> {
			if ((item % 2 == 0) && item > 15) {
				return true;
			}
			return false;
		};
		ProcessIntegerStream stream = input(copy);
		Integer[] toReturn = stream.filter(test).toArray();
		return toReturn;
	}
	
	public Integer[] getDivByThree(int[] num) {
		Integer[] copy = new Integer[num.length];
		int j = 0;
		for (int i : num) {
			copy[j] = i;
			j++;
		}
		Predicate<Integer> test = (item) -> {
			if ((item % 3 == 0) && item < 21) {
				return true;
			}
			return false;
		};
		ProcessIntegerStream stream = input(copy);
		Integer[] toReturn = stream.filter(test).toArray();
		return toReturn;
	}
	
	public Integer[] getDivByFive(int[] num) {
		Integer[] copy = new Integer[num.length];
		int j = 0;
		for (int i : num) {
			copy[j] = i;
			j++;
		}
		Predicate<Integer> test = (item) -> {
			if (item % 5 == 0) {
				return true;
			}
			return false;
		};
		ProcessIntegerStream stream = input(copy);
		Comparator<Integer> descend = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.compareTo(o2) == 0) {
					return 0;
				} else if (o1.compareTo(o2) > 0) {
					return -2;
				} else {
					return 2;
				}
			}
		};
		Integer[] toReturn = stream.filter(test).sort(descend).toArray();
		return toReturn;
	}
}

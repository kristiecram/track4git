package org.ssglobal.training.codes;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestStringStream {

	public static void main(String[] args) {
		String[] data = {"Mango", "Apple", "Grapes", "Strawberry", "Blueberry",
						 "Lemon", "Melon", "Dragon Fruit"};
		StringStream stream = StringData.input(data);
		Comparator<String> descend = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.compareTo(o2) == 0) {
					return 0;
				} else if (o1.compareTo(o2) > 0) {
					return -2;
				} else {
					return 2;
				}
			}
		};
		
		// Result 1
		Predicate<String> fiveLetters = (item) -> {
			if (item.length() == 5) {
				return true;
			}
			return false;
		};
		List<String> fiveLetterList = stream.filter(fiveLetters).sort(descend).toList();
		System.out.println(fiveLetterList);
		
		// Result 2
		Predicate<String> greaterFiveLetters = (item) -> {
			if (item.length() >= 5) {
				return true;
			}
			return false;
		};
		stream = StringData.input(data);
		System.out.println(stream.filter(greaterFiveLetters).sort(descend).merge());
		
		// Result 3
		Predicate<String> endsInN = (item) -> {
			if (item.charAt(item.length() - 1) == 'n') {
				return true;
			}
			return false;
		};
		
		stream = StringData.input(data);
		String[] fruitsArray = stream.filter(fiveLetters).filter(endsInN).toArray();
		for (String s : fruitsArray) {
			System.out.println(s);
		}
		
		// 2. Total ASCII value
		Function<String, Integer> convert = (str) -> {
			char[] strArray = str.toCharArray();
			int val = 0;
			for (char c : strArray) {
				val += c;
			}
			return val;
		};
		
		stream = StringData.input(data);
		System.out.println(stream.filter(greaterFiveLetters).convertASCII(convert).totalASCIIValues());
		
	}

}

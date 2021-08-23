package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringData {

	private static String[] data = new String[0];
	private static Integer[] mapdata;
	
	// create stream operator
	public static StringStream input(String[] x) {
		data = x;
		
		return new StringStream() {

			@Override
			public StringStream sort(Comparator<String> comparator) {
				System.out.println(data[0]);
				Arrays.sort(data, comparator);
				return this;
			}

			@Override
			public StringStream convertASCII(Function<String, Integer> converter) {
				mapdata = new Integer[data.length];
				int counter = 0;
				for(String str : data) {
					mapdata[counter] = converter.apply(str);
					counter++;
				}
				return this;
			}

			@Override
			public List<String> toList() {
				return new ArrayList<String>(Arrays.asList(data));
			}

			@Override
			public String[] toArray() {
				return data;
			}

			@Override
			public String merge() {
				return String.join(" ", data);
			}

			@Override
			public StringStream filter(Predicate<String> filter) {
				String[] temp = new String[data.length];
				int i = 0;
				for (String str : data) {
					if(filter.test(str)) {
						temp[i] = str;
						i++;
					}
				}
				String[] result = Arrays.copyOf(temp, i);
				data = result;
				result = null;
				return this;
			}

			@Override
			public Integer totalASCIIValues() {
				int totalTemp = 0;
				for (Integer i : mapdata) {
					totalTemp += i;
				}
				Integer total = (Integer) totalTemp;
				return total;
			}
		};
	}

}

interface StringStream{
	// intermediate operators
	public abstract StringStream sort(Comparator<String> comparator);
	public abstract StringStream convertASCII(Function<String, Integer> converter);
	public abstract StringStream filter(Predicate<String> filter);
	// terminal operators
	public abstract List<String> toList();
	public abstract String[] toArray();
	public abstract String merge();
	public abstract Integer totalASCIIValues();
}
 
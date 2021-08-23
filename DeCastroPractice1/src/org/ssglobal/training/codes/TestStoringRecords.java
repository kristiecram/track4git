package org.ssglobal.training.codes;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class TestStoringRecords {

	public static void main(String[] args) {
		StoringRecords records = new StoringRecords();
		Function<String, Person> convert = (str) -> {
			Person person = new Person();
			StringTokenizer tokenizer = new StringTokenizer(str, ",");
			while(tokenizer.hasMoreTokens()) {
				person.setName(tokenizer.nextToken());
				person.setAge(Integer.parseInt(tokenizer.nextToken()));
			}
			return person;
		};
		
		List<Person> persons2 = records.readRecordsFromFile("src/files/Test - Sheet1.csv", convert);
		
		Iterator<Person> iterator = persons2.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			System.out.printf("%s %d \n", person.getName(), person.getAge());
		}
	}

}

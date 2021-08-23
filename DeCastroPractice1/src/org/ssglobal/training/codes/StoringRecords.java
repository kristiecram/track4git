package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StoringRecords {

	public List<Person> readRecordsFromFile(String filename, 
				Function<String, Person> converter){
		List<Person> data = new ArrayList<>();
		Path p = Paths.get(filename);
		try (BufferedReader bufferedReader = Files.newBufferedReader(p);){
			bufferedReader.mark(1000);
			String line = bufferedReader.readLine();
			while(line != null) {
				data.add(converter.apply(line));
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}

package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FunList {
	
	private BufferedReader bufferedReader;
	
	public FunList(String filename) {
		Path p = Paths.get(filename);
		try {
			this.bufferedReader = Files.newBufferedReader(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int countWords() {
		return (int) this.bufferedReader.lines().map((str)-> {
			return str.split("");}).count();
	}
	
	public boolean enableDisplay() {
		if(this.bufferedReader.lines().toArray(String[]::new).length > 0) {
			showLines();
			return true;
		}
		return false;
	}
	
	public void showLines() {
		this.bufferedReader.lines().forEach((line)->{
			System.out.println(line);
		});
	}
	
	public List<String> getContentList() {
		return this.bufferedReader.lines().collect(Collectors.toList());
	}
	
	public String[] getContentAray() {
	//	List<String> temp = this.bufferedReader.lines().collect(Collectors.toList());
//		return (String[]) this.bufferedReader.lines().toArray(String[]::new);
		return (String[]) this.bufferedReader.lines().toArray();
		
	}
}

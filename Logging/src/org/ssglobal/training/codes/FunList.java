package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class FunList {
	private BufferedReader bufferedReader;
	
	// not all caps kasi di siya final
	// di rin siya iniinstantiate > getLogger lang
	// name usually ng class na nilolog niya
	
	// STEP 1 :
	private static Logger logger = Logger.getLogger(FunList.class.getName());
	
	{
		// STEP 1B : set the logging level
		logger.setLevel(Level.INFO);
		// level is an enum kaya ganyan
		// di nilagay dito si warning noong una kaya di lumalabas si warning
		// (si severe lang nilagay)
		// parang nakaturn off si warning
		// ibaba ng level kung gusto mo pati yung mga mas mataas sa kanya visible
			
				
		// STEP 2 : Creating another handler
		// STEP 3 : Format the message
		try {
			FileHandler fileHandler = new FileHandler("./src/log/funlist.log", true);
			fileHandler.setEncoding("UTF-8"); // always do this
			fileHandler.setLevel(Level.INFO);
					
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			
			logger.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch(IOException e) {
			logger.severe("Error message: ");
		}
	}
	
	public FunList() {
		
	}
	
	public FunList(String filename) {
		Path p = Paths.get(filename);
		try {
			this.bufferedReader = Files.newBufferedReader(p);
		} catch (IOException e) {
			// STEP 1C : Apply severe or apply logging
			logger.severe("Error message: " + e.getMessage()); // error message dapat to ng exception
			e.printStackTrace();
		}
	}

	public int countWords() {
		logger.info("execute countWords");
		int temp = (int) this.bufferedReader.lines().map((str)-> {
			return str.split("");}).count();
		logger.info("exit without errors countWords");
		return temp;
	}
	
	@SuppressWarnings("deprecation")
	public boolean enableDisplay() {
		logger.info("execute enableDisplay");
		logger.warning("custom Date is deprecated");
		Date xmas = new Date(121, 11, 25);
		try {
			if (this.bufferedReader.lines().toArray(String[]::new).length > 0) {
				showLines();
				logger.info("execute without errors enableDisplay");
				return true;
			}
		} catch (Exception e) {
				logger.severe("Error message: " + e.getMessage());
		}
		logger.info("exit with errors enableDisplay");
		return false;
	}
	
	public void showLines() {
		logger.info("execute showLines");
		this.bufferedReader.lines().forEach((line)->{
			System.out.println(line);
		});
		logger.info("exit without errors showLines");
	}
	
	public List<String> getContentList() {
		logger.info("execute getContentList");
		List<String> temp = this.bufferedReader.lines().collect(Collectors.toList());
		logger.info("exit without errors getContentList");
		return temp;
	}
	
	public String[] getContentArray() {
		logger.info("execute getContentArray");
		String[] temp = (String[]) this.bufferedReader.lines().toArray();
		logger.info("exit without errors getContentArray");
		return temp;
		
	}
	
	public String processStr(String str1, String str2) {
		logger.info("execute processStr");
		String temp = String.join(" ", str1, str2);
		logger.info("exit without errors processStr");
		return temp;
	}
}

class Word{}

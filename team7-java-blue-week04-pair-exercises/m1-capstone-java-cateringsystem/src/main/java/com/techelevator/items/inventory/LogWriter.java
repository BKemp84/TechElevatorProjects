package com.techelevator.items.inventory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


import java.text.SimpleDateFormat;

public class LogWriter {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	Date date = new Date();
	

	
	
	public void writeToLog(String action, double amt, double balance) {
		
		File logWriter = new File("logWriter.txt");
		
		try (BufferedWriter writer = new BufferedWriter( new FileWriter(logWriter, true) ) ) {
			
			
			writer.write(dateFormat.format(date) + "\t");
			writer.write(action + "\t");
			writer.write(Double.toString(amt) + "\t");
			writer.write(Double.toString(balance));
			writer.newLine();
			
		
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	
	
	public void clearLog() {
			
			File logEraser = new File("logWriter.txt");
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(logEraser, false))) {
				
			//	writer.write("");
				
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	
	
	
	}	


package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ColorWriterExample {
	
	private final static String FILE_NAME = "Colors.txt";
	private final static int UPPER_LIMIT = 200;
	
	public static void main(String[] args) throws IOException  {
		
		File colorFile = new File(FILE_NAME);
		
		try ( PrintWriter writer = new PrintWriter( colorFile );
				BufferedWriter buffered = new BufferedWriter( writer )) { 
		
			for (int i = 1 ; i <= UPPER_LIMIT ; i++) {
				buffered.write(getOutput(i));
				buffered.newLine();

			}
		}
		
		System.out.println("DONE!");
	}
	
	
	private static String getOutput(int i) {
		
		String output = String.valueOf(i);
		
		if (i % 5 == 0) {
			output = "RED";
		} else if (i % 7 == 0) {
			output = "BLUE";
		} else if (i % 9 == 0) {
			output = "GREEN";
		}
		
		return output;
	}
	
}

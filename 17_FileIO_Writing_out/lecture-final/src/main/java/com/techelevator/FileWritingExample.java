package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingExample {

	
	public static void main(String[] args) throws IOException {
		
		//writeFileWithoutBuffer();
		writeFileWithBuffering();
	}
	
	private static void writeFileWithoutBuffer() {
		File file = new File("numbers.txt");
		try ( PrintWriter writer = new PrintWriter(file) ) {
			
			for (int i = 0; i <= 100; i++) {
				writer.println("Line " + i);
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void writeFileWithBuffering() throws IOException {
		
		File file = new File("numbers-buffered.txt");
		try ( PrintWriter printerWriter = new PrintWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter( printerWriter ))  {
			
			for (int i = 0; i <= 100; i++) {
				bufferedWriter.write("Line " + i);
				bufferedWriter.newLine();
			}
			
			
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	
}

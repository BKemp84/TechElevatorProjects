package com.techelevator.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner( System.in );
		
		System.out.print( "File path >>>");
		String filePath = userInput.nextLine();
		
		
		File file = new File( filePath );
		
		try ( Scanner fileScanner = new Scanner( file ) ) {
			
			while ( fileScanner.hasNextLine() ) {
				String nextLineFromFile = fileScanner.nextLine();
				
				System.out.println( nextLineFromFile.toUpperCase() );
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		
		
		
	}
	
}

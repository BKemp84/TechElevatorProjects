package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		int wordCount = 0;
		int sentenceCount = 0;
		
		File aliceFile = new File("alices_adventures_in_wonderland.txt");
		
		try (Scanner aliceFileScanner = new Scanner(aliceFile)) {
			
			while (aliceFileScanner.hasNextLine()) {
						
					String line = aliceFileScanner.next();
						
					String[] numOfWords = line.split(" ");
								wordCount += numOfWords.length;

				
				if (line.contains(".") || line.contains("!") || line.contains("?")) {
				sentenceCount ++;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
		System.out.println("Total number of words: " + wordCount);
		System.out.println("Total number of sentences: " + sentenceCount);
	}
	
		
		
}

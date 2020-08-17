package com.techelevator;



		import java.io.File;
		import java.io.FileNotFoundException;
		import java.util.Scanner;

		public class WordSearch {

		public static void main(String[] args) {

		    Scanner in = new Scanner(System.in);
		    
		    System.out.println("What is the file that should be searched? >>>");
		    String userInput = in.nextLine();
		    
		    File myFile = new File(userInput);
		    
		    System.out.println("What is the text that should be found? >>>");
		    String userWord = in.nextLine();
		    
		    System.out.println("Should it be case sensitive? (Y/N) >>>");
		    String yesOrNo = in.nextLine().toUpperCase();
		    
		    int lineNumber = 1;
		    try (Scanner fileScanner = new Scanner(myFile)) {
		        while (fileScanner.hasNextLine()) {
		            String line = fileScanner.nextLine();
		            if(yesOrNo.equals("N")) {
		                String lineUpperCase = line.toUpperCase();
		                if (lineUpperCase.contains(userWord.toUpperCase())) {
		                    System.out.println(lineNumber + ") " + line);
		                    lineNumber++;
		                } else {
		                    lineNumber++;
		                }
		            } else {
		                if (line.contains(userWord)) {
		                    System.out.println(lineNumber + ") " + line);
		                    lineNumber++;
		                } else {
		                    lineNumber++;
		                }
		            }
		            
		        }
		    } catch (FileNotFoundException ex) {
		        System.out.println("File not found!");
		    }
		}
		



	}



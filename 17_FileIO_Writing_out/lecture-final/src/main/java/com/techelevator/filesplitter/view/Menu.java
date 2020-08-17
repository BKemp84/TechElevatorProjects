package com.techelevator.filesplitter.view;

import java.util.Scanner;

public class Menu {

	private Scanner input = new Scanner(System.in);
	
	public String getFilePathFromUser() {
		System.out.print("Path to file >>>");
		System.out.flush();
		String filePath = input.nextLine();
		return filePath;
	}
	
	public int getLineCountToSplitFromUser() {
		int lineCount = 0;
		
		while (true) {
			System.out.println("Number of lines to split>>>");
			String userInput = input.nextLine();
			
			try {
				lineCount = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				System.out.println("Not a valid number.  Try again!");
				continue;
			}
			
			break;
		}
		
		return lineCount;
	}
	
	public void displayUserMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}
	
}

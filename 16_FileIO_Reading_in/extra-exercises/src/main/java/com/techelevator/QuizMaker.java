package com.techelevator;

import java.io.File;
import java.util.*;

public class QuizMaker {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	    int answersCorrect = 0;
	    int totalPossibleAnswers = 0;
	    System.out.println("Where is the quiz file? >>>");
	    String filePath = input.nextLine();
	    File file = new File (filePath);
	    
	    try(Scanner fileScanner = new Scanner(file)) {
	        
	        while(fileScanner.hasNextLine()) {
	            String nextLineFromFile = fileScanner.nextLine();
	            String[] questionArray = nextLineFromFile.replace("*", "").split("1");
	            String[] questionArrayWithAnswer = nextLineFromFile.split("1");             
	            System.out.println(questionArray[0] + " ");
	            System.out.println("1) " + questionArray[1] + " ");
	            System.out.println("2) " + questionArray[2] + " ");
	            System.out.println("3) " + questionArray[3] + " ");
	            System.out.println("4) " + questionArray[4] + " ");
	            System.out.println("Input your answer >>> ");
	            String userAnwer = input.nextLine();
	            int userAnserInt = Integer.parseInt(userAnwer);
	            
	            if(questionArrayWithAnswer[userAnserInt].contains("*")) {
	                System.out.println("Correct");
	                answersCorrect++;
	                totalPossibleAnswers++;
	            } else {
	                System.out.println("Incorrect");
	                totalPossibleAnswers++;
	            }
	        }
	        System.out.println("You got " + answersCorrect + " answer(s) correct out of " + totalPossibleAnswers);  
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
		

	}

}

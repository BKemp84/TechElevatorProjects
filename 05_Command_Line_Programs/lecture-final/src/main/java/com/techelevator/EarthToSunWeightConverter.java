package com.techelevator;

import java.util.Scanner;

public class EarthToSunWeightConverter {

	/*
	 * Command line programs usually follow this work flow:   
	 * 			Take Data
	 * 			Calculate Data
	 * 			Give Results
	 * 
	 * How can we do each of these steps?
	 */
	public static void main(String[] args) {
		
		int sunGravity = 28;
		
		System.out.print("Enter the Earth weight >>>");
		
		Scanner in = new Scanner( System.in );
		
		String userInput = in.nextLine();
		
		int earthWeight = Integer.parseInt(userInput);

		int sunWeight = earthWeight * sunGravity;
		
		System.out.println();
		
		System.out.printf("%-15s    %-15s", "Earth (lbs)", "Sun (lbs)");
		System.out.printf("%n----------------------------%n");
		System.out.printf("%-15s    %-15s", earthWeight, sunWeight);
		
	}

}

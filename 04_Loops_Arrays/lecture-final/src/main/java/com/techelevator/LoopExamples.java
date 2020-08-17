package com.techelevator;

public class LoopExamples {

	public static void main(String[] args) {
		
		for ( int i = 0 ; i < 10 ; i++) {
			System.out.println(i);
		}
		
		
		// Sum all numbers from 1 to 100
		int sum = 0;
		for ( int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println( sum );
		
		// Sum all the odd numbers 2020 - 8576  - 3 methods
		sum = 0;
		for ( int i = 2020 ; i <= 8576; i++) {
			if ( i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println( sum );
		
		sum = 0;
		for ( int i = 2020 ; i <= 8576; i++) {
			if ( i % 2 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println( sum );
		
		sum = 0;
		for ( int i = 2021 ; i <= 8576; i += 2) {
			sum += i;
		}
		System.out.println( sum );
		
		// Print all the numbers from 1 to 100 in reverse
		for ( int n = 100 ; n > 0 ; n--) {
			System.out.println(n);
		}
		
		int number = 100;
		for (  ; number > 0 ; ) {
			System.out.println(number);
			number--;
		}
		
		
		
		String[] instructors = new String[5];
		instructors[0] = "John";
		instructors[1] = "Rachelle";
		instructors[2] = "Steve";
		instructors[3] = "Matt";
		instructors[4] = "Matty";
		
		for (int i = 0; i < instructors.length; i++) {
			System.out.println( instructors[i] );
		}
		
		for ( int i = 0; i < instructors.length; i++) {
			if ( i % 2 == 1) {
				System.out.println( instructors[i] );
			}
		}
		
		int[] nums =  { 10, 20, 30, 40, 50, 60 , 70 , 80, 90, 100 };
		
		for ( int i = 2 ; i <= 7 ; i++) {
			nums[i] = nums[i] * 2;
		}
		
		for (int j = 0; j < nums.length; j++) {
			System.out.println( nums[j]);
		}
	
		
		for ( int i = 0; i < nums.length; i++) {
			System.out.println( nums[i] );
			if ( nums[i] % 3 == 0 ) {
				i++;
			}
		}
		
		// Causes an out of bounds error
		for ( int i = 0; i <= nums.length; i++) {
			nums[i] = 0;
		}
		
		
	}

}

package com.techelevator;

public class KataFizzBuzz {
	
	
public Object fizzBuzz;
//Implementation of classic FizzBuzz kata
//author Ben Kemp

public  String fizzBuzz (int nums) {
	

		if (nums % 3 == 0 && nums % 5 ==0 || (Integer.toString(nums).contains("3") 
			&& Integer.toString(nums).contains("5"))){
			return  "FizzBuzz";
		} if (nums % 3 == 0 ||Integer.toString(nums).contains("3")) {
			return "Fizz";
		} if (nums % 5 == 0 || Integer.toString(nums).contains("5")){
			return "Buzz";
        
		}
		
		return  Integer.toString(nums);
	
}
		
}

	
	


   
  
       
   


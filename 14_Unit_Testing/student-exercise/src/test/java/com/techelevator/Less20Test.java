package com.techelevator;


	import org.junit.*;
	import org.junit.Test;

	public class Less20Test {
		
		
	 private Less20 target;
		 
		 @Before
		 public void setUp() {
			target = new Less20(); 
		 }
			
	     @Test
	     public void two_less_less_than_twenty_multiple(){
	    	 //arrange
	    	 //act
	    	 boolean result = target.isLessThanMultipleOf20(38);
	    	 //assert
	    	 Assert.assertTrue(result);
	    	}
	     @Test
	     public void one_less_less_than_twenty_multiple(){
	    	 //arrange
	    	 //act
	    	 boolean result = target.isLessThanMultipleOf20(19);
	    	 //assert
	    	 Assert.assertTrue(result);
	    	}
	     @Test
	     public void multiple_of_twenty(){
	    	 //arrange
	    	 //act
	    	 boolean result = target.isLessThanMultipleOf20(40);
	    	 //assert
	    	 Assert.assertFalse(result);
	    	}
	     @Test
	     public void is_more_than_multiple_of_20(){
	    	 //arrange
	    	 //act
	    	 boolean result = target.isLessThanMultipleOf20(81);
	    	 //assert
	    	 Assert.assertFalse(result);
	    	}
	     
	     

}

package com.techelevator;


	import org.junit.*;
	import org.junit.Test;

	public class SameFirstLastTest {
		
		
	 private SameFirstLast target;
		 
		 @Before
		 public void setUp(){
			target = new SameFirstLast(); 
		 }
			
	     @Test
	     public void array_is_bigger_than_one_and_first_and_last_are_equal(){
	    	 //arrange
	    	 int [] current = {0,2,3,0};
	    	 //act
	    	 boolean result = target.isItTheSame(current);
	    	 //assert
	    	 Assert.assertTrue(result);
	    	}
	     @Test
	     public void array_is_l(){
	    	 //arrange
	    	 int [] current = {0};
	    	 //act
	    	 boolean result = target.isItTheSame(current);
	    	 //assert
	    	 Assert.assertTrue(result);
	    	}
	     @Test
	     public void array_is_larger_than_one_but_first_does_not_equal_last(){
	    	 //arrange
	    	 int [] current = {0,2,3,4};
	    	 //act
	    	 boolean result = target.isItTheSame(current);
	    	 //assert
	    	 Assert.assertFalse(result);
	    	}
	     

}

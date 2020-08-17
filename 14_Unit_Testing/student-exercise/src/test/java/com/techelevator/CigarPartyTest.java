package com.techelevator;

import org.junit.*;
import org.junit.Test;

public class CigarPartyTest {
	
	
 private CigarParty target;
	 
	 @Before
	 public void setUp() {
		target = new CigarParty(); 
	 }
		
     @Test
     public void not_enough_cigars(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(60,true);
    	 //assert
    	 Assert.assertTrue(result);
    	}
     
     @Test
     public void too_many_cigars(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(61,true);
    	 //assert
    	 Assert.assertTrue(result);
    	}
     @Test
     public void too_few_cigars(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(2,true);
    	 //assert
    	 Assert.assertFalse(result);
    	}
     @Test
     public void is_weekend_with_more(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(61,true);
    	 //assert
    	 Assert.assertTrue(result);
    	}
     @Test
     public void is_weekend_less(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(31,true);
    	 //assert
    	 Assert.assertFalse(result);
    	}
     @Test
     public void is_weekend_but_still_in_range(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(40,true);
    	 //assert
    	 Assert.assertTrue(result);
    	}
     @Test
     public void not_weekend_but_cigars_too_many(){
    	 //arrange
    	 //act
    	 boolean result = target.haveParty(80,false);
    	 //assert
    	 Assert.assertFalse(result);
    	}

}

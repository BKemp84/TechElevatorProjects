package com.techelevator;

    import org.junit.*;

	public class Lucky13Test {
		
		
	 private Lucky13 target;
		 
		 @Before
		 public void setUp() {
			target = new Lucky13();  
		 }
			
	     @Test
	     public void has_any_3s(){
	    	 //arrange
		   int [] current = {0,2,5,0};
		   //act
		   boolean result = target.getLucky(current);
		  //assert
		    	 Assert.assertTrue(result);
		    	}
	     @Test
	     public void has_any_1s(){
	    	 //arrange
		   int [] current = {0,2,5,0};
		   //act
		   boolean result = target.getLucky(current);
		  //assert
		    	 Assert.assertTrue(result);
		    	} 
	     @Test
	     public void has_any_1s_and_3s(){
	    	 //arrange
		   int [] current = {1,2,3,0};
		   //act
		   boolean result = target.getLucky(current);
		  //assert
		    	 Assert.assertFalse(result);
		    	} 
	     @Test
	     public void has_any_just_1s(){
	    	 //arrange
		   int [] current = {0,2,1,0};
		   //act
		   boolean result = target.getLucky(current);
		  //assert
		    	 Assert.assertFalse(result);
		    	} 
	     @Test
	     public void has_just_3s(){
	    	 //arrange
		   int [] current = {0,2,3,0};
		   //act
		   boolean result = target.getLucky(current);
		  //assert
		    	 Assert.assertFalse(result);
		    	} 
	     
			
	     
	     

}

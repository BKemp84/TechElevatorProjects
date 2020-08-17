package com.techelevator;

    import org.junit.*;

	public class DateFashionTest {
		
		
	 private DateFashion target;
		 
		 @Before
		 public void setUp(){
			target = new DateFashion(); 
		 }

		 @Test
	     public void get_table_if_date_is_eight(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(2, 8);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 @Test
	     public void get_table_if_date_is_7(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(2, 7);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 
		 @Test
	     public void get_table_if_date_is_2(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(2, 2);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 @Test
	     public void get_table_if_you_are_a_2(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(2, 8);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 
		 @Test
	     public void get_table_if_both_2(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(2, 2);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 @Test
	     public void get_table_if_both_8(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(8, 7);
	    	 
	    	 //assert
	    	 Assert.assertEquals(2, result);
	    	}
		 @Test
	     public void get_table_if_you_are_9(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(9, 5);
	    	 
	    	 //assert
	    	 Assert.assertEquals(2, result);
	    	}
		 @Test
	     public void get_table_one_is_a_2(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(8, 2);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 @Test
	     public void get_table_if_both_are_5(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(5, 5);
	    	 
	    	 //assert
	    	 Assert.assertEquals(1, result);
	    	}
		 @Test
	     public void get_table_if_shes_1_and_you_3(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(3, 1);
	    	 
	    	 //assert
	    	 Assert.assertEquals(0, result);
	    	}
		 @Test
	     public void get_table_if_both_9(){
	    	 //arrange
	    	 //act
			 int result = target.getATable(9, 9);
	    	 
	    	 //assert
	    	 Assert.assertEquals(2, result);
	    	}
		 
		 
		 
		 
}

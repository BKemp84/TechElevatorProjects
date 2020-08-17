package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class LectureTest {

	// A variable to hold the class being tested
	private Lecture lecture;
	
	// Before instantiates and initializes the object
	// being tested so it is in the same state for each test
	@Before
	public void setup() {
		lecture = new Lecture();
	}
	
	/*
	 * Tests for or35
	 * 
	 * negative number
	 * multiple of both - 15
	 * multiple of 3
	 * multiple of 5
	 * 0
	 * non-multiple 
	 * max integer
	 * negative multiple 3
	 * 
	 */
	@Test
	public void negative_number_returns_false() {
		// Arrange  (setup)
		// Act (test)
		boolean result = lecture.or35( -1 );
		// Assert (verify) 
		Assert.assertFalse( result );
		
	}
	
	@Test
	public void multiple_of_three() {
		// Arrange
		// Act
		boolean result = lecture.or35( 9 );
		// Assert
		Assert.assertTrue( result );
	}
	
	@Test
	public void non_multiple_of_3_or_5() {
		// Arrange
		// Act
		boolean result = lecture.or35( 11 );
		// Assert
		Assert.assertFalse( result );
	}
	
	@Test
	public void max_int_value() {
		// Arrange
		// Act
		boolean result = lecture.or35( Integer.MAX_VALUE );
		// Assert
		Assert.assertFalse( result );
	}
	
	@Test
	public void negative_multiple_of_three() {
		// Arrange
		// Act
		boolean result = lecture.or35( -9 );
		// Assert
		Assert.assertFalse("-9 returned true", result );
	}
	
	/*
	 * Test for CaughtSpeeding
	 * 
	 * Testing with an integer result
	 */
	@Test
	public void driving_65_on_birthday_no_ticket()  {
		// Arrange
		// Act
		int ticket = lecture.caughtSpeeding(65, true);
		
		//Assert
		Assert.assertEquals(0, ticket);
	}
	
	/*
	 * Test of firstTwo
	 * String return
	 */
	@Test
	public void string_length_greater_than_2() {
		// Arrange
		// Act
		String firstTwo = lecture.firstTwo("Hello");
		// Assert
		Assert.assertEquals("He", firstTwo);
	}
	
	/*
	 * Test for no4LetterWords
	 * Asserting List and Array
	 */
	@Test
	public void list_dos_not_return_4_letter_words() {
		// Arrange
		String[] words = {"Train", "Boat", "Car" };
		String[] expectedResult = {"Train", "Car" };
		// Act
		List<String> resultList = lecture.no4LetterWords(words);
		// Assert
		String[] actualResult = resultList.toArray( new String[resultList.size()] );
		Assert.assertArrayEquals(expectedResult, actualResult);
	}
	
	/*
	 * Test robPeterToPayPaul
	 * Asserting with Maps
	 * Asserting with primitive wrappers ( Integer )
	 */
	@Test
	public void half_of_peters_money_given_to_paul() {
		// Arrange
		Map<String, Integer> peterPaul = new HashMap<String, Integer>();
		peterPaul.put("Peter", 2000);
		peterPaul.put("Paul", 500);
		
		// Act
		Map<String, Integer> resultMap = lecture.robPeterToPayPaul(peterPaul);
		
		//Assert
		Assert.assertEquals("Peters result", new Integer(1000), resultMap.get("Peter"));
		Assert.assertEquals("Pauls result", new Integer(1500), resultMap.get("Paul"));
	}
	
	/*
	 * Testing with doubles
	 */
	@Test
	public void test_with_no_rounding_error() {
		double result = lecture.thirdDouble(9);
		Assert.assertEquals(3, result, 0);
	}
	
	@Test
	public void test_with_rounding_error() {
		double result = lecture.thirdDouble(5);
		//5 /3 = 1.66666666666666667
		Assert.assertEquals(1.66, result, 2);
	}
	
	/*
	 * Testing with our own objects 
	 * and our own assert method
	 */
	@Test
	public void dog_returns_the_same_dog() {
		// Arrange
		Dog ourDog = new Dog("Fiddo", "Lab", 7);
		Dog returnedDog = lecture.returnOurDog( ourDog );
		
		//Assert.assertEquals(ourDog, returnedDog);
		assertDogs(ourDog, returnedDog);
	}
	
	private void assertDogs(Dog expected, Dog actual) {
		Assert.assertEquals(expected.getBreed(), actual.getBreed());
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getAge(), actual.getAge());
	}
	
	
	/*
	 * Testing with our own objects using assertEquals
	 */
	@Test
	public void dog_returns_the_same_dog_again() {
		// Arrange
		Dog ourDog = new Dog("Fiddo", "Lab", 7);
		Dog returnedDog = lecture.returnOurDog( ourDog );
		
		Assert.assertEquals(ourDog, returnedDog);
	
	}
	
	
}

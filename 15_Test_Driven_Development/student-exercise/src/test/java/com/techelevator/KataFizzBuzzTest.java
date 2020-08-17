package com.techelevator;

import org.junit.*;

	
public class KataFizzBuzzTest {
	
	private  KataFizzBuzz  target;
	
	@Before
	public void setup() {
		target = new KataFizzBuzz();
	}
	@Test
	public void is_it_not_divisble_by_3_and_5() {
		Assert.assertEquals("14", target.fizzBuzz(14));
	}
	@Test
	public void is_it_not_divisble_by_3() {
		Assert.assertEquals("4", target.fizzBuzz(4));
	}
	
	@Test
	public void is_divisble_by_three_and_five() {
		Assert.assertEquals("FizzBuzz", target.fizzBuzz(15));
	}
	@Test
	public void is_divisble_by_three() {
		Assert.assertEquals("Fizz", target.fizzBuzz(6));
	}
	@Test
	public void is_divisble_by_five() {
		Assert.assertEquals("Buzz", target.fizzBuzz(10));
	}
	@Test
	public void is_not_divisible_by_5() {
		Assert.assertEquals("14", target.fizzBuzz(14));
	}
	@Test
	public void contains_3() {
		Assert.assertEquals("Fizz", target.fizzBuzz(73));
	}
	@Test
	public void contains_5() {
		Assert.assertEquals("Buzz", target.fizzBuzz(52));
	}
	@Test
	public void contains_3_and5() {
		Assert.assertEquals("FizzBuzz", target.fizzBuzz(53));
	}
	
} 
 

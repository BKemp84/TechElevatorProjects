package com.techelevator;

import org.junit.*;

public class TriangleKataTest {

	private TriangleKata triangleKata;
	
	@Before
	public void setup() {
		triangleKata = new TriangleKata();
	}
	
	@Test
	public void identify_equilateral_triange() {
		Assert.assertEquals("equilateral", triangleKata.classify(4, 4, 4));
	}
	
	@Test
	public void identifies_invalid_triangle_with_1_and_2_lessThan_3() {
		Assert.assertEquals("invalid", triangleKata.classify(6, 6, 13));
		Assert.assertEquals("invalid", triangleKata.classify(6, 6, 12));
	}
	
	@Test
	public void identifies_invalid_triangle_with_2_and_3_lessThan_1() {
		Assert.assertEquals("invalid", triangleKata.classify(13, 6, 6));
		Assert.assertEquals("invalid", triangleKata.classify(12, 6, 6));
	}
	
	@Test
	public void identifies_invalid_triangle_with_1_and_3_lessThan_2() {
		Assert.assertEquals("invalid", triangleKata.classify(6, 13, 6));
		Assert.assertEquals("invalid", triangleKata.classify(6, 12, 6));
	}
	
	@Test
	public void all_sides_must_be_greater_than_0() {
		Assert.assertEquals("invalid", triangleKata.classify(0, 0, 0));
	}
	
	@Test
	public void identify_isosceles_when_side_1_and_2_equal() {
		Assert.assertEquals("isosceles", triangleKata.classify(10, 10, 1));
	}
	
	@Test
	public void identify_isosceles_when_side_1_and_3_equal() {
		Assert.assertEquals("isosceles", triangleKata.classify(10, 1, 10));
	}
	
	@Test
	public void identify_isosceles_when_side_2_and_3_equal() {
		Assert.assertEquals("isosceles", triangleKata.classify(1, 10, 10));
	}

	@Test
	public void identify_scalene() {
		Assert.assertEquals("scalene", triangleKata.classify(2, 3, 4));
	}
	
}

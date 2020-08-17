package com.techelevator.trees;

import org.junit.*;

public class FruitTreeTest {

	private FruitTree fruitTree;
	
	@Before
	public void createFruitTree() {
		fruitTree = new FruitTree("Pears", 10);
	}
	
	@Test
	public void pick_5_fruit() {
		// Arrange
		// Act
		Assert.assertTrue( fruitTree.pickFruit(5) );
		
		// Not only assert for the return, but also side effects (changes in object state)
		Assert.assertEquals( 5, fruitTree.getPiecesOfFruitLeft() );
	}
	
	@Test
	public void cannot_pick_fruit_when_no_fruit_remains() {
		// Arrange
		fruitTree.pickFruit(10);
		// Act
		Assert.assertFalse( fruitTree.pickFruit(1) );
		
//		boolean result = fruitTree.pickFruit(1);
//		Assert.assertFalse( result );
		
		Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft());
	}
 }

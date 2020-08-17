package com.techelevator;

public class RectangleDemo {

	public static void main(String[] args) {
		
		Rectangle wall = new Rectangle(10, 20);
		Rectangle wall2 = new Rectangle(-12, 8);
		
		Rectangle wall3 = new Rectangle();
		
//		wall.setWidth( 10 );
//		wall.setHeight( 20 );
//		
//		wall2.setWidth( 12 );
//		wall2.setHeight( 8 );
		
		wall.setWidth( 219 );
		
		wall2.setWidth(33333);

		int wallWidth = wall.getWidth();
		int wall2Height = wall2.getHeight();
	
		wall.setHeight( -10 );
		
		boolean isWall2Larger = wall2.isLargerThan( wall );
		int wallArea = wall.getArea();
		
		int height = 22;
		int width = 33;
		
		boolean isDimensionsLarger = wall.isLargerThan(height, width);
		
		System.out.println( wall );
		
		Rectangle wall4 = new Rectangle(10, 20);
		Rectangle wall5 = new Rectangle(10, 20);
		
		boolean isSameWall = wall4.equals(wall5);
		
	}

}

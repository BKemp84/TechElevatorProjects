package com.techelevator;

public class Rectangle {
	
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle( int height, int width ) {
		this.height = Math.abs(height);
		this.width = Math.abs(width);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth( int width ) {
		this.width = Math.abs(width);
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight( int height ) {
		this.height = Math.abs(height);
	}
	
	// Derived Property
	public int getArea() {
		return this.width * this.height;
	}
	
	// isLargerThan is Overloaded
	public boolean isLargerThan( Rectangle other) {
		return this.getArea() > other.getArea();
	}
	
	public boolean isLargerThan(int height, int width) {
		return this.getArea() > height * width;
	}
	
	// Override
	@Override
	public String toString() {
		return this.width + "x" + this.height + " - " 
				+ this.getArea() + " square feet";
	}
	
	@Override
	public boolean equals(Object obj) {
		Rectangle other = (Rectangle) obj;
		return this.height == other.getHeight() 
				&& this.width == other.getWidth();
				
	}
	
}

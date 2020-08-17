package com.techelevator;

public class SquareWall extends RectangleWall {
	 
	private int sidelength;
	
	public SquareWall(String name, String color, int sideLength) {
	   super(name, color, sideLength, sideLength);
	}
	
	public int getSideLength() {
		return sidelength;
	}
	
	public void setSideLength(int sideLength) {
		this.sidelength = sidelength;
	}
	
	@Override
	public String toString() {
	return getName() + " (" + getLength() + "x" + getHeight() + ") square";
}
}
package com.techelevator;

public class TriangleWall extends Wall {

private int base;
private int height;

public TriangleWall(String name, String color, int base, int height) {
	super(name, color);
	this.base = base;
	this.height = height;
	
}
@Override
public int getArea() {
	return (base * height)/2;
	
}

public int getBase() {
	return base;
}

public void setBase(int base) {
	this.base = base;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public String toString() {
	return getName() +  " (" + getBase() + "x" + getHeight() +  ") triangle";
}
}

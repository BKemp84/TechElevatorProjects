package com.techelevator.exceptions.calc.exception;

public class InvalidStringException extends Exception {
	
	private String originalValue;
	
	public InvalidStringException(String message, String originalValue) {
		super(message);
		this.originalValue = originalValue;
	}
	
	public String getOriginalValue() {
		return this.originalValue;
	}

}

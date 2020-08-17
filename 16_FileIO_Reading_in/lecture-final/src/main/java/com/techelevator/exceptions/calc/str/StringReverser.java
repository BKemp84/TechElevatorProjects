package com.techelevator.exceptions.calc.str;

import com.techelevator.exceptions.calc.exception.InvalidStringException;

public class StringReverser {

	public String reverseString(String str) throws InvalidStringException {
		
		if (str.equalsIgnoreCase("bob")) {
			throw new InvalidStringException("Can't be revesed", str);
		}
		
		
		String reversed = "";
		
		for (int i = str.length() - 1; i >= 0 ; i--) {
			reversed += str.charAt(i);
		}
		
		return reversed;
	}
}

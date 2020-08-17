package com.techelevator.exceptions.calc.str;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.exception.InvalidStringException;

public class StringCalculator implements Calculator {

	
	@Override
	public List<String> calculate(List<String> values) throws InvalidStringException {
		
		StringReverser reverser = new StringReverser();
		List<String> results = new ArrayList<String>();
		
		for (int i = 0; i < values.size(); i++) {
			String reversed;
			try {
				reversed = reverser.reverseString(values.get(i));
			} catch (NullPointerException e) {
				reversed = "null";
			} 
			results.add(reversed);
		}
		 
		return results;
	}

	
}

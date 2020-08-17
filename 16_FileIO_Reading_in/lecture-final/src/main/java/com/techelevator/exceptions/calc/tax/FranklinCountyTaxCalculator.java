package com.techelevator.exceptions.calc.tax;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.exceptions.calc.Calculator;

public class FranklinCountyTaxCalculator implements Calculator {


	@Override
	public List<String> calculate(List<String> values) {
		List<String> results = new ArrayList<String>();
		
		for (String value : values) {
			try {
				double amt = Double.parseDouble(value);
				double rate = amt * 0.075;
				results.add(String.valueOf(rate));
			} catch (NullPointerException e) {
				/* Exception is caught and continued so blank lines are skipped */
				continue;
			}
		}
		
		return results;
	}

}

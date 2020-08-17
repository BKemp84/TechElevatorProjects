package com.techelevator.exceptions.calc.str;

import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;
import com.techelevator.exceptions.calc.exception.InvalidStringException;

public class MainStringCalc {

	public static void main(String[] args)  {
		
		Menu menu = new Menu();
		Calculator strCalc = new StringCalculator();
		
		List<String> values = menu.getValuesFromUser();

		List<String> results = null;
		try {
			results = strCalc.calculate(values);
			
			for (String result : results) {
				menu.displayUserMessage(result);
			}
			
		} catch (InvalidStringException e) {
			menu.displayUserMessage(e.getMessage() + " : " + e.getOriginalValue());
		}	
		
	}

}

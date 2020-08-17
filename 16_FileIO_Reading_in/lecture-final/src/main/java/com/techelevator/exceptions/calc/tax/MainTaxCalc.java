package com.techelevator.exceptions.calc.tax;

import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;
import com.techelevator.exceptions.calc.exception.InvalidStringException;

public class MainTaxCalc {

	public static void main(String[] args) {
	
		
			Menu menu = new Menu();
			Calculator salesTax = new FranklinCountyTaxCalculator();
			
			List<String> values = menu.getValuesFromUser();

			try {
				List<String> results = salesTax.calculate(values);	
			
				for (String result : results) {
					menu.displayUserMessage(result);
				}
			} catch (NumberFormatException e) {
				menu.displayUserMessage("Invalid character entered");
			} catch (NullPointerException e) {
				menu.displayUserMessage("List did not exist");
			} catch (InvalidStringException e) {
				menu.displayUserMessage("This should never happen!");
			}
	
	}

}

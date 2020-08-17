package com.techelevator.exceptions.calc;

import java.util.List;

import com.techelevator.exceptions.calc.exception.InvalidStringException;

public interface Calculator {

	List<String> calculate(List<String> values) throws InvalidStringException;
}

package com.techelevator.chucknorris;

import java.util.Scanner;

public class ChuckNorrisDemo {

	public static void main(String[] args) {
		
		ChuckNorrisService service = new ChuckNorrisService();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Category >>>");
		String category = input.nextLine();
		
		Joke joke = service.requestJoke(category);
		Value value = joke.getValue();
		String actualJoke = value.getJoke();
		
		System.out.println(actualJoke);
		
		System.out.println( service.requestJoke(category).getValue().getJoke() );

	}

}

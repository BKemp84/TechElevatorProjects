package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> instructors = new ArrayList<String>();
		
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Matty");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println( instructors.get(i) );
		}

		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		instructors.add("John");
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		instructors.add(1, "Rachelle");
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		instructors.remove( 5 );
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean isRachelleIsInList = instructors.contains("Rachelle");
		boolean isJoshInTheList = instructors.contains("Josh");
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorArray = instructors.toArray( new String[ instructors.size() ] );
		
		// Arrays can also be turned into Lists
		List<String> instructorList = Arrays.asList( instructorArray );
		
		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		Integer employees = new Integer(25);
		Integer piecesOfCake = new Integer("24");
		
		boolean enoughCake = employees > piecesOfCake;
		
		int num = 10;
		Integer numWrapper = num;
		Integer xyz = 20;
		int xyzAsInt = xyz;
		
		num = num + 10;
		Double d = null;
		//d = d + 2;
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add( 10 );
		numbers.add( 20 );
		numbers.add( 30 );
		numbers.add( 40 );
		
		int sum = numbers.get( 2 ) + 5;
		
		
	
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println( instructors.get(i) );
		}
		
		for (String name : instructors) {
			System.out.println( name );
		}
		
		double[] doubleNums = { 2.4, 3.14, 5.678 };
		
		for ( double n : doubleNums ) {
			System.out.println(  n + 1 );
		}
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> tasks = new LinkedList<String>();

		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Clean dog");
		tasks.offer("Scrub ceiling");
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		while (tasks.isEmpty() == false) {
			System.out.println("Next task: " + tasks.poll() );
			System.out.println("Remaining tasks: " + tasks.size() );
		}
		
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack<String> history = new Stack<String>();
		
		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		history.push("www.google.com");
		history.push("stackoverflow.com");
		history.push("techelevator.com");
		history.push("codinghorror.com");
		
		////////////////////
		// POPPING THE STACK
		////////////////////
		
		while( !history.isEmpty() ) {
			System.out.println("Last address: " + history.pop() );
		}
		
		
		int[] nums = { 10, 20, 30, 40, 50 };
		Stack<Integer> numStack = new Stack<Integer>();
		
		for (int n : nums) {
			numStack.push( n );
		}
		
		while ( !numStack.isEmpty() ) {
			System.out.println( numStack.pop() );
		}

	}
}

package com.techelevator;
import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
// add scanner
// x ask the user for the bill amount 
// x ask how much money was given to pay tendered
// compute the difference bill amount - money tendered
// use system.outprint the change
public class MakeChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter amount of bill >>");
		String billAmount = in.nextLine();
		double billAmountNum = Double.parseDouble(billAmount);
		System.out.println("Please enter the amount tendered >>");
		String amountTendered = in.next();
		double amountTenderedNum = Double.parseDouble(amountTendered); 
		double changeAmount = amountTenderedNum - billAmountNum ;
		System.out.println("The change required is " + changeAmount  );

	}

}

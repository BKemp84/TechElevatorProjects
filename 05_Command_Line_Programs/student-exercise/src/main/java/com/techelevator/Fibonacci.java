package com.techelevator;
import java.util.Scanner;

import org.junit.internal.runners.model.EachTestNotifier;
import org.mockito.asm.tree.analysis.Value;
public class Fibonacci {

	public static void main(String[] args) {
		
		int n, first = 0, next = 1;
		System.out.print("Please enter value of n:");
		
		
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		//System.out.print(" " + n + " ");
		System.out.print(first +" " + next);
		for (int i = 0; i<=n; ++i) {
			int sum = first + next;
			first = next;
			next = sum;
			System.out.print(" " + sum);
			
		}// Please enter the Fibonacci number:25	
		//	display fibonacci leading up to that number
		// 0, 1, 1, 2, 3, 4, 5, 8, 13, 21
	}

}

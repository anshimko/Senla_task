package com.senla.task05;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			System.out.println("Please, enter a number");

			int number = scan.nextInt();
			
		IntStream.range(0, number)
			.limit(100)
			.mapToObj(String::valueOf)
			.filter(x -> x.equals(new StringBuilder(x).reverse().toString()))
			.forEach(System.out::println);
		
		}
	}
}

package com.senla.task01;

import java.util.Scanner;
import java.util.function.Predicate;

public class Solution {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			System.out.println("Please, enter an integer number");
			int num = scan.nextInt();

			Predicate<Integer> isEvenLambda = (x -> x % 2 == 0);

			Predicate<Integer> isPrimeLambda = (x -> {
				for (int i = 2; i < x / 2; i++) {
					if (x % i == 0) {
						return false;
					}
				}
				return true;
			});

			String isEven = isEvenLambda.test(num) ? "even" : "odd";
			String isPrime = isPrimeLambda.test(num) ? "prime" : "composite";

			System.out.println(isEven + " and " + isPrime);

		} catch (Exception e) {
			System.out.println("You did't enter an integer number");
		}
	}
}

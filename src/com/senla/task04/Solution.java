package com.senla.task04;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			
			String regex = "\\s+";

			System.out.println("Please, enter some sentence");
			String sentence = scan.nextLine();
			String[] words = sentence.split(regex);
			
			System.out.println("Please, enter the word you are looking for");
			String word = scan.next();
			
			long count = Arrays.stream(words)
					.filter(x -> x.equalsIgnoreCase(word))
					.count();
			
			System.out.println(count);

		}
	}
}

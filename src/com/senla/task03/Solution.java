package com.senla.task03;

import java.util.Arrays;
import java.util.Scanner;

/*
3. Создать программу, которая будет:
подсчитывать количество слов в предложении
выводить их в отсортированном виде 
делать первую букву каждого слова заглавной. 
Предложение вводится вручную. (Разделитель пробел (“ ”)).
*/

public class Solution {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			
			System.out.println("Please, enter some sentence");

			String sentence = scan.nextLine();
			String[] words = sentence.split(" ");
			
			System.out.println("Count of words are " + words.length);
			
			Arrays.stream(words)
				.sorted().map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
				.forEach(System.out::println);

		}
	}
}

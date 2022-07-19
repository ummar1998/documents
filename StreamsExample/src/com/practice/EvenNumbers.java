package com.practice;

import java.util.stream.IntStream;

public class EvenNumbers {
	public static void main(String[] args) {

		// counting all the even numbers between 1 to 200
		long count = IntStream.rangeClosed(1, 200).filter((x) -> x % 2 == 0).count();
		System.out.println(count);

		// printing all the even numbers between 1 to 200

		IntStream.rangeClosed(1, 200).filter((x) -> x % 2 == 0).forEach(System.out::println);

		// Counting all the even numbers between 1 to 50
		long count2 = IntStream.rangeClosed(1, 50).filter((x) -> x % 2 == 0).count();
		System.out.println(count2);

	}

}

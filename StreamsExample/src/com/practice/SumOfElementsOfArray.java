package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class SumOfElementsOfArray {

	public static void main(String[] args) {
		int numbers[] = { 19, 45, 78, 23, 66, 89, 90, 123 };

		// method 1
		List<Integer> list = Arrays.asList(19, 45, 78, 23, 66, 89, 90, 123);
		Integer sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Method 1 " + sum);

		// method 2
		int sum1 = Arrays.stream(numbers).reduce(0, (x, y) -> x + y);
		System.out.println("Method 2 " + sum1);

		// method 3

		Integer collect = list.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Method 3 " + collect);

		// method 4

		int sum2 = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Method 4 " + sum2);

		// getting sum from a string

		String string = "Item1 10 Item2 25 Item3 30 Item4 45";

		int sum3 = Arrays.stream(string.split(" ")).filter((x) -> x.matches("\\d+")).mapToInt(Integer::valueOf).sum();

		System.out.println("String values " + sum3);

		// method 5 using .sum()method
		int sumArray = Arrays.stream(numbers).sum();
		System.out.println("From Sum " + sumArray);

		OptionalDouble average = Arrays.stream(numbers).average();
		System.out.println("Average " + average);
	}

}

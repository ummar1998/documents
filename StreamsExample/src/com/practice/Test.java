package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1.Find all transactions in the year 2011 and sort them by value (small to
		// high).

		List<Transaction> list = transactions.stream().filter((x) -> x.getYear() == 2011)
				.sorted(Comparator.comparingInt(Transaction::getValue).reversed()).collect(Collectors.toList());

		System.out.println(list);

//		2.What are all the unique cities where the traders work?

		List<String> city = transactions.stream().map((x) -> x.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		System.out.println(city);

		// 3.Find all traders from Cambridge and sort them by name.

		List<Transaction> fromCambridge = transactions.stream()
				.filter((x) -> x.getTrader().getCity().equals("Cambridge"))
				.sorted((i1, i2) -> i1.getTrader().getName().compareTo(i2.getTrader().getName()))
				.collect(Collectors.toList());
		System.out.println(fromCambridge);

		// 4. Return a string of all traders’ names sorted alphabetically.

		List<Transaction> names = transactions.stream()
				.sorted((i1, i2) -> i1.getTrader().getName().compareTo(i2.getTrader().getName()))
				.collect(Collectors.toList());
		System.out.println(names);

		// 5 . Are any traders based in Milan?

		boolean milanTraders = transactions.stream().anyMatch((x) -> x.getTrader().getCity().equals("Milan"));
		System.out.println(milanTraders);

//		6. Print all transactions’ values from the traders living in Cambridge.

		transactions.stream().filter((x) -> x.getTrader().getCity().equals("Cambridge"))
				.sorted(Comparator.comparingInt(Transaction::getValue).reversed()).forEach(System.out::println);
		;

//		7. What’s the highest value of all the transactions?
		Optional<Transaction> max = transactions.stream().max((i1, i2) -> i1.getValue() - i2.getValue());
		System.out.println("Max Value " + max);
		
//		Find the transaction with the smallest value.
		Optional<Transaction> min = transactions.stream().min((i1, i2) -> i1.getValue() - i2.getValue());
		System.out.println("Min value " + min);
	}

}

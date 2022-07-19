package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingDuplicateElements {

	public static void main(String[] args) {

		// method 1 using set
		Stream<String> stream = Stream.of("john", "doe", "doe", "tom", "john");

		Set<String> ns = new HashSet<>();
		stream.filter((n) -> !ns.add(n)).collect(Collectors.toSet()).forEach(System.out::println);

		// method 2 using collection.frequecy()method
		
		List<Integer> newList= new ArrayList<>(Arrays.asList(5,12,25,10,5,21,10));
		
		newList.stream().filter((i)->Collections.frequency(newList, i)>1)
		.collect(Collectors.toSet()).forEach(System.out::println);
	}

}

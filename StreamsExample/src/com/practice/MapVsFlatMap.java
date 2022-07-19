package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

public class MapVsFlatMap {

	public static void main(String[] args) {

		List<Integer> evenList = Arrays.asList(2,4,6,8);
		List<Integer> oddList = Arrays.asList(1,3,5,7);
		
		List<List<Integer>> listofList = Arrays.asList(evenList,oddList);
		
		System.out.println("List before flattenig "+listofList);
		
		List<Integer> flattenMap = listofList.stream().flatMap((x)->x.stream()).collect(Collectors.toList());
		System.out.println("After flatenning "+flattenMap);
		
		
		List<String> list = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");
		
		List<Character> collect = list.stream().flatMap((x)->Stream.of(x.charAt(1))).collect(Collectors.toList());
		System.out.println(collect);
	}

}

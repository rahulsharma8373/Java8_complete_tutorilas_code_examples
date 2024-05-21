package com.java8.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurence {

	public static void main(String[] args) {
		String input = "My name is Rahul";
		input = input.toUpperCase();
		Map<String, Long> countmap = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countmap);

	}

}

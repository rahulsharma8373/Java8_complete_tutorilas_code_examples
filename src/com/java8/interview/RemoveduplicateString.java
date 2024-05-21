package com.java8.interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveduplicateString {
	public static void main(String[] args) {
		String input = "rahuullllllkk";
		// 1st approach
		//Arrays.stream(input.split("")).collect(Collectors.toSet()).forEach(System.out::print);

		// 2nd approach
		input.chars().mapToObj(item -> (char) item).collect(Collectors.toSet()).forEach(System.out::print);
	}
}

package com.java8.functional.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
// Consumer --->> This interface accepts one arguments But there is no return value.

	public static void main(String[] args) {

		// List of value : names
		// print all Upper case
		List<String> names = List.of("abc", "xyz", "Mno", "pQR");
		Consumer<String> printUppercase = str -> System.out.println(str.toUpperCase());
		printUppercase.accept("Rahul");
		names.forEach(printUppercase);
		List<String> newValue = new ArrayList<>();

		Consumer<String> addToList = str -> newValue.add(str.toUpperCase());
		names.forEach(addToList);
		System.out.println(newValue);
		
	}

}

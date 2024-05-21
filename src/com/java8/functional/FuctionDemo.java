package com.java8.functional;

import java.util.function.Function;

public class FuctionDemo {
	public static void main(String[] args) {
		// find half value from given value
		Function<Integer, Double> halfvalu = i -> i / 2.0;
		Double result = halfvalu.apply(10);
		System.out.println(result);

		// given string converted to uppercase
		Function<String, String> func1ToUppercase = String::toUpperCase;
		System.out.println(func1ToUppercase.apply("rahul"));

		// null check
		Function<String, String> func2nullCheck = str -> str == null ? "Enter valid value" : str;

		String v = func2nullCheck.andThen(func1ToUppercase).apply("This is  rahul");
		System.out.println(v);
		System.out.println("This is functionality of compose");
		v = func2nullCheck.compose(func1ToUppercase).apply("This is compose");
		System.out.println(v);

		// static identity
		Function<Integer, Integer> identicalValue = Function.identity();
		System.out.println(identicalValue.apply(100));

	}
}

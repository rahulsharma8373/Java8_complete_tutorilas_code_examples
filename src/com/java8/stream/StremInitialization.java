package com.java8.stream;
//1. Intermediate operation-->> When we call a method belongs to

// intermediate operations, it will always returns another strem
// objects of the operations results
// We can call many intermediate operations on same stream instance as chain of methods.
// This is called pipeline on same stream source

// -->> Intermediate Operations are executed only once when we invoke terminal operatuons.

// 2. Terminal Operations: ---->>> 
// we can call only one terminal method on any strem instance
// when we call terminal method, immediately we will get the resut
// of all pipelined operations on the same Stream objects
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StremInitialization {
	public static void main(String[] args) {
		// 1. From Collection Object
		List<String> values = List.of("One", "Two", "Three");
		Stream<String> stream1 = values.stream();

		// Arrays of values
		String[] names = { "One", "Two", "Three" };
		Stream<String> stream2 = Arrays.stream(names);
		// stream methods
		Stream<String> stream3 = Stream.of("One", "Two", "Three");

		// generate()
		Stream<String> stream4 = Stream.generate(() -> "One").limit(0);
// builder()
		// Builder design pattern

		Builder<String> streamBuilder = Stream.builder();
		Stream<String> stream5 = streamBuilder.add("One").add("Two").add("Three").build();
// empty stream
		// empty
		Stream<String> stream6 = Stream.empty();

		
		
		
		
		
		
		
		
		
		
	}

}

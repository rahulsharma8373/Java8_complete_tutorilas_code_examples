package com.java8.optional;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		// Creating an Optional instance with a non-null value
		Optional<String> optionalWithValue = Optional.of("Hello, World!");

		// Creating an Optional instance with a possibly null value
		String nullableString = null;
		Optional<String> optionalNullable = Optional.ofNullable(nullableString);

		// Creating an empty Optional instance
		Optional<String> emptyOptional = Optional.empty();

		// ifPresent method: Executes the lambda expression if the value is present
		optionalWithValue.ifPresent(value -> System.out.println("Value is present: " + value));

		// filter method: Filters the value if it matches the given predicate
		Optional<String> filteredOptional = optionalWithValue.filter(value -> value.contains("World"));
		filteredOptional.ifPresent(value -> System.out.println("Filtered value: " + value));

		// map method: Transforms the value if present
		Optional<Integer> mappedOptional = optionalWithValue.map(String::length);
		mappedOptional.ifPresent(length -> System.out.println("Length of the string: " + length));

		// flatMap method: Similar to map, but the mapping function returns an Optional
		Optional<String> flatMappedOptional = optionalWithValue.flatMap(value -> Optional.of(value.toUpperCase()));
		flatMappedOptional.ifPresent(value -> System.out.println("Uppercased value: " + value));

		// orElse method: Returns the value if present, otherwise returns the given
		// default value
		String valueOrDefault = optionalNullable.orElse("Default Value");
		System.out.println("Value or default: " + valueOrDefault);

		// orElseGet method: Similar to orElse, but the default value is provided by a
		// Supplier
		String valueOrElseGet = optionalNullable.orElseGet(() -> "Generated Default Value");
		System.out.println("Value or generated default: " + valueOrElseGet);

		// orElseThrow method: Returns the value if present, otherwise throws the given
		// exception
		try {
			String valueOrException = optionalNullable
					.orElseThrow(() -> new IllegalStateException("Value not present"));
			System.out.println("Value or exception: " + valueOrException);
		} catch (IllegalStateException e) {
			System.out.println("Caught exception: " + e.getMessage());
		}

		// isPresent method: Checks if a value is present
		System.out.println("Is value present in optionalWithValue: " + optionalWithValue.isPresent());
		System.out.println("Is value present in optionalNullable: " + optionalNullable.isPresent());

		// isEmpty method: Checks if a value is not present
		System.out.println("Is optionalWithValue empty: " + optionalWithValue.isEmpty());
		System.out.println("Is optionalNullable empty: " + optionalNullable.isEmpty());

		// Stream method: Returns a sequential Stream containing only the present value
		optionalWithValue.stream().forEach(value -> System.out.println("Value from stream: " + value));

		// ifPresentOrElse method: Executes one of two Runnable lambdas based on
		// presence or absence of value
		optionalNullable.ifPresentOrElse(value -> System.out.println("Value is present: " + value),
				() -> System.out.println("No value present, running alternative"));

		// or method: Returns an Optional describing the value if present, otherwise
		// returns an Optional produced by the supplying function
		Optional<String> orOptional = optionalNullable.or(() -> Optional.of("Alternative Value"));
		System.out.println("Value from or method: " + orOptional.get());
		/*
		 * Creating Optional Instances:
		 * 
		 * Optional.of(value): Creates an Optional with a non-null value.
		 * Optional.ofNullable(value): Creates an Optional with a value that might be
		 * null. Optional.empty(): Creates an empty Optional. Checking Presence of
		 * Value:
		 * 
		 * isPresent(): Returns true if there is a value present, otherwise false.
		 * isEmpty(): Returns true if there is no value present, otherwise false.
		 * Conditional Execution:
		 * 
		 * ifPresent(Consumer): Executes the given lambda if a value is present.
		 * ifPresentOrElse(Consumer, Runnable): Executes the first lambda if a value is
		 * present; otherwise, executes the second lambda. Transforming Values:
		 * 
		 * map(Function): Transforms the value if present, returning a new Optional.
		 * flatMap(Function): Transforms the value if present and returns a new Optional
		 * directly. Filtering Values:
		 * 
		 * filter(Predicate): Filters the value if it matches the given predicate,
		 * returning an Optional. Default Values:
		 * 
		 * orElse(value): Returns the value if present, otherwise returns the given
		 * default value. orElseGet(Supplier): Returns the value if present, otherwise
		 * invokes the given supplier and returns its result. orElseThrow(Supplier):
		 * Returns the value if present, otherwise throws an exception provided by the
		 * supplier. or(Supplier): Returns the current Optional if it has a value,
		 * otherwise returns an Optional produced by the given supplier. Other Methods:
		 * 
		 * stream(): Returns a stream containing the value if present.
		 * ifPresentOrElse(Consumer, Runnable): Performs an action if a value is
		 * present, or a different action if no value is present. This example covers
		 * most of the commonly used methods of the Optional class, demonstrating how
		 * they can help manage null values and avoid NullPointerException.
		 */
	}
}

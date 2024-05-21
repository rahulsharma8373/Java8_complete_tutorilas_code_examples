package com.java8.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		Optional<String> nameContainer = getName(); // method call : getting 100% non null value
		if (nameContainer.isPresent()) {
			String name = nameContainer.get();
			name = name.toUpperCase();
			System.out.println(name);
		}

	}

	public static Optional<String> getName() {
		// Returning a value
		// keep the actual value inside the optional object -->>> container object
	//  
		Optional<String> value = Optional.of("Rahul Kumar");
		return value;
	}
}

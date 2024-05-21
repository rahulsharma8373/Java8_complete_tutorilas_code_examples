package com.java8.optional;

import java.util.Optional;

public class OptionalEptyUseCase {

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
		String name = null;
		Optional<String> value = null;
		if (name == null) {
			value = Optional.empty();
		} else {
			value = Optional.of(name);

		}

		return value;
	}
}

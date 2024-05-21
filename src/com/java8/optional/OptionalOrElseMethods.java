package com.java8.optional;

import java.util.Optional;

public class OptionalOrElseMethods {

	public static void main(String[] args) {
		Optional<String> nameContainer = getName();
// or()
// if value is prensented ,return same optional object value
		// if value is not presented then supplier Functionality
		// will produce another optional with value;
		String str = nameContainer.or(() -> {
			return Optional.of("java optional value");
		}).get();
		System.out.println(str);
		// orElse()
		// if value presented return the value
		// if value not presented we can configure anothet value and taht will
		// Return the value if present, otherwise return other

		String str1 = nameContainer.orElse("This is orElse method value");
		System.out.println(str1);
		// orElseGet()-->>> eturn the value if present, otherwise
		// invoke other and return the result of that invocation.
		//
		String str2 = nameContainer.orElseGet(() -> {
			return "This orElseGet";
		});
		System.out.println(str2);

		// orElseThrow()
		
		
	String str3=	nameContainer.orElseThrow();
		System.out.println(str3);
		
		
	};

	public static Optional<String> getName() {
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

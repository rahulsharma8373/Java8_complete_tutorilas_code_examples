package com.java8.functional.supplier;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
// Get date and time Always
		Supplier<LocalDateTime> dataTime = () -> LocalDateTime.now();
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		System.out.println(dataTime.get());
		printCurrentTimeNow(dataTime);
	}

	public static void printCurrentTimeNow(Supplier<LocalDateTime> dateTime) {
		System.out.println(dateTime.get());
	}
}

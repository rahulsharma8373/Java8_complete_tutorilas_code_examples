package com.java8.functional;

public interface Calculate {
	// 1. only one
	void printName();

	// N : default methods

	default void methodOne() {
		System.out.println("this is default method one");
	}

	default void methodTwo() {
		System.out.println("this is default method two");

	}

	static void methodStaticOne() {
		System.out.println("this is static method one");

	}

	static void methodStaticTwo() {
		System.out.println("this is static method two");

	}
}

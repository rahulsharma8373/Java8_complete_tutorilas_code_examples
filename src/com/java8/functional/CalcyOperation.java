package com.java8.functional;

@FunctionalInterface
public interface CalcyOperation {
	double operatio(int a, int b);
	default void printInfo() {
		System.out.println("this default data of method");
	}
	static void typeOfOperations() {
		System.out.println("static content : Arithmetic Operations");
	}
}

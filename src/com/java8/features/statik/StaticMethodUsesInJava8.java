package com.java8.features.statik;
/**
 * Static methods in interfaces were introduced in Java 8.
 * They provide a way to define utility methods that can be called directly on the interface itself,
 * without needing an instance of the implementing class.
 * These methods are primarily used for helper functions or utility operations related to the interface.
* we can't call static method through implementing class
 */

interface MathOperations {
	static int add(int a, int b) {
		return a + b;
	}

	static int subtract(int a, int b) {
		return a - b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

	static double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero!");
		}
		return a / b;
	}
}

public class StaticMethodUsesInJava8 {
	public static void main(String[] args) {

		int resultAdd = MathOperations.add(5, 3);
		System.out.println("Addition: " + resultAdd);

		int resultSubtract = MathOperations.subtract(10, 4);
		System.out.println("Subtraction: " + resultSubtract);

		int resultMultiply = MathOperations.multiply(6, 7);
		System.out.println("Multiplication: " + resultMultiply);

		double resultDivide = MathOperations.divide(10.0, 2.0);
		System.out.println("Division: " + resultDivide);

	}
}
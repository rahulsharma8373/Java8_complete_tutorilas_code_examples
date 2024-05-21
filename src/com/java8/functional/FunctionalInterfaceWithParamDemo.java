package com.java8.functional;

public class FunctionalInterfaceWithParamDemo {
	public static void main(String[] args) {

		CalcyOperation addition = (int x, int y) -> {
			System.out.println("values are: " + x + " ,  " + y);
			return x + y;
		};
		// executing lambda expression
		double result = addition.operatio(2, 20);
		System.out.println(result);

		// 2nd lambda expression
		CalcyOperation sub = (p, q) ->  p - q;
		 
		double result1 = sub.operatio(20, 2);
		System.out.println(result1);
	}
}

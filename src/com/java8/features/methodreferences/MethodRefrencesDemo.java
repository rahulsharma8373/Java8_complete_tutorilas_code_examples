package com.java8.features.methodreferences;

public class MethodRefrencesDemo {
	public static void main(String[] args) {
		// Lambda expression
		ConvertToUpperCase cToUpperCase = (value) -> {
			return value.toUpperCase();
		};
		System.out.println(cToUpperCase.convertUppercase("rahul"));
	
	// method references
		// Method references are a special type of Lambda Expression
	
		// :: method delemeter
		// Re- Using/executing a pre defined method from String class
		// assigning that method reference of class
		
		ConvertToUpperCase case1=String::toUpperCase;
	System.out.println(case1.convertUppercase("rahul"));
	
	
	}
}

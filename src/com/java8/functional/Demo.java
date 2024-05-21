package com.java8.functional;

public class Demo {

	public static void main(String[] args) {
		// Interface can refer impl. class Instance
		Calculate calc = new Camel();
		calc.printName();

		// Lambda Expression
		Calculate abc = () -> {
			System.out.println("this is ABC Company");
		};
		Calculate xyz = () -> {
			System.out.println("this is xyz Company");
		};
		abc.printName();
		xyz.printName();
		
	}

}

package com.java8.features;

public class ClassThree implements InterfaceOne,InterfaceTwo {

	@Override
	public void defaultMethodFive() {
		InterfaceOne.super.defaultMethodFive();
	InterfaceTwo.super.defaultMethodFive();
	}

}

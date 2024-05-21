package com.java8;
// Uses of default method 
interface Fruit {
	void eat();

	default void peel() {
		System.out.println("Peeling this fruit...");
	}

}

class Apple implements Fruit {

	@Override
	public void eat() {
		System.out.println("Eating an apple");

	}

}

class Banana implements Fruit {

	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	public void peel() {

		System.out.println("Peeling a banana is easy!");
	}

}

class Orange implements Fruit {
	@Override
	public void eat() {
		System.out.println("Eating an orange");

	}
}

public class Main {

	public static void main(String[] args) {
		Fruit apple = new Apple();
		apple.eat();
		apple.peel(); // Will call the default peel method
		Fruit banana = new Banana();
		banana.eat();
		banana.peel(); // Will call the overridden peel method

		Fruit orange = new Orange();
		orange.eat();
		orange.peel(); // Will call the default peel method
//So, default methods in Java are like a backup plan for 
// doing something if a class doesn't provide
// own way of ditsoing it.
	}

}

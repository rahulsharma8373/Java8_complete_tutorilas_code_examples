package com.java8.interview;

public class FindMidElementArray {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5 };
		if (nums.length % 2 == 0) {
			System.out.println("The middle Element are:");
			int x = nums[(nums.length / 2) - 1];
			System.out.println(x);
			int y = nums[(nums.length / 2)];
			System.out.println(y);
		} else {
			int z = nums[(nums.length / 2)];
			System.out.println("The middle Elment is : " + z);
		}
	}

}

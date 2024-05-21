package com.java8.interview;

public class SortArrayCustomLogic {

	public static void main(String[] args) {
		int arr[] = { 3, 0, 2, 6, 1, 7, 9 };

		int len = arr.length;
		int temp = 0;
		System.out.println("before sorting");
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i] + " ");
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("After sorting");
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

package com.java8.interview;

public class RemoveDuplicateFromArray {
	public static int removeDup(int arr[], int n) {
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j++] = arr[i];

			}
		}
		arr[j++] = arr[n - 1];
		return j;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 10, 20, 20, 30, 40, 40, 45, 65 };
		int length = arr.length;
		length = removeDup(arr, length);
		for (int i = 0; i < length; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}

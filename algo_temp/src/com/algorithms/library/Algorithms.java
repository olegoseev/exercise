package com.algorithms.library;

public class Algorithms {

	public static int binarySearchIterative(int[] arr, int value) {
		
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high)/2;
			if (arr[mid] ==  value) {
				return mid;
			}
			if (arr[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static int binarySearchRecursive(int[] arr, int min, int max, int value) {

		if (min <= max ) {
			int mid = (min + max)/2;
			if (arr[mid] == value) {
				return mid;
			}
			if (arr[mid] < value ) {
				return binarySearchRecursive (arr, mid + 1, max, value);
			}
			return binarySearchRecursive (arr, min, mid - 1, value);			
		}
		
		return -1;
	}
	
	// find fibonacci for given sequency number
	// using iterative method
	public static int fibonacciIterative(int n) {
		if (n == 0 || n == 1) return n;
		
		int first = 0;
		int second = 1;
		int next = first + second;
		
		for (int i = 2; i < n; i++) {
			first = second;
			second = next;
			next = first + second;
		}
		return next;
	}
	
	public static int fibonacciRecursive(int n) {
		return n <= 1 ? n : fibonacciRecursive(n-1)+ fibonacciRecursive(n-2); 
	}
	
}

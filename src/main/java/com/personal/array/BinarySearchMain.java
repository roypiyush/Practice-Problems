package com.personal.array;

public class BinarySearchMain {

	/**
	 * 
	 * Basic algorithm for binary search
	 * 
	 * @param arr
	 * @param min
	 * @param max
	 * @param key
	 * @return index if element exists otherwise -1
	 */
	int binarySearch(int arr[], int min, int max, int key) {

		if (max < min)
			return -1;

		int mid = (min + max) >> 1;

		if (key < arr[mid]) {
			return binarySearch(arr, min, mid - 1, key);
		} else if (key > arr[mid]) {
			return binarySearch(arr, mid + 1, max, key);
		} else
			return mid;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20 };

		BinarySearchMain main = new BinarySearchMain();
		
		int index = 0;
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 10)) != -1 ? "Element found at " + index : "Element not Found!");
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 100)) != -1 ? "Element found at " + index : "Element not Found!");
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 0)) != -1 ? "Element found at " + index : "Element not Found!");
	}

}

package com.personal.array;

import java.util.Arrays;

public class BinarySearchMain {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16,
                17, 18, 19, 20};

        BinarySearchMain main = new BinarySearchMain();
        System.out.println(Arrays.toString(arr));
        int index;

        System.out.println("####################################################");
        System.out.println("Running recursive binary search");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 10)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 100)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 0)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 1)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 20)) != -1 ? "Element found at " + index : "Element not Found!");

        System.out.println("Running iterative binary search");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 10)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 100)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 0)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 1)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println((index = main.binarySearchRecursive(arr, 0, arr.length - 1, 20)) != -1 ? "Element found at " + index : "Element not Found!");
        System.out.println("####################################################");


        int upperBound = 5;
        index = main.upperBound(arr, upperBound);
        System.out.println(String.format("Upper bound found for key:%d at index:%d element:%d", upperBound, index, arr[index]));

        int lowerBound = 5;
        index = main.lowerBound(arr, lowerBound);
        System.out.println(String.format("Lower bound found for key:%d at index:%d element:%d", lowerBound, index, arr[index]));


        lowerBound = -1;
        index = main.lowerBound(arr, lowerBound);
        System.out.println(String.format("Lower bound found for key [which does not exist]:%d at index:%d element:%d", lowerBound, index, arr[index]));

        lowerBound = 100;
        index = main.lowerBound(arr, lowerBound);
        System.out.println(String.format("Lower bound found for key [which does not exist]:%d at index:%d element:%d", lowerBound, index, arr[index]));
    }

    /**
     * Basic recursive algorithm for binary search
     *
     * @param arr
     * @param min
     * @param max
     * @param key
     * @return
     */
    int binarySearchRecursive(int arr[], int min, int max, int key) {

        if (max < min)
            return -1;

        int mid = (min + max) >> 1;

        if (key < arr[mid])
            return binarySearchRecursive(arr, min, mid - 1, key);
        else if (key > arr[mid])
            return binarySearchRecursive(arr, mid + 1, max, key);
        else
            return mid;

    }

    /**
     * Basic iterative algorithm for binary search
     *
     * @param arr
     * @param key
     * @return index if element exists otherwise -1
     */
    int binarySearchIterative(int arr[], int key) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (key < arr[mid])
                max = mid - 1;
            else if (key > arr[mid])
                min = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Minimum index which is greater than key
     *
     * @param arr
     * @param key
     * @return
     */
    int upperBound(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) >> 1;

            if (key < arr[mid] && (mid == 0 || arr[mid - 1] <= key)) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mid;
    }

    /**
     * Maximum index which is lesser than or equal to key
     *
     * @param arr
     * @param key
     * @return
     */
    int lowerBound(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) >> 1;

            if (key <= arr[mid] && (mid == 0 || arr[mid - 1] < key)) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mid;
    }
}

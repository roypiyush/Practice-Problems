package com.personal.array;

/**
 * Find duplicates in O(n) time and O(1) extra space
 *
 * @author proy1
 */
public class FindDuplicatesInArrayM1 {

    static void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are: ");
        for (i = 0; i < size; i++) {
            int a = arr[i] % size;
            if (arr[Math.abs(a)] >= 0)
                arr[Math.abs(a)] = -arr[Math.abs(a)];
            else
                System.out.printf("Duplicate %d at %d\n", Math.abs(arr[i]), i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {41, 2, 41, 5, 2, 41, 31, 13};
        int arr_size = arr.length;
        printRepeating(arr, arr_size);

    }

}

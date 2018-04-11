/**
 *
 */
package com.personal.array;

/**
 * @author piyush
 */
public class SortedOrderPritingArray {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 1, 3};
        new SortedOrderPritingArray().arrayInorder(arr, arr.length, 0);

    }

    public void arrayInorder(int[] arr, int size, int cur) {

        if (cur < size) {
            arrayInorder(arr, size, 2 * cur + 1);
            System.out.print(arr[cur] + " ");
            arrayInorder(arr, size, 2 * cur + 2);
        }
    }

}

/**
 *
 */
package com.personal.dynamicprogramming;

/**
 * @author piyush
 */
public class MatrixChainMultiplication {


    private static int minimumOperation(int[] arr, int i, int j) {

        if (i == j || i > j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, minimumOperation(arr, i, k) + minimumOperation(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j]);
        }

        return min;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(minimumOperation(arr, 1, arr.length - 1)); // 26000

        int[] arr1 = {10, 20, 30, 40, 30};
        System.out.println(minimumOperation(arr1, 1, arr1.length - 1)); // 30000

        int[] arr2 = {10, 20, 30};
        System.out.println(minimumOperation(arr2, 1, arr2.length - 1)); // 6000

        int[] arr3 = {10, 30, 5, 60};
        System.out.println(minimumOperation(arr3, 1, arr3.length - 1)); // 4500

    }

}

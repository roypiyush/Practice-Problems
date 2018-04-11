/**
 *
 */
package com.personal.array;

/**
 * @author piyush
 */
public class MaxMinArray {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int size = 1000000;
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        long time = System.currentTimeMillis();
        efficientMethod(arr.clone());
        System.out.println("\nTime required for efficientMethod() " + (System.currentTimeMillis() - time) + "ms");

    }

    private static void efficientMethod(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {

            int x = arr[i];
            int nextPos = 0;

            while (x > 0) {
                if (i < (size / 2)) {
                    nextPos = 2 * i + 1;
                } else {
                    nextPos = 2 * (size - 1 - i);
                }

                if (x < 0 || i == nextPos) break;

                int temp = arr[nextPos];
                arr[nextPos] = x;
                arr[nextPos] = -arr[nextPos];
                x = temp;
                i = nextPos;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(Math.abs(arr[i]) + " ");
        }
    }

}

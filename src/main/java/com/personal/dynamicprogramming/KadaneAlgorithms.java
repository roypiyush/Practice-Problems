/**
 *
 */
package com.personal.dynamicprogramming;

/**
 * @author piyush
 */
public class KadaneAlgorithms {

    public static void maxSumContiguous() {

        int[] arr = {8, -17, 6, 4, -5, 2, -1, 3, 8, -9};
        int maxEnding = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {

            maxEnding = Math.max(arr[i], maxEnding + arr[i]);

            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        System.out.println(maxSoFar);
    }

    public static void maxSumNonContiguous() {
        int[] arr = {8, -17, 6, 4, -5, 2, -1, 3, 8, -9};
        int maxEnding = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {

            maxEnding = Math.max(maxEnding, maxEnding + arr[i]);

            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        System.out.println(maxSoFar);
    }

    public static void maxContinuosIncreasing() {
        int[] arr = {8, -17, 6, 4, -5, 2, -1, 3, 8, -9};

        int s = 0, e = 0, ms = 0, me = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                e = i;
                if ((e - s + 1) > (ms - me + 1)) {
                    ms = s;
                    me = e;
                }
            } else {
                s = i;
                e = i;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "=" + arr[i] + " ");
        }
        System.out.println(String.format("Max increasing contiguous sub array from %d to %d of Length %d", ms, me, me - ms + 1));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        maxSumContiguous();
        maxSumNonContiguous();
        maxContinuosIncreasing();
    }

}

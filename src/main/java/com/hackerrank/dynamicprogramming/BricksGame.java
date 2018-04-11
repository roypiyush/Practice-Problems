/**
 *
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 */
public class BricksGame {

    private static int points(int[] arr, int startIndex, boolean f, int val1, int val2) {

        if (startIndex >= arr.length)
            return 0;

        int max = 0;
        int sum = 0;
        for (int j = 0; j < arr.length && j < 3; j++) {
            if (startIndex + j < arr.length) {
                sum = sum + arr[startIndex + j];
                max = Math.max(max, sum + points(arr, startIndex + j + 1, !f, f == true ? val1 + sum : val1, f == false ? val2 + sum : val2));
            }
        }

        if (f == false)
            return 0;

        return max;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int t = s.nextInt();

            while (t-- > 0) {
                int size = s.nextInt();
                int[] arr = new int[size];
                for (int i = 0; i < size; i++)
                    arr[i] = s.nextInt();


                int max = 0;
                int sum = 0;
                for (int j = 0; j < arr.length && j < 3; j++) {
                    if (j < arr.length) {
                        sum = sum + arr[j];
                        max = Math.max(max, sum + points(arr, j + 1, false, sum, 0));
                    }
                }
                System.out.println(max);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

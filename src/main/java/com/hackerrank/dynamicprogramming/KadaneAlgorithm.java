/**
 *
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 */
public class KadaneAlgorithm {

	/*
	 * ======================== 
	 *  6
		1	
		1
		6
		-1 -2 -3 -4 -5 -6
		2
		1 -2
		3
		1 2 3
		1
		-10
		6
		1 -1 -1 -1 -1 5
	 * ========================
	 * 
	 * 
	 */

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int T = scanner.nextInt();

            for (int z = 0; z < T; z++) {
                int size = scanner.nextInt();
                int[] arr = new int[size];
                arr[0] = scanner.nextInt();
                int sum1 = arr[0];
                int maxSum1 = arr[0];

                int sum2 = arr[0];
                int maxSum2 = arr[0];

                for (int i = 1; i < arr.length; i++) {
                    arr[i] = scanner.nextInt();

                    // contiguous
                    sum1 = Math.max(arr[i], arr[i] + sum1);
                    maxSum1 = Math.max(maxSum1, sum1);

                    // non contiguous
                    sum2 = Math.max(arr[i] + sum2, Math.max(arr[i], sum2));
                    maxSum2 = Math.max(maxSum2, sum2);

                }

                System.out.println("" + maxSum1 + " " + maxSum2);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

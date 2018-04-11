/**
 *
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 */
public class StockMaximize {


    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int t = s.nextInt();

            while (t-- > 0) {
                int size = s.nextInt();
                int[] arr = new int[size];
                for (int i = 0; i < size; i++)
                    arr[i] = s.nextInt();

                int maxFuture = 0;
                int profit = 0;
                for (int i = size - 1; i >= 0; i--) {
                    maxFuture = Math.max(maxFuture, arr[i]);
                    profit += (long) (maxFuture - arr[i]);
                }

                System.out.println(profit);
            }


        } catch (Exception e) {
        }

    }

}

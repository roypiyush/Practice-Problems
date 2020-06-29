/**
 *
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 */
public class Candies {

    private static void solve(int[] rating, int[] res, int i, int j) {

        if (i > j)
            return;
        if (i == j) {
            res[i] = 1;
            return;
        }

        int mid = (i + j) >> 1;
        solve(rating, res, i, mid);
        solve(rating, res, mid + 1, j);

        if (rating[mid] > rating[mid + 1]) {
            res[mid] = res[mid] + 1;
        }
        if (rating[mid] < rating[mid + 1]) {
            res[mid + 1] = res[mid + 1] + 1;
        }
        if (rating[mid] == rating[mid + 1]) {

        }


    }

    public static void main(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int arraySize = scanner.nextInt();
            int[] rating = new int[arraySize];
            for (int i = 0; i < rating.length; i++) {
                rating[i] = scanner.nextInt();
            }

            int[] res = new int[rating.length];
            solve(rating, res, 0, rating.length - 1);
            int sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum += res[i];
            }
            System.out.println(sum);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}

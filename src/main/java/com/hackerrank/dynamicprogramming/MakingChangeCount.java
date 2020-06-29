/**
 *
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 */
public class MakingChangeCount {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int sum = scanner.nextInt();
            int arraySize = scanner.nextInt();
            int[] denominations = new int[arraySize];
            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = scanner.nextInt();
            }

            System.out.println(countMaxPossibleChange(sum, denominations));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    private static long countMaxPossibleChange(int sum, int[] denominations) {
        long[][] result = new long[sum + 1][denominations.length + 1];

        long internalCountMaxPossibleChange = internalCountMaxPossibleChange(sum, denominations, result, denominations.length);

        return internalCountMaxPossibleChange;
    }

    private static long internalCountMaxPossibleChange(int sum, int[] denominations, long[][] result, int index) {


        if (sum < 0 || index <= 0)
            return 0;
        if (sum == 0)
            return 1;

        if (result[sum][index] > 0)
            return result[sum][index];

        long x = internalCountMaxPossibleChange(sum, denominations, result, index - 1);
        long y = internalCountMaxPossibleChange(sum - denominations[index - 1], denominations, result, index);

        long res = x + y;
        result[sum][index] = res;
        return result[sum][index];
    }

}

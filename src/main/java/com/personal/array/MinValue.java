/**
 *
 */
package com.personal.array;

import java.util.Arrays;

/**
 * @author piyush
 */
public class MinValue {

    /**
     * NOT SOLVED
     */
    static int[] findMinAbsSum(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;

        int[] min = new int[3];

        int mn = Integer.MAX_VALUE;

        while (i < a.length && j < b.length && k < c.length) {
            int sm = Math.abs(a[i] - b[j]) + Math.abs(b[j] - c[k]) + Math.abs(c[k] - a[i]);
            if (sm < mn) {
                mn = sm;
                min[0] = a[i];
                min[1] = b[j];
                min[2] = c[k];
            }

            int idx = i;
            int local_mn = a[idx];
            if (local_mn > b[j]) {
                local_mn = b[j];
                idx = j;
            }
            if (local_mn > c[k]) {
                idx = k;
            }
            idx++;
        }

        return min;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = {90, 83, 16, 28, 45, 35, 63, 71, 3};
        int[] b = {95, 88, 19, 26, 48, 37, 69, 72, 1};
        int[] c = {91, 85, 15, 29, 43, 33, 66, 74, 2};

        int[] min = findMinAbsSum(a, b, c);

        for (int i = 0; i < 3; ++i) {
            System.out.print(min[i]);
        }

    }

}

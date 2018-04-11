/**
 *
 */
package com.personal.array;

import java.util.Arrays;

/**
 * @author piyush
 */
public class MergeSortedArray {


    static void merge(int[] a1, int[] a2) {

        for (int i = 0; i < a1.length; i++) {

            int j = 0;
            if (a1[i] > a2[j]) {

                int t = a1[i];
                a1[i] = a2[j];
                a2[j] = t;

                while (j + 1 < a2.length && t >= a2[j + 1]) {
                    a2[j] = a2[j + 1];
                    j++;
                }
                a2[j] = t;
            }

        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a1[] = {1, 5, 9, 10, 15, 20};
        int a2[] = {2, 3, 8, 13};
        merge(a1, a2);
        System.out.println(Arrays.toString(a1) + Arrays.toString(a2));
    }

}

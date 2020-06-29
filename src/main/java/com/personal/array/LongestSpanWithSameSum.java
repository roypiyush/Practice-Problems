/**
 *
 */
package com.personal.array;

/**
 * @author piyush
 */
public class LongestSpanWithSameSum {


    @SuppressWarnings("unused")
    static void span(int[] a1, int[] a2) {

        /**
         * NOT SOLVED
         */
        int cs = 0, ce = 0, ms = 0, me = 0;
        int maxsum = 0, maxEnding1 = 0, maxEnding2 = 0;
        for (int i = 0; i < a2.length; i++) {

            maxEnding1 += a1[i];
            maxEnding2 += a2[i];

            if (maxEnding1 != maxEnding2) {
                cs = i;
                ce = i;
            } else if (maxEnding1 == maxEnding2) {
                ce = i;

                if (maxEnding1 > maxsum) {
                    ms = cs;
                    me = ce;
                }
            }


        }

    }

    /**
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int arr1[] = {0, 1, 0, 0, 0, 0};
        int arr2[] = {1, 0, 1, 0, 0, 1};
    }

}

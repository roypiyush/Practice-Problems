/**
 *
 */
package com.personal.dynamicprogramming;

import com.personal.dynamicprogramming.lcs.MatrixPrint;

/**
 * @author piyush
 */
public class LongestCommonSubsequence {

    public static int[][] lcs(String s1, String s2) {

        int size1 = s1.length();
        int size2 = s2.length();

        int[][] arr = new int[size1 + 1][size2 + 1];

        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr;
    }

    public static int[][] editDistance(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();

        int[][] arr = new int[size1 + 1][size2 + 1];

        for (int i = 0; i <= size1; i++) {
            arr[i][0] = i;
        }

        for (int j = 0; j <= size2; j++) {
            arr[0][j] = j;
        }

        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = 1 + Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1]));
                }
            }
        }


        return arr;
    }

    public static String getSequence(int arr[][], String x, int i, int j) {

        if (i == 0 || j == 0)
            return "";

        if (arr[i][j - 1] == arr[i][j]) {
            return getSequence(arr, x, i, j - 1);
        } else if (arr[i - 1][j] == arr[i][j]) {
            return getSequence(arr, x, i - 1, j);
        } else {
            return getSequence(arr, x, i - 1, j - 1) + "" + x.charAt(i - 1);
        }

    }

    public static String getSequenceReverse(int arr[][], String x, int i, int j) {

        if (i == 0 || j == 0)
            return "";

        if (arr[i][j - 1] == arr[i][j]) {
            return getSequence(arr, x, i, j - 1);
        } else if (arr[i - 1][j] == arr[i][j]) {
            return getSequence(arr, x, i - 1, j);
        } else {
            return x.charAt(i - 1) + getSequence(arr, x, i - 1, j - 1);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        String X = "APBCADCQER";
        String Y = "RASBTAUCVE";

        String p = "BBABCBCAB";

        // LCS = ABACE
        int[][] lcs = lcs(X, Y);
        System.out.println("Sequence is " + getSequence(lcs, X, X.length(), Y.length()));
        System.out.println("Reverse Sequence is " + getSequenceReverse(lcs, X, X.length(), Y.length()));
        System.out.println("Size of lcs = " + lcs[X.length()][Y.length()]);

        MatrixPrint.print(lcs);

        int[][] palindrome = lcs(X, new StringBuilder(X).reverse().toString());
        System.out.println("Palindrome Sequence is " + getSequence(palindrome, X, X.length(), X.length()));

        int[][] palindrome1 = lcs(p, new StringBuilder(p).reverse().toString());
        System.out.println("Palindrome Sequence is " + getSequence(palindrome1, p, p.length(), p.length()) + " Length : " + palindrome1[p.length()][p.length()]);

        // Edit distance =
        int[][] editDistance = editDistance(X, Y);
        System.out.println("Edit distance = " + editDistance[X.length()][Y.length()]);

        String source = "park";
        String destination = "spayrk";

        int[][] editDistance1 = editDistance(source, destination);
        System.out.println("Edit distance = " + editDistance1[source.length()][destination.length()]);

    }

}

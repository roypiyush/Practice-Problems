package com.hackerrank.dynamicprogramming;

import java.util.Scanner;


public class PlayWithWords {

    public static void main(String[] args) {

        PlayWithWords playWithWords = new PlayWithWords();

        Scanner sc = null;
        try {

            sc = new Scanner(System.in);

            String word = sc.nextLine();

            int maxProduct = 1;
            for (int i = 1; i <= word.length() - 1; i++) {
                String s1 = word.substring(0, i);
                String s2 = word.substring(i, word.length());

                int[][] lcs1 = playWithWords.lcs(s1);
                int[][] lcs2 = playWithWords.lcs(s2);

                maxProduct = Math.max(maxProduct, lcs1[s1.length()][s1.length()] * lcs2[s2.length()][s2.length()]);
            }
            System.out.println(maxProduct);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
        }

    }

    public int[][] lcs(String string) {
        /**
         * Initialization
         */
        int m = string.length();
        String reverseString = new StringBuilder(string).reverse().toString();
        int[][] LCS = new int[m + 1][m + 1];


        /***************/

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {

                if (string.charAt(i - 1) == reverseString.charAt(j - 1)) {
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        return LCS;

    }

}

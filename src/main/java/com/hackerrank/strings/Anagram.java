package com.hackerrank.strings;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int T = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < T; i++) {
                String str = scanner.nextLine();
                System.out.println(getAnagramLength(str));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

    private static int getAnagramLength(String str) {

        int length = str.length();
        if (length % 2 == 1)
            return -1;


        int mid = length / 2;
        int c1[] = new int[26];
        int c2[] = new int[26];

        for (int i = 0; i < mid; i++) {
            int pos = (int) str.charAt(i) - 97;
            c1[pos] += 1;
        }

        // elements will be more in case of odd length
        for (int i = mid; i < length; i++) {
            int pos = (int) str.charAt(i) - 97;
            c2[pos] += 1;
        }

        int diff = 0;

        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                diff += Math.abs(c1[i] - c2[i]);
            }
        }

        return diff >> 1;
    }

}

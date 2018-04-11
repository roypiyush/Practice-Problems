package com.hackerrank.strings;

import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int T = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < T; i++) {
                String str = scanner.nextLine();
                System.out.println(getPalindromeIndex(str));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

    private static int getPalindromeIndex(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
            } else {

                int k1 = i + 1;
                int k2 = j;
                // Check if we can find palindrome
                boolean f1 = true;
                while (k1 <= k2) {
                    if (str.charAt(k1) == str.charAt(k2)) {
                        f1 = f1 && true;
                    } else {
                        f1 = f1 && false;
                    }
                    k1++;
                    k2--;
                }

                if (f1)
                    return i;

                k1 = i;
                k2 = j - 1;
                boolean f2 = true;
                while (k1 <= k2) {
                    if (str.charAt(k1) == str.charAt(k2)) {
                        f2 = f2 && true;
                    } else {
                        f2 = f2 && false;
                    }
                    k1++;
                    k2--;
                }
                if (f2)
                    return j;
            }
            i++;
            j--;
        }
        return -1;
    }

}

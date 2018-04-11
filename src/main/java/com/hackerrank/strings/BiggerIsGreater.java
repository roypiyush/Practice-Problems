package com.hackerrank.strings;

import java.util.Scanner;

public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            int t = scanner.nextInt();
            scanner.nextLine();

            while (t-- > 0) {
                StringBuilder word = new StringBuilder(scanner.nextLine());

                System.out.println(nextPermutation(word) ? word.toString() : "no answer");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }


    }

    public static boolean nextPermutation(StringBuilder word) {
        //Step 1
        int a = word.length() - 2;
        while (a >= 0 && word.charAt(a) >= word.charAt(a + 1)) {
            a--;
        }
        if (a == -1) {
            return false;
        }

        //Step 2
        int b = word.length() - 1;
        while (word.charAt(b) <= word.charAt(a)) {
            b--;
        }

        //Step 3
        char t1 = word.charAt(a);
        char t2 = word.charAt(b);

        word.setCharAt(a, t2);
        word.setCharAt(b, t1);

        //Step 4
        for (int i = a + 1, j = word.length() - 1; i < j; i++, j--) {

            char x1 = word.charAt(i);
            char x2 = word.charAt(j);

            word.setCharAt(i, x2);
            word.setCharAt(j, x1);
        }
        return true;
    }
}

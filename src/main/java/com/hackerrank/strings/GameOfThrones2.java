package com.hackerrank.strings;

import java.math.BigInteger;
import java.util.Scanner;

public class GameOfThrones2 {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            StringBuilder word = new StringBuilder(scanner.nextLine());

            int size = word.length();
            int chars[] = new int[26];

            for (int i = 0; i < size; i++) {
                int c = word.charAt(i) - 97;
                chars[c] = chars[c] + 1;
            }

            int sum = 0;
            BigInteger mul = new BigInteger("1");
            for (int i = 0; i < 26; i++) {
                if (chars[i] > 0) {
                    int j = chars[i] >> 1;
                    sum += j;
                    mul = mul.multiply(factorial(j));
                }
            }

            BigInteger b1 = factorial(sum);

            System.out.println(b1.divide(mul).mod(new BigInteger("1000000007")));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

    static BigInteger factorial(int l) {
        if (l == 0)
            return new BigInteger("1");

        BigInteger bigInteger = new BigInteger(Integer.toString(l));
        l--;
        while (l > 0) {
            bigInteger = bigInteger.multiply(new BigInteger(Integer.toString(l)));
            l--;
        }
        return bigInteger;
    }

}

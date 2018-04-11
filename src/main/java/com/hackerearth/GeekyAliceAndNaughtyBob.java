package com.hackerearth;

import java.math.BigInteger;
import java.util.Scanner;

public class GeekyAliceAndNaughtyBob {

    public static void main(String[] args) {
        GeekyAliceAndNaughtyBob bob = new GeekyAliceAndNaughtyBob();

        Scanner sc = null;
        try {

            sc = new Scanner(System.in);
            int T = sc.nextInt();

            while (T-- > 0) {

                int A = sc.nextInt();
                int B = sc.nextInt();

                BigInteger factorial = bob.factorial(A);

                BigInteger result = new BigInteger(bob.rSum(factorial));
                for (int i = A + 1; i <= B; i++) {
                    factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
                    String rSum = bob.rSum(factorial);

                    result = result.add(new BigInteger(rSum));
                }
                System.out.println(result.toString());

            }

        } catch (Exception e) {
        } finally {
            if (sc != null) sc.close();
        }

    }

    String rSum(BigInteger i) {
        String numString = i.toString();
        return rSumInternal(numString);
    }

    String rSumInternal(String num) {
        int size = num.length();
        if (size == 1)
            return num;

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return Integer.toString(sum);
    }

    public BigInteger factorial(int n) {

        if (n == 0)
            return new BigInteger("0");

        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        return fact;
    }

}

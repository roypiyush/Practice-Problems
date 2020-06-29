package com.utility;

public class Factorial {

    public static long getFactorial(long number) {
        long factorial = 1;

        for (long i = 1; i <= number; i++) {
            factorial = i * factorial;
        }
        return factorial;
    }

    public static void main(String[] args) {

        System.out.println(getFactorial(15));
    }

}

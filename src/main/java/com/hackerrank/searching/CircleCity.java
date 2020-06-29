package com.hackerrank.searching;

import java.math.BigDecimal;
import java.util.Scanner;

public class CircleCity {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int T = scanner.nextInt();

            for (int i = 0; i < T; i++) {
                int r = scanner.nextInt();
                int k = scanner.nextInt();
                System.out.println(isProtected(r, k) ? "possible" : "impossible");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

    private static boolean isProtected(int r, int k) {

        // x^2 + y^2 = r^2
        int count = 0;
        for (int x = 0; x <= r; x++) {
            if (isSquare(r, x)) {
                count += 2;
            }
        }
        return count == k;
    }

    private static boolean isSquare(int r, int x) {
        BigDecimal bys = new BigDecimal(r * r - x * x);
        double y = Math.sqrt(bys.doubleValue());
        return (int) y * y + x * x == r * r;
    }
}

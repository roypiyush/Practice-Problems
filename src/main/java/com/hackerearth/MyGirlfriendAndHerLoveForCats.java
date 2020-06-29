package com.hackerearth;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyGirlfriendAndHerLoveForCats {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(new BufferedInputStream(System.in));

            int n = sc.nextInt();

            ArrayList<Integer> s = new ArrayList<Integer>();
            ArrayList<Integer> c = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                s.add(sc.nextInt());
            }

            for (int i = 0; i < n; i++) {
                c.add(sc.nextInt());
            }

            Collections.sort(s);
            Collections.sort(c);

            long maxSum = 0;
            for (int i = 0; i < n; i++) {
                long v1 = s.get(i);
                long v2 = c.get(i);
                long d = v1 * v2;
                maxSum = maxSum + d;
            }

            System.out.println(maxSum);

        } catch (Exception e) {
            System.out.println(String.format("Error due to %s", e.getMessage()));
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

}

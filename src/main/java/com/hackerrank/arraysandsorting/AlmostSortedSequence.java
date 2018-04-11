package com.hackerrank.arraysandsorting;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AlmostSortedSequence {

    static int getCount(int num) {
        if (num == 1)
            return 1;
        return (num * (num - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int N = Integer.parseInt(scanner.nextLine());

            int[] a = new int[N];
            int[] b = new int[N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                a[i] = scanner.nextInt();

                if (i == 0) {
                    b[i] = 1;
                } else if (a[i] > max) {
                    b[i] = b[i - 1] + 1;
                } else if (a[i] <= max) {

                    b[i] = 1;
                }
                max = a[i];
            }

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                Integer integer = hashMap.get(b[i]);
                hashMap.put(b[i], integer == null ? 1 : integer + 1);
            }

            int count = 0;
            for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();

                if (key == 1)
                    count += val;
                else {
                    count += (getCount(key) * val);
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

}

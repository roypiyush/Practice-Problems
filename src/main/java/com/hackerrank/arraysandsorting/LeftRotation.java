package com.hackerrank.arraysandsorting;

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = (in.nextInt()) % n;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[(i + d) % n] + " ");
        }

        in.close();
    }

}

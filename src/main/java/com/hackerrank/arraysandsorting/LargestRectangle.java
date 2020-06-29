package com.hackerrank.arraysandsorting;

import java.util.LinkedList;
import java.util.Scanner;

public class LargestRectangle {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] height = new int[N + 1];

        for (int i = 0; i < N; i++) {
            height[i] = s.nextInt();
        }

        LinkedList<Integer> position = new LinkedList<>();
        int maxArea = 0;
        int i = 0;
        while (i < height.length) {

            if (position.isEmpty() || height[i] > height[position.peek()]) {
                position.push(i);
                i++;
            } else {

                int t = position.peek();
                position.pop();
                maxArea = Math.max(maxArea, height[t] * (position.isEmpty() ? i : (i - position.peek() - 1)));
            }
        }
        System.out.println(maxArea);
        s.close();
    }
}
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class PlayGame {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int T = scanner.nextInt();

            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] stack = new int[N];
                for (int j = 0; j < N; j++) {
                    stack[j] = scanner.nextInt();
                }
                System.out.println(playGame(stack));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    private static long playGame(int[] stack) {
        long result = makeMove(stack, 0, true);
        return result;
    }

    private static long makeMove(int[] stack, int currentIndex, boolean whosMove) {
        long myResult = 0;

        if (currentIndex == stack.length)
            return myResult;

        int it = Math.min(3, stack.length - currentIndex);
        for (int i = 0; i < it; i++) {

            if (whosMove) {
                int takenPoint = 0;
                for (int j = 0; j <= i; j++) {
                    takenPoint += stack[currentIndex + j];
                }
                long makeMove = takenPoint + makeMove(stack, currentIndex + i + 1, !whosMove);
                myResult = Math.max(myResult, makeMove);
            } else
                makeMove(stack, currentIndex + i + 1, !whosMove);
        }

        return myResult;
    }

}

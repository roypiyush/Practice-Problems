package com.topcoder.bruteforce;

public class TheSquareRootDilemma {

    public static void main(String[] args) {

        int N = 77777;
        int M = 77777;

        long start = System.currentTimeMillis();
        System.out.println(new TheSquareRootDilemma().countPairs(N, M));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    int countPairs(int N, int M) {
        int count = 0;

        for (int i = 1; i <= M; i++) {

            for (int j = 1; j <= N; j++) {
                double value = 2 * Math.sqrt(i * j);
                if (Math.floor(value) == value) {
                    count++;
                }
            }

        }
        return count;
    }

}

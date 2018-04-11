/**
 *
 */
package com.personal.math;

/**
 * @author piyush
 */
public class BinomialCofficient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution(310, 300));
    }

    public static int solution(int N, int K) {

        if (N < K)
            return -1;
        if (N == K)
            return 1;

        int max = Math.max(N - K, K);
        int min = Math.min(N - K, K);

        int C = Math.max(N - max, min);
        double ans = 1;

        double a = N;
        double b = min;
        for (int i = 0; i < C; i++) {

            ans = ans * a / b;
            if (a - 1 > max)
                a = a - 1;
            else
                a = 1;
            if (b - 1 >= 1)
                b = b - 1;
        }

        if (ans >= 1000000000)
            return -1;


        return (int) ans;
    }

}

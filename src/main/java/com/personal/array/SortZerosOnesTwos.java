package com.personal.array;

public class SortZerosOnesTwos {

    static void swap(int i, int j, int A[]) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        int A[] = {1, 0, 2, 0, 1, 2, 0, 1};

        int x = 0;
        int p0 = x - 1;
        int p2 = A.length;

        while (x > p0 && x < p2) {

            if (A[x] == 1) {
                x++;
                continue;
            }

            if (A[x] == 0) {
                p0 = p0 + 1;
                swap(x, p0, A);
            }

            if (A[x] == 2) {
                p2 = p2 - 1;
                swap(x, p2, A);
            }

        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

}

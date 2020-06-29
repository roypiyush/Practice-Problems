package com.hackerrank.searching;

import java.util.HashSet;
import java.util.Scanner;

public class Triplets {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            HashSet<MyTriplet> myTriplets = new HashSet<>();
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[i] < arr[j] && arr[j] < arr[k]) {
                            myTriplets.add(new MyTriplet(arr[i], arr[j], arr[k]));
                        }
                    }
                }
            }

            System.out.println(myTriplets.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    static class MyTriplet {
        private int i;
        private int j;
        private int k;

        public MyTriplet(int i, int j, int k) {
            super();
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;

            result = prime * result + i;
            result = prime * result + j;
            result = prime * result + k;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MyTriplet other = (MyTriplet) obj;
            if (i != other.i)
                return false;
            if (j != other.j)
                return false;
            if (k != other.k)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "MyTriplet [i=" + i + ", j=" + j + ", k=" + k + "]";
        }
    }

}

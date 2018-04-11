package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TriangularRanges {

    public static void main(String[] args) {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);

            int T = sc.nextInt();

            ArrayList<Long> arrayList = new ArrayList<Long>();

            for (long i = 0, p = 1; i <= 1000000000000L; p++) {
                i += p;
                arrayList.add(i);
            }

            while (T-- > 0) {

                long L = sc.nextLong();
                long R = sc.nextLong();

                int i = 0, j = arrayList.size() - 1;
                long count = 0L;

                while (arrayList.get(i) < R) {

                    int lb = -1;
                    int rb = -1;

                    int start = i;
                    int end = j;
                    int mid = 0;
                    long sum = 0;
                    while (start <= end) {

                        mid = (start + end) >> 1;
                        sum = arrayList.get(mid) + arrayList.get(i);

                        if (start == mid && start == end)
                            break;
                        if (sum < R && (mid + 1 < arrayList.size() && arrayList.get(mid + 1) + arrayList.get(i) > R))
                            break;
                        if (sum < R) {
                            start = mid + 1;
                        } else if (sum > R) {
                            end = mid - 1;
                        } else {
                            break;
                        }

                    }

                    if (L <= sum && sum <= R)
                        rb = mid;

                    start = i;
                    end = rb;
                    while (start <= end) {

                        mid = (start + end) >> 1;
                        sum = arrayList.get(mid) + arrayList.get(i);

                        if (start == mid && start == end)
                            break;
                        if (sum > L && (mid - 1 >= 0 && arrayList.get(mid - 1) + arrayList.get(i) < L))
                            break;
                        if (sum < L) {
                            start = mid + 1;
                        } else if (sum > L) {
                            end = mid - 1;
                        } else {
                            break;
                        }
                    }

                    if (L <= sum && sum <= R)
                        lb = mid;
                    if (lb == -1 || rb == -1) {

                    } else if (rb >= lb)
                        count += (rb - lb + 1);
                    i++;

                }

                System.out.println(count);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (sc != null) {
                sc.close();
            }
        }

    }

}

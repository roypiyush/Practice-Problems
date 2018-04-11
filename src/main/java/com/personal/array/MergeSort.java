package com.personal.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {2, 3, 8, 6, 1};


        int res = inversionMergeSort(a, 0, a.length);
        System.out.println(res);
//        mergeSort(a, 0, a.length);

        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] arr, int i, int j) {
        if (i + 1 < j) {

            int mid = (i + j) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid, j);
            merge(arr, i, mid, j);
        }

    }

    private static void merge(int[] arr, int i, int mid, int j) {
        int l = 0;
        int r = 0;
        int ls = mid - i;
        int rs = j - mid;

        int k = i;

        int[] larr = new int[ls], rarr = new int[rs];

        System.arraycopy(arr, i, larr, 0, larr.length);
        System.arraycopy(arr, mid, rarr, 0, rarr.length);

        while (k < j) {
            if ((l < larr.length && r == rarr.length) ||
                    (l < larr.length && r < rarr.length && larr[l] <= rarr[r])) {
                arr[k++] = larr[l++];
            }
            if ((l == larr.length && r < rarr.length) ||
                    (l < larr.length && r < rarr.length && larr[l] > rarr[r])) {
                arr[k++] = rarr[r++];
            }

        }
    }

    public static int inversionMergeSort(int[] arr, int i, int j) {
        int inv = 0;
        if (i + 1 < j) {

            int mid = (i + j) / 2;
            inv = inversionMergeSort(arr, i, mid);
            inv = +inversionMergeSort(arr, mid, j);
            inv = +inversionMerge(arr, i, mid, j);
        }
        return inv;
    }

    private static int inversionMerge(int[] arr, int i, int mid, int j) {
        int inv = 0;
        int l = 0;
        int r = 0;
        int ls = mid - i;
        int rs = j - mid;

        int k = i;

        int[] larr = new int[ls], rarr = new int[rs];

        System.arraycopy(arr, i, larr, 0, larr.length);
        System.arraycopy(arr, mid, rarr, 0, rarr.length);

        while (k < j) {
            if ((l < larr.length && r == rarr.length) ||
                    (l < larr.length && r < rarr.length && larr[l] <= rarr[r])) {
                arr[k++] = larr[l++];
            }
            if ((l == larr.length && r < rarr.length) ||
                    (l < larr.length && r < rarr.length && larr[l] > rarr[r])) {
                arr[k++] = rarr[r++];
                inv += (mid - l + 1);
            }

        }
        return inv;
    }
}

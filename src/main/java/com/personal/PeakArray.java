/**
 *
 */
package com.personal;

/**
 * @author piyush
 */
public class PeakArray {

    static int findPeak(int a[], int low, int high) {

        if (low >= high) // If low and high are equal then peak is indeterminate
            return -1;


        int mid = (low + high) / 2;

        if (mid == 0 || mid == a.length - 1 || (a[mid - 1] <= a[mid] && a[mid + 1] < a[mid])
                || (a[mid - 1] < a[mid] && a[mid + 1] <= a[mid]))
            return mid;

        if (a[mid - 1] < a[mid]) {
            return findPeak(a, mid + 1, high);
        }

        return findPeak(a, low, mid - 1);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 566, 236, 100, 90, 80};
        int peak = findPeak(A, 0, A.length - 1);
        System.out.println(peak + " " + (peak == -1 ? peak : A[peak]));


    }

}

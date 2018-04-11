/**
 *
 */
package com.personal;

/**
 * @author piyush
 */
public class UnknownArrayLength {

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 28, 30};
        UnknownArrayLength unknownArrayLength = new UnknownArrayLength();
        System.out.println(unknownArrayLength.findElement(A, 0));
        System.out.println(unknownArrayLength.findElement(A, 1));
        System.out.println(unknownArrayLength.findElement(A, 2));
        System.out.println(unknownArrayLength.findElement(A, 5));
        System.out.println(unknownArrayLength.findElement(A, 10));
        System.out.println(unknownArrayLength.findElement(A, 15));
        System.out.println(unknownArrayLength.findElement(A, 28));
        System.out.println(unknownArrayLength.findElement(A, 29)); // Does not exist
        System.out.println(unknownArrayLength.findElement(A, 30));
        System.out.println(unknownArrayLength.findElement(A, 31));
        System.out.println(unknownArrayLength.findElement(A, 123213));

    }

    boolean binarySearch(int[] arr, int start, int end, int key) {

        while (start <= end) {

            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    boolean findElement(int[] arr, int key) {

        int start = 0;
        int end = 0;
        int eend = 1;
        int value = -1;

        try {
            value = arr[start];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        if (value == key)
            return true;

        while (true) {


            // If EEnd not exist
            try {
                value = arr[eend];
            } catch (ArrayIndexOutOfBoundsException e) {

                eend = (end + eend) >> 1;
                if (eend == end) {
                    return false;
                }
                continue;
            }


            // If EEnd exist
            end = eend;

            if (key >= arr[start] && key <= value) {
                // Do binary search
                return binarySearch(arr, start, end, key);
            } else {
                // Exponentially increase upper bound
                eend = 2 * eend;
                start = end;
            }

        }

    }

}

package com.personal.array;

public class InterpolationSearch {

    static int interpolation_search(int arr[], int size, int key) {
        int low = 0;
        int high = size - 1;
        int mid;

        while (arr[high] != arr[low] && key >= arr[low] && key <= arr[high]) {
            mid = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));

            if (arr[mid] < key)
                low = mid + 1;
            else if (key < arr[mid])
                high = mid - 1;
            else
                return mid;
        }

        if (key == arr[low])
            return low;
        else
            return -1;
    }


    public static void main(String... args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int index = interpolation_search(arr, 9, 8);
        System.out.printf("Index position for Item: %d is %d", arr[index], index);

    }
}

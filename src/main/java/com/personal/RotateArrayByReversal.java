package com.personal;

public class RotateArrayByReversal {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int rotateBy = 7;
        new RotateArrayByReversal().rotate(array, rotateBy);
    }
    private void rotate(int[] array, int rotateBy) {
        if (array == null) {
            return;
        }
        int size = array.length;
        if (size == 0 || size == 1) {
            return;
        }
        rotateBy = rotateBy % size;
        reverse(array, 0, rotateBy - 1);
        reverse(array, rotateBy, size - 1);
        reverse(array, 0, size - 1);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    private void reverse(int[] array, int i, int j) {
        while (i < j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
            i++;
            j--;
        }
    }
}

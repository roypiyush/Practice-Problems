package com.topcoder.bruteforce;


public class TaroFriends {

    public static void print(Integer matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%2s ", matrix[i][j]));
            }
            System.out.println();
        }
    }

    private static String getZeroPrefix(int length) {
        String zero = "0";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(zero);
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        int[] array = {7};
        int distance = 1;

        System.out.println(new TaroFriends().getNumber(array, distance));
    }

    private int getNumber(int[] array, int distance) {
        int b = (int) Math.pow(2, array.length);
        int binaryLength = Integer.toBinaryString(b - 1).length();
        int[][] newArray = new int[b - 1][array.length];

        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < b - 1; i++) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < array.length; j++) {
                String binaryString = Integer.toBinaryString(i + 1);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(getZeroPrefix(binaryLength - binaryString.length()) + binaryString);

                int move = Integer.parseInt(Character.toString(stringBuffer.charAt(j)));
                if (move == 0) {
                    // Left
                    newArray[i][j] =
                            array[j] -
                                    distance;
                } else {
                    // Right
                    newArray[i][j] =
                            array[j] +
                                    distance;
                }
                if (newArray[i][j] < min) {
                    min = newArray[i][j];
                }
                if (newArray[i][j] > max) {
                    max = newArray[i][j];
                }
            }

            if (difference > (max - min)) {
                difference = max - min;
            }
        }
        return difference;
    }

}

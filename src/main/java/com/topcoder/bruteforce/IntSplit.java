package com.topcoder.bruteforce;

public class IntSplit {


    @SuppressWarnings("unused")
    private static String getDigits(int source) {

        String intString = Integer.toString(source);

        return intString;
    }


    @SuppressWarnings("unused")
    private static int getSplitResult(String digits, String binary) {

        int sum = 0;

        int i = 0;
        int beginIndex = 0;
        int endIndex = 1;

        while (endIndex < binary.length()) {
            // Set Begin Index
            beginIndex = endIndex - 1;
            // Set endIndex
            for (; i < binary.length(); i++) {
                if (binary.charAt(i) == 0)
                    endIndex = i + 1;
                else
                    break;
            }
            sum = sum
                    + Integer.parseInt(digits.substring(beginIndex, endIndex));
        }

        return -1;
    }

    public static int intSplit(int source, int target) {
        int result = 0;


        return result;
    }

    public static void main(String[] args) {


    }

}

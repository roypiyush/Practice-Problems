/**
 *
 */
package com.topcoder.bruteforce;

/**
 * @author piyush
 */
public class Unique {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Unique unique = new Unique();

        String S = "topcoder";

        System.out.println(unique.removeDuplicates(S));

    }

    public String removeDuplicates(String S) {

        StringBuffer unique = new StringBuffer();

        if (S == null || S.isEmpty())
            return unique.toString();


        int[] letterCount = new int[26];
        for (int i = 0; i < letterCount.length; i++) {
            // Initialize to 0 as we don't know count yet
            letterCount[i] = 0;
        }

        for (int i = 0; i < S.length(); i++) {

            char character = S.charAt(i);

            int intValue = (int) character;

            if (letterCount[intValue - 97] == 0) {
                letterCount[intValue - 97] = 1;
                unique.append(character);
            } else if (letterCount[intValue - 97] > 0) {
                letterCount[intValue - 97] = letterCount[intValue - 97] + 1;
            }
        }

        return unique.toString();
    }

}

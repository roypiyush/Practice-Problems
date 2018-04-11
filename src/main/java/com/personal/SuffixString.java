/**
 *
 */
package com.personal;

/**
 * @author piyush
 */
public class SuffixString {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String s = "ababa";
        int size = s.length();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j <= size; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

}

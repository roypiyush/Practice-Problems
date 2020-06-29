/**
 *
 */
package com.personal.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author piyush
 */
public class MinimumNumberFromSequence {

    /**
     * NOT SOLVED
     */

    /**
     * @param args
     */
    public static void main(String[] args) {

        String s = "DDD";
        int num = 2, l = 0;
        List<Integer> result = new ArrayList<>();

        if (s.charAt(0) == 'I') {
            result.add(1);
            result.add(2);
        } else {
            result.add(2);
            result.add(1);
        }

        int max = 0;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == 'I') {

                num = num + 1;
                result.add(num);
            } else if (s.charAt(i) == 'D') {

                int k = result.size() - 1;
                while (k >= l) {
                    int element = result.get(k) + 1;
                    max = element > max ? element : max;
                    result.set(k, element);
                    k--;
                }
                result.add(num - 1);
            }
            num = max;
        }
        System.out.println(result);


    }


}

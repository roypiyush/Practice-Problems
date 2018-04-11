/**
 *
 */
package com.personal.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author piyush
 */
public class BiValuedProblem {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] A = {5, 4, 4, 5, 0, 12};
        System.out.println(solution(A));
    }


    public static int solution(int[] A) {

        int maxSize = 0;

        Set<Integer> integers = new HashSet<>();

        int i = 0, j = 0;
        for (i = 0; i < A.length; ) {

            for (j = i + 1; j < A.length; j++) {
                if (integers.size() == 2 && (!integers.contains(A[j]) || !integers.contains(A[i]))) {
                    // This is breaking condition
                    maxSize = Math.max(maxSize, j - i);
                    i++;
                    integers.clear();
                    break;
                } else {
                    // Continue
                    integers.add(A[i]);
                    integers.add(A[j]);
                }
            }

            if (j >= A.length) {
                maxSize = Math.max(maxSize, (j > A.length ? A.length : j) - i);
                i++;
                integers.clear();
            }

        }

        return maxSize;
    }
}

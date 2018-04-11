package com.topcoder.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class QuadraticRoots {

    public static HashSet<Integer> findSolution(int a, int b, int c) {

        HashSet<Integer> solution = new HashSet<Integer>(2);

        double s1 = ((double) -b + Math.sqrt((b * b - 4 * a * c))) / (double) (2 * a);

        //System.out.println(s1);

        if (Double.toString(s1).endsWith(".0")) {
            solution.add((int) s1);
        }

        double s2 = ((double) -b - Math.sqrt((b * b - 4 * a * c))) / (double) (2 * a);

        //System.out.println(s2);

        if (Double.toString(s2).endsWith(".0")) {
            solution.add((int) s2);
        }


        return solution;
    }


    public static void main(String[] args) {

        int a[] = {1};
        int b[] = {2, 3};
        int c[] = {2, 1};

        HashSet<Integer> integers = new HashSet<Integer>();

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                for (int k = 0; k < c.length; k++) {
                    integers.addAll(findSolution(a[i], b[j], c[k]));
                }

        Collections.sort(new ArrayList<Integer>(integers));

        System.out.println(integers);

    }

}

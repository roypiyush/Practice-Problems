package com.personal.backtracking;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    private int seqNo = 1;

    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        String string = "1233";
        char[] str = string.toCharArray();

        long start = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        permutation.permute(str, 0, set);
        System.out.println("Time elasped " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(set);

    }

    void permute(char[] str, int i, Set<String> set) {
        if (i == str.length - 1) {
            System.out.print(seqNo++ + " : ");
            set.add(new String(str));
            System.out.println(str);
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str, i, j);
                permute(str, i + 1, set);
                swap(str, i, j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

}

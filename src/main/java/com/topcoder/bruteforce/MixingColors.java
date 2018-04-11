package com.topcoder.bruteforce;

import java.util.Arrays;

public class MixingColors {

    public static void main(String[] args) {

        int[] colors = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(new MixingColors().minColors(colors));
    }

    public int minColors(int[] colors) {
        int count = 0;
        Arrays.sort(colors);
        while (colors[colors.length - 1] != 0) {
            int x = colors[colors.length - 1];
            for (int i = 0; i < colors.length; i++)
                if ((colors[i] ^ x) < colors[i])
                    colors[i] ^= x;
            Arrays.sort(colors);
            count++;
        }
        return count;
    }

}

package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;


class LadderOfOdds {

    static int validPath(int h) {

        if (h == 0)
            return 1;
        else if (h < 1)
            return 0;

//		int k = h % 2 == 0 ? h - 1 : h;

        int count = 0;
        for (int i = 1; h % 2 == 0 ? i < h : i <= h; i = i + 2) {
            int validPath = validPath(h - i);
            count += validPath;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);


            int T = Integer.parseInt(sc.nextLine().trim());

            while (T-- > 0) {

                int height = Integer.parseInt(sc.nextLine().trim());

                System.out.println(validPath(height));

            }


        } catch (Exception e) {
            System.out
                    .println(String.format("Error due to %s", e.getMessage()));
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (sc != null) {
                sc.close();
            }
        }
    }

}

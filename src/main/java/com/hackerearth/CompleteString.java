package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CompleteString {

    public static void main(String args[]) throws Exception {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);


            int T = Integer.parseInt(sc.nextLine().trim());

            while (T-- > 0) {

                String str = sc.nextLine().toLowerCase();

                int[] c = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    char character = str.charAt(i);
                    int intValue = (int) character;
                    c[intValue - 97] = 1;
                }

                int count = 0;
                for (int i = 0; i < 26; i++) {
                    if (c[i] > 0)
                        count++;
                }
                if (count == 26)
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }


        } catch (Exception e) {
            e.printStackTrace();
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

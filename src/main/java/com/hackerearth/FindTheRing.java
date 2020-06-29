package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;


class FindTheRing {

    static void process(String words[]) {

    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);


            int T = Integer.parseInt(sc.nextLine().trim());

            while (T-- > 0) {

                String str[] = sc.nextLine().trim().split(" ");

                int index = Integer.parseInt(str[0]);
                int N = Integer.parseInt(str[1]);


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

package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class AshishAndBinaryMatrix {

    public static void main(String[] args) {
        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);


            int T = sc.nextInt();

            while (T-- > 0) {

                int n = sc.nextInt(); // row
                sc.nextInt(); // col

                String matrix[] = new String[n];
                sc.nextLine().trim();
                HashSet<String> uniqueIntegers = new HashSet<String>();
                for (int i = 0; i < n; i++) {
                    uniqueIntegers.add(sc.nextLine().trim());
                }

                if (uniqueIntegers.size() == matrix.length) {
                    System.out.println("Yes");
                } else
                    System.out.println("No");

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

package com.hackerrank.assorted;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ACMICPCTeam {

    public static void main(String[] args) {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);

            String str[] = sc.nextLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            String matrix[] = new String[n];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = sc.nextLine().trim();
            }

            process(matrix, n, m);

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

    private static void process(String[] matrix, int n, int m) {

        HashMap<Integer, Integer> arrayList = new HashMap<Integer, Integer>();

        int maxTopic = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int topicCount = 0;
                for (int k = 0; k < m; k++) {
                    int a = matrix[i].charAt(k) == '1' ? 1 : 0;
                    int b = matrix[j].charAt(k) == '1' ? 1 : 0;
                    int xor = a | b;
                    topicCount = topicCount + xor;
                }
                maxTopic = Math.max(maxTopic, topicCount);
                arrayList.put(topicCount, arrayList.get(topicCount) == null ? 1 : arrayList.get(topicCount) + 1);
            }
        }

        System.out.println(maxTopic);
        System.out.println(arrayList.get(maxTopic));
    }

}

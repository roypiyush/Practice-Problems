package com.hackerrank.searching;

import java.util.Scanner;

public class GridSearch {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int T = scanner.nextInt();


            while (T-- > 0) {
                int R = scanner.nextInt();
                int C = scanner.nextInt();
                scanner.nextLine();
                String G[] = new String[R];
                for (int i = 0; i < R; i++) {
                    G[i] = scanner.nextLine();
                }
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                scanner.nextLine();
                String P[] = new String[r];
                for (int i = 0; i < r; i++) {
                    P[i] = scanner.nextLine();
                }
                boolean flag = false;
                for (int i = 0; i < G.length; i++) {

                    int index = -1;
                    if ((index = G[i].indexOf(P[0])) >= 0) {

                        flag = true;

                        int k = i + 1;
                        int j = 1;
                        for (; j < P.length; j++, k++) {
                            if (G[k].indexOf(P[j]) == index) {
                                flag = flag & true;
                            } else {
                                flag = flag & false;
                                break;
                            }
                        }
                        if (j != P.length)
                            flag = false;

                    }

                }
                System.out.println(flag ? "YES" : "NO");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

}

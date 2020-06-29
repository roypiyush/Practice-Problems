package com.hackerearth;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GirlfriendRequest {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(new BufferedInputStream(System.in));

            int numberCount = sc.nextInt();

            ArrayList<Integer> numbersToPlay = new ArrayList<Integer>();

            for (int i = 0; i < numberCount; i++) {
                numbersToPlay.add(sc.nextInt());
            }

            int numbersOfQueries = sc.nextInt();

            for (int i = 0; i < numbersOfQueries; i++) {

                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;

                l = Math.min(l, r);
                r = Math.max(l, r);

                ArrayList<Integer> data = new ArrayList<Integer>(
                        numbersToPlay.subList(l, l + (r - l + 1)));
                Collections.sort(data);

                int lengthOfSeq = data.size();
                int mid = 0;
                if (lengthOfSeq % 2 == 0)
                    mid = lengthOfSeq / 2 - 1;
                else
                    mid = lengthOfSeq / 2;
                System.out.println(data.get(mid));
            }

        } catch (Exception e) {
            System.out
                    .println(String.format("Error due to %s", e.getMessage()));
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

}

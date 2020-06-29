package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Algorithm is correct. Should work in cpp
 *
 */
public class Rooms {

    public static void main(String[] args) {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);

            int T = sc.nextInt();
            while (T-- > 0) {
                int numberOfGuests = sc.nextInt();
                int[] arrivalTime = new int[numberOfGuests];
                int[] departureTime = new int[numberOfGuests];

                for (int i = 0; i < numberOfGuests; i++) {
                    arrivalTime[i] = sc.nextInt();
                }
                for (int i = 0; i < numberOfGuests; i++) {
                    int duration = sc.nextInt();
                    departureTime[i] = arrivalTime[i] + duration;
                }

                Arrays.sort(arrivalTime);
                Arrays.sort(departureTime);

                int i = 0, j = 0, count = 0;
                int result = 0;
                while (i < arrivalTime.length) {
                    if (i == 0 && arrivalTime[i] > 0) {
                        count++;
                        i++;
                    } else if (arrivalTime[i] < departureTime[j]) {
                        i++;
                        count++;
                    } else if (departureTime[j] <= arrivalTime[i]) {
                        count--;
                        j++;
                    }
                    result = Math.max(count, result);
                }
                System.out.println(result);

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

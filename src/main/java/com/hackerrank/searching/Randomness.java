package com.hackerrank.searching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Randomness {

    static HashSet<String> getSubStrings(String string) {
        HashSet<String> strings = new HashSet<>();

        int length = string.length();

        for (int c = 0; c < length; c++) {
            for (int i = 1; i <= length - c; i++) {
                String sub = string.substring(c, c + i);
                strings.add(sub);
            }
        }

        return strings;
    }

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int Q = scanner.nextInt();
            scanner.nextLine();
            String string = scanner.nextLine();
            while (Q-- > 0) {
                int P = scanner.nextInt();
                String C = scanner.nextLine().trim();
                P--;
                string = string.substring(0, P) + C + string.substring(P + 1, N);
                Set<String> strings = getSubStrings(string);
                System.out.println(strings.size());

            }

        } catch (Exception e) {
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

}

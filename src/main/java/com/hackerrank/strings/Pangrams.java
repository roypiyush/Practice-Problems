package com.hackerrank.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

    public static void main(String[] args) {

        Set<Character> characters = new HashSet<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String token = scanner.nextLine();
            token = token.toLowerCase();
            for (int i = 0, j = token.length() - 1; i <= j; i++, j--) {

                if (token.charAt(i) != ' ')
                    characters.add(token.charAt(i));

                if (token.charAt(j) != ' ')
                    characters.add(token.charAt(j));
            }


            System.out.println(characters.size() == 26 ? "pangram" : "not pangram");


        } catch (Exception e) {
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

}

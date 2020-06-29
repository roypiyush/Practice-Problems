package com.coding.search_contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SearchContactMain {

    public static void main(String[] args) throws IOException {

        Dictionary dictionary = new Dictionary();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // 1) Add contact 2) Search 3) Exit
            boolean flag = true;

            while (flag) {

                System.out.println("1) Add contact 2) Search 3) Exit");
                String line = bufferedReader.readLine().trim();

                if (line.equals("1")) {
                    System.out.print("Enter name: ");
                    String data = bufferedReader.readLine().trim();
                    String name[] = data.split(" ");
                    if (data.isEmpty() || name.length > 2) {
                        System.out.println("You can specify firstname AND/OR lastname in the format \"firstname lastname\" without quotes");
                    } else {
                        dictionary.add(data);
                    }
                } else if (line.equals("2")) {
                    System.out.print("Enter name: ");
                    String data = bufferedReader.readLine().trim();
                    List<String> search = dictionary.search(data);
                    for (String string : search) {
                        System.out.println(string);
                    }
                } else if (line.equals("3")) {
                    flag = false;
                    System.out.println("Happy Searching");
                } else {
                    System.out.println("Wrong input. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) bufferedReader.close();
        }

    }

}

package com.personal.backtracking;

import java.util.Scanner;

/*

Given a string s containing only digits, Your task is to complete the function genIp which returns a vector containing all possible combination of 
valid ip address and takes only a string s as its only argument . 
Note : Order doesn't matter

For string 11211 the ip address possible are 
1.1.2.11
1.1.21.1
1.12.1.1
11.2.1.1

Input:
The first line of input will contain no of test cases T. Then T test cases follow . Each test case will contains a string s . 

Output:
The output in the expected output will be 1 if successfully all the combinations were obtained in the returned vector else it will be 0.


input 
1. 123123000
2. 00123123123
3. 11211
*/

public class GenerateIps {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        String inputString = Integer.parseInt(string) + "";
        new GenerateIps().generateIps(inputString, "", 0, inputString.length(), 4);
        scanner.close();
    }

    void generateIps(String string, String prefix, int index, int size, int remaining) {
        if (remaining == 0 && index == size) {
            System.out.println(prefix);
            return;
        }


        for (int i = 1; i <= 3 && (index + i <= size); i++) {
            String p = string.substring(index, index + i);
            int prefixValid = isPrefixValid(p);
            if (prefixValid != -1) {
                generateIps(string, prefix + prefixValid + (index + i == size ? "" : "."), index + i, size, remaining - 1);
            }

        }
    }

    private int isPrefixValid(String p) {
        int i = Integer.parseInt(p);
        if (i >= 0 && i <= 255) {
            return i;
        }
        return -1;
    }
}

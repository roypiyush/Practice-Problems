/**
 *
 */
package com.hackerrank.assorted;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author piyush
 */
public class FibonacciModified {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            BigInteger a = new BigInteger(scanner.next());
            BigInteger b = new BigInteger(scanner.next());
            BigInteger n = new BigInteger(scanner.next());

            BigInteger result = null;
            for (int i = 2; i < n.longValue(); i++) {
                result = b.multiply(b).add(a);
                a = b;
                b = result;
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
}

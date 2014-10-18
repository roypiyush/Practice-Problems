package com.hackerrank.strings;

import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int T = Integer.parseInt(scanner.nextLine());

			for (int i = 0; i < T; i++) {
				String str = scanner.nextLine();
				System.out.println(getPalindromeIndex(str));
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	private static int getPalindromeIndex(String str) {
		int size = str.length();
		
		String s1 = str.substring(1, size);
		if(s1.equals(new StringBuilder(s1).reverse().toString()))
			return 0;
		
		s1 = str.substring(0, size - 1);
		if(s1.equals(new StringBuilder(s1).reverse().toString()))
			return size - 1;
		
		for (int i = 1; i < size - 1; i++) {
			String str1 = str.substring(0, i);
			String str2 = str.substring(i + 1, size);
			if(str1.equals(str2))
				return i;
		}
		return -1;
	}

}

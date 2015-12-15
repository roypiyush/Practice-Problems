/**
 * 
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 *
 */
public class MakingChangeCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			int sum = scanner.nextInt();
			int arraySize = scanner.nextInt();
			int[] denominations = new int[arraySize];
			for (int i = 0; i < denominations.length; i++) {
				denominations[i] = scanner.nextInt();
			}
			
			System.out.println(countMaxPossibleChange(sum, denominations));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

	}

	private static int countMaxPossibleChange(int sum, int[] denominations) {
		int[] result = new int[sum + 1];
		for (int i = 0; i < result.length; i++) result[i] = -1;
		
		int internalCountMaxPossibleChange = internalCountMaxPossibleChange(sum, denominations, result, denominations.length);
		return internalCountMaxPossibleChange;
	}
	
	private static int internalCountMaxPossibleChange(int sum, int[] denominations, int[] result, int index) {
		
		
		if(sum < 0)
			return 0;
		if(sum == 0)
			return 1;
		if(index <= 0 && sum >= 1) {
			result[sum] = 0;
			return result[sum];
		}
		if(result[sum] >= 0)
			return result[sum];
		
		int x = internalCountMaxPossibleChange(sum, denominations, result, index - 1);
		int y = internalCountMaxPossibleChange(sum - denominations[index - 1], denominations, result, index);
		int res = x + y;
		result[sum] = result[sum] > 0 ? result[sum] : res;
		return result[sum];
	}

}

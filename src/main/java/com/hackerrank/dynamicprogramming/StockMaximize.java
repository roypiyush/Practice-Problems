/**
 * 
 */
package com.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * @author piyush
 *
 */
public class StockMaximize {

	
	private static void findSolution(int[] arr) {
		
	}
	
	public static void main(String[] args) {
		
		try(Scanner s = new Scanner(System.in)) {
            
            int t = s.nextInt();
            
            while(t-- > 0) {
                int size = s.nextInt();
                int[] arr = new int[size];
                for(int i = 0; i < size; i++)
                    arr[i] = s.nextInt();
                
                // find solution
                findSolution(arr);
                    
            }
            
            
        } catch (Exception e) { }

	}

}

/**
 * 
 */
package com.hackerrank.searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author piyush
 *
 */
public class MaximizeSum {

	static long maxbs(long[] arr, int start, int end, long val) {
	    
		int low = start;
		int high = end;
		int mid = 0;
	    while(low <= high) {
	        
	        mid = (low + high) / 2;
	        
	        if(arr[mid] == val) {
	            return arr[mid];
	        }
	        else if(arr[mid] < val) {
	            low = mid + 1;
	        }
	        else {
	            high = mid - 1;
	        }
	    }
	    return arr[mid];
	}

	static long max(long a, long b) {
	    return a > b ? a : b;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		long T = s.nextLong();
	    
	    while(T-- > 0) {
	    	
	        int size = s.nextInt();
	        long mod = s.nextLong();
	        long[] arr = new long[size];

	        for(int i = 0; i < size; i++) {
	        	arr[i] = s.nextLong();
	        }

	        Arrays.sort(arr);
	        
	        long max = -1;
	        for(int i = 0; i < size; i++) {
	        	long x = arr[i];
	        	long maxPosVal = mod - x % mod - 1;
	        	long y = -1;
	            if(maxPosVal >= x) {
	                // binary search from i + 1 till end
	                y = maxbs(arr, i + 1, size - 1, maxPosVal);
	            }
	            else {
	                // binary search from 0 till i - 1
	                y = maxbs(arr, 0, i - 1, maxPosVal);
	            }
	            if(max == -1 || max < ((x + y) % mod)) {
	                max = (x + y) % mod;
	            }
	        }
	        System.out.println(max);
	    }
	    
	    s.close();
	}

}

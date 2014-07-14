package com.dp;

import java.util.LinkedList;
import java.util.List;


/* Problem Statement
 * 
 Little Fox Jiro has a rectangular board. On the board there is a row of N unit cells. The cells are numbered 0 through N-1 
 from the left to the right. Initially, the cells are not colored. Jiro must color each of the cells red, green, or blue.
 You are given a String desiredColor with N characters. For each i, character i of desiredColor represents the color Jiro
 must use for cell i. If a character is one of 'R' (as red), 'G' (as green), and 'B' (as blue), it means that Jiro must use 
 that particular color. If a character is '*', Jiro may use any of the three colors for the particular cell.
 You are also given the ints stampCost and pushCost that describe the cost of the coloring process. The coloring process 
 consists of two phases. In the first phase, Jiro must pick a single stamp he will then use to color all the cells. The 
 length L of the stamp can be any integer between 1 and N, inclusive. A stamp of length L costs L*stampCost.
 
 In the second phase, Jiro must repeatedly use the stamp to color the cells. Each use of the stamp works as follows:
 1) Jiro picks one of the three colors and pushes the stamp into ink of the chosen color C.
 2) Jiro picks a segment of L contiguous cells such that each of them is either uncolored or already has the color C. 
 The segment must be completely inside the board. That is, the leftmost cell of the segment must be one of the cells 0 through N-L.
 3) Jiro pushes the stamp onto the chosen segment of cells. All the cells now have color C.
 Each use of the stamp costs pushCost.
 
 Return the smallest possible total cost of coloring all the cells using the above process.
 
 Constraints
-	desiredColor will contain between 1 and 50 characters, inclusive.
-	Each character of desiredColor will be either 'R' or 'G' or 'B' or '*'.
-	stampCost will be between 1 and 100,000, inclusive.
-	pushCost will be between 1 and 100,000, inclusive.
 
 
 */

/*
 * Firstly, Need to find longest length stamp, l
 * Secondly, Need to find color change count along desirecColor, colorChange
 * result = l * stampCost + colorChange * pushCost
 * 
 * 
 */

public class Stamp {

	int getLengthOfStamp(String desiredColor, int i, int j) {
		int length = 1;
		
		if(i >= j)
			return Integer.MAX_VALUE;
		
		
		return length;
	}
	
	/**
	 * 
	 * @param desiredColor
	 * @param start => 0 based
	 * @param end   => 1 based
	 * @param stampingLength
	 * @return
	 */
	int getPushCount(String desiredColor, int start, int end, int stampingLength) {
		if(end - start < stampingLength)
			return -1;
		
		char a = '\0';
		for (int i = start; i < end; i++) {
			if(a == '\0'  && desiredColor.charAt(i) != '*') 
				a = desiredColor.charAt(i);
			else {
				a = desiredColor.charAt(i);
			}
			
		}
		return 0;
	}
	
	/**
	 * @param desiredColor
	 * @return Position based integers
	 */
	List<Integer> getCuttingPoints(String desiredColor) {
		List<Integer> integers = new LinkedList<Integer>();
		
		char p = desiredColor.charAt(0);
		for (int i = 1; i < desiredColor.length(); i++) {
			if(desiredColor.charAt(i) == '*') {
				integers.add(i);
			}
			else {
				if(desiredColor.charAt(i) != p) {
					integers.add(i);
				}
					
			}
			p = desiredColor.charAt(i);
		}
		
		return integers;
	}
	
	int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		return 0;
	}
	
	public static void main(String[] args) {
		String desiredColor = "R**GBBR";
		int stampCost = 1;
		int pushCost = 1;
		
		
		System.out.println(new Stamp().getMinimumCost(desiredColor, stampCost, pushCost));
		

	}

}

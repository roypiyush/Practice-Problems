package com.dp;

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

	
	private boolean validateLength(String desiredColor, int start, int end, int stampingLength) {
		
		if(start >= desiredColor.length() || end >= desiredColor.length())
			return false;
		
		if(start > end)
			return false;
		
		if (start + stampingLength <= end + 1)
			return true;
		
		return false;
	}
	
	private boolean validateColor(String desiredColor, int start, int end, int stampingLength) {

		// Performing validation if it is of same color
		char a = '\0';
		for (int i = start; i < end; i++) {
			if(desiredColor.charAt(i) == '*') 
				continue;
			
			if(a == '\0') 
				a = desiredColor.charAt(i);
			else if (desiredColor.charAt(i) != a)
				return false;			
		}
		
		return true;
	}
	
	private boolean isBreakable(String desiredColor, int start, int end) {
		return true;
	}
	
	/**
	 * 
	 * @param desiredColor
	 * @param start => 0 based
	 * @param end   => 1 based
	 * @param stampingLength
	 * @return pushCount
	 */
	int calculatePushCount(String desiredColor, int start, int end, int stampingLength) {
		return (end - start + 1)/stampingLength + ((end - start + 1) % stampingLength > 0 ? 1 : 0);
	}

	/**
	 * Find stamping count for a given <em>stampingLength</em>
	 * 
	 * @param desiredColor
	 * @param start = index based
	 * @param end = index based
	 * @param stampingLength
	 * @return
	 */
	int findMinimumPushCount(String desiredColor, int start, int end, int stampingLength) {
		
		if(start > end)
			return 0;
		else if(start >= desiredColor.length() || end >= desiredColor.length()) {
			return 0;
		}
		
		int min = -1;
		
		for (int i = start; i <= end; i++) {
			
			if(!validateLength(desiredColor, start, i, stampingLength))
				continue;
			
			boolean isValid = validateColor(desiredColor, start, i, stampingLength);
			
			if(isValid) {
				
				// Break and calculate
				int pc =  calculatePushCount(desiredColor, start, i, stampingLength);
				
				// This will calculate from next index position
				int fmpc = findMinimumPushCount(desiredColor, i + 1, end, stampingLength);
				
				if(min == -1)
					min = pc + fmpc;
				else 
					min = Math.min(min, pc + fmpc);
			}
			else {
				// No further checking required, You can break the loop
				return Integer.MAX_VALUE;
			}
		}
		
		return min;
}

	int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		
		int pushCount = Integer.MAX_VALUE;
		int stampLength = -1;
		
		for (int i = 2; i <= 2; i++) {
			int t = findMinimumPushCount(desiredColor, 0, desiredColor.length() - 1, i);
			
			System.out.println(i + " " + t);
			
			if(t < pushCount) {
				stampLength = i;
				pushCount = t;
			}
		}
		
//		System.out.println(stampLength + " " + pushCount);
		
		return stampLength * stampCost + pushCount * pushCost;
	}
	
	public static void main(String[] args) {
		String desiredColor = "GGRR*RR";
		int stampCost = 1;
		int pushCost = 1;
		
		Stamp stamp = new Stamp();
		System.out.println(stamp.getMinimumCost(desiredColor, stampCost, pushCost));
	}

}

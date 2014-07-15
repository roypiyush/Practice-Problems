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

	
	/**
	 * 
	 * @param desiredColor
	 * @param start => 0 based
	 * @param end   => 1 based
	 * @param stampingLength
	 * @return -1 when not possible to calculate count
	 */
	int calculatePushCount(String desiredColor, int start, int end, int stampingLength) {
		return (end - start)/stampingLength + ((end - start) % stampingLength > 0 ? 1 : 0);
	}


	private boolean validateColor(String desiredColor, int start, int end,
			int stampingLength) {
		if(end - start < stampingLength)
			return false;
		
		char a = '\0';
		// Performing validation if it is of same color
		for (int i = start; i < end; i++) {
			if(desiredColor.charAt(i) == '*') 
				continue;
			
			if(a == '\0') 
				a = desiredColor.charAt(i);
			else if (desiredColor.charAt(i) != a)
				return false;			
		}
		if(a == '\0')
			return false;
		
		return true;
	}
	
	
	int findMinimumStampCount(String desiredColor, int start, int end, int length, String loop) {
		
		System.out.println(String.format(loop + "Looping with %d and %d with length %d", start, end, length));
		
		if(start == end)
			return 0;
		
		System.out.println(String.format(loop + "Considering colors %s", desiredColor.substring(start, end)));
		
		boolean isValid = validateColor(desiredColor, start, end, length);
		
		
		
		
		
		if(isValid)
			return calculatePushCount(desiredColor, start,
					end, length) + findMinimumStampCount(desiredColor, end, desiredColor.length(), length, loop + " ") ;
		else {
			int r1 = findMinimumStampCount(desiredColor, start, end - 1, length, loop + " ");
//			int r2 = findMinimumStampCount(desiredColor, end - 1, desiredColor.length(), length, loop + " ") ;
			return r1;
		}
		
	}
	
	int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		
		int stampCount = Integer.MAX_VALUE;
		int stampLength = -1;
		
		for (int i = 1; i <= desiredColor.length(); i++) {
			int t = findMinimumStampCount(desiredColor, 0, desiredColor.length(), i, "");
			
			if(stampCount > t) {
				stampLength = i;
				stampCount = t;
			}
			
		}
		
		System.out.println(stampCount + " " + stampLength);
		
		
		return 0;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String desiredColor = "R**GBB";
		int stampCost = 1;
		int pushCost = 1;
		
		Stamp stamp = new Stamp();
		System.out.println(stamp.getMinimumCost(desiredColor, 0, 0));
	}

}

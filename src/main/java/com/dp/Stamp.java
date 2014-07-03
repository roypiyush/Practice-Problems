package com.dp;

/*
 * Firstly, Need to find longest length stamp, l
 * Secondly, Need to find color change count along desirecColor, colorChange
 * result = l * stampCost + colorChange * pushCost
 */

public class Stamp {

	int getMaxLengthStamp(String desiredColor) {
		int maxLength = 1;
		
		return maxLength;
	}
	
	int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		return 0;
	}
	
	public static void main(String[] args) {
		String desiredColor = "RRGGBB";
		int stampCost = 1;
		int pushCost = 1;
		
		System.out.println(new Stamp().getMinimumCost(desiredColor, stampCost, pushCost));

	}

}

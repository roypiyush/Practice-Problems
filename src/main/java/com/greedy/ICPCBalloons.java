package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


class WinnerOfProblem implements Comparable<WinnerOfProblem>{
	private char size;
	private int currentCount;
	private int totalCount;
	
	/**
	 * Holds change in balloons color
	 */
	private int colorChanged = 0;
	private int colorAssigned = -1;
	
	

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	
	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setColorChanged(int colorChanged) {
		this.colorChanged = colorChanged;
	}

	public int getColorChanged() {
		return colorChanged;
	}

	public int getColor() {
		return colorAssigned;
	}
	
	public void setColor(int colorAssigned) {
		this.colorAssigned = colorAssigned;
	}

	/**
	 * Cannot add balloons greater than totalCount
	 * @param balloons
	 */
	public boolean addBalloons(int balloons, int color) {
		
		if(currentCount + balloons <= totalCount) {
		
			if(colorAssigned != -1) {
				colorAssigned = color;
				currentCount += balloons;
			} 
			else { // Color Change will only happen on old assignment
				int c = Math.min(getCurrentCount(), balloons);
				currentCount += c;
				colorChanged += c;
			}
			return true;
		}
		return false;
	}
	
	public int compareTo(WinnerOfProblem wop) {
		return this.totalCount - wop.getTotalCount();
	}
	
}


public class ICPCBalloons {
	
	private int minRepaintings(Integer[] balloonCount, String balloonSize, Integer[] maxAccepted) {
		int minPaint = 0;
		
		// Rearrange balloonCount
		List<Integer> integers = Arrays.asList(balloonCount);
		Collections.sort(integers);
		Collections.reverse(integers);
		balloonCount = integers.toArray(new Integer[integers.size()]);
		
		// Rearrange maxAccepted
		integers = Arrays.asList(maxAccepted);
		Collections.sort(integers);
		Collections.reverse(integers);
		maxAccepted = integers.toArray(new Integer[integers.size()]);
	
		
		int totalRequired = 0; // find sum of remaining winners to keep track if at the end condition is satisfied 
		WinnerOfProblem[] winnerOfProblems = new WinnerOfProblem[maxAccepted.length];
		for (int i = 0; i < winnerOfProblems.length; i++) {
			WinnerOfProblem wop = new WinnerOfProblem();
			wop.setTotalCount(maxAccepted[i]);
			winnerOfProblems[i] = wop;
			totalRequired += maxAccepted[i];
		}
		
		int balloonIndex = 0;
		

		for (int i = 0; i < winnerOfProblems.length; i++) {
			
			for (int j = 0; j < balloonCount.length; j++) {
				
				WinnerOfProblem wop = winnerOfProblems[i];
				
				if(wop.getCurrentCount() == wop.getTotalCount()) {
					i++;
					continue;
				}
				
				int remaining = wop.getTotalCount() - wop.getCurrentCount();
				
				if(balloonCount[balloonIndex] >= remaining) {
					
					if(wop.getColor() != -1) {
						// TODO
					}
					else {
						// TODO
					}
					
					wop.addBalloons(remaining, balloonIndex);
					balloonCount[balloonIndex] = balloonCount[balloonIndex] - remaining;
					i++;
				}
				else {
					wop.addBalloons(balloonCount[balloonIndex], balloonIndex);
					balloonCount[balloonIndex] = 0;
				}
			}
		}
		
		
		return minPaint;
		
		
	}
	
	public static void main(String[] args) {
		
		Integer[] balloonCount  = {100};
		String balloonSize = 	"L";
		Integer[] maxAccepted = {1,2,3,4,5,6};
		
		System.out.println(new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));

	}

}

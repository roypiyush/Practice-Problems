package com.greedy;

import java.util.Collections;
import java.util.LinkedList;

/*
Problem Statement
=================
There are N boxes numbered from 0 to N-1, inclusive. 
For each i, box i contains red[i] red balls, green[i] green balls, and blue[i] blue balls. 

Fox Ciel wants to separate the balls by colors. In each operation, she can pick a single ball from some box 
and put it into another box. She considers the balls to be separated if no box contains balls of more than one color. 

Return the minimal number of operations required to separate the balls. If this is impossible, return -1.

Constraints
-	red, green and blue will each contain between 1 and 50 elements, inclusive.
-	red, green and blue will contain the same number of elements.
-	Each element of red, green and blue will be between 1 and 1,000,000, inclusive.
*/

class Item implements Comparable<Item>{
	
	private int index;
	private int value;
	private int color;
	
	public Item(int index, int value, int color) {
		super();
		this.index = index;
		this.value = value;
		this.color = color;
	}

	public int getIndex() {
		return index;
	}

	public int getValue() {
		return value;
	}

	public int getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Item [i=" + index + ", v=" + value + ", c=" + color	+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(!(obj instanceof Item))
			return false;		
		Item other = (Item) obj;
		if (index != other.index)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	public int compareTo(Item item) {
		return this.value - item.getValue();
	}
	
}

public class BallsSeparating {

	public int minOperations(int[] red, int[] green, int[] blue) {
		
		if(red.length < 3)
			return -1;
		
		
		LinkedList<Item> balls = new LinkedList<Item>();
		
		for (int i = 0; i < blue.length; i++) {
			balls.add(new Item(i, red[i], 0));
			balls.add(new Item(i, green[i], 1));
			balls.add(new Item(i, blue[i], 2));
		}
		
		Item r = null;
		Item g = null;
		Item b = null;
		
		Collections.sort(balls);
		
		
		
		
		int j = balls.size() - 1;
		do {
			
			Item x = balls.get(j);
			
			if(x.getColor() == 0 && r == null) {
				if((g != null && g.getIndex() != x.getIndex())
						&& (b != null && b.getIndex() != x.getIndex())
						) {
					r = balls.remove(j);
				}
				else if(g == null && (b != null && b.getIndex() != x.getIndex())) {
					r = balls.remove(j);
				}
				else if((g != null && g.getIndex() != x.getIndex()) && (b == null) ) {
					r = balls.remove(j);
				}
				else if(g == null && b == null) {
					r = balls.remove(j);
				}
			}
			else if(x.getColor() == 1 && g == null) {
				if((r != null && r.getIndex() != x.getIndex())
						&& (b != null && b.getIndex() != x.getIndex())
						) {
					g = balls.remove(j);
				}
				else if(r == null && (b != null && b.getIndex() != x.getIndex())) {
					g = balls.remove(j);
				}
				else if((r != null && r.getIndex() != x.getIndex()) && (b == null) ) {
					g = balls.remove(j);
				}
				else if(r == null && b == null) {
					g = balls.remove(j);
				}
			}
			else if(x.getColor() == 2 && b == null) {
				if((g != null && g.getIndex() != x.getIndex())
						&& (r!= null && r.getIndex() != x.getIndex())
						) {
					b = balls.remove(j);
				}
				else if(g == null && (r != null && r.getIndex() != x.getIndex())) {
					b = balls.remove(j);
				}
				else if((g != null && g.getIndex() != x.getIndex()) && (r == null) ) {
					b = balls.remove(j);
				}
				else if(g == null && r == null) {
					b = balls.remove(j);
				}
			}
			
			j--;
			
		} while(j >= 0 && (r == null || g == null || b == null));
		
		
		int movement = 0;
		for(int i = 0; i < balls.size(); i++) {
			
			Item item = balls.get(i);
			
			if(item.getColor() == 0 && (green[item.getIndex()] > 0 || blue[item.getIndex()] > 0)) {
				movement = movement + red[item.getIndex()];
				red[item.getIndex()] = 0;
			}
			else if(item.getColor() == 1 && (red[item.getIndex()] > 0 || blue[item.getIndex()] > 0)) {
				movement = movement + green[item.getIndex()];
				green[item.getIndex()] = 0;
			}
			else if(item.getColor() == 2 && (red[item.getIndex()] > 0 || green[item.getIndex()] > 0)) {
				movement = movement + blue[item.getIndex()];
				blue[item.getIndex()] = 0;
			}
		}
		
		return movement;
	}

	public static void main(String[] args) {
		int   red[] = {1, 1, 1};
		int green[] = {1, 1, 1};
		int  blue[] = {1, 1, 1};
		
//		int   red[] = {4, 6, 5, 7};
//		int green[] = {7, 4, 6, 3};
//		int  blue[] = {6, 5, 3, 8};
				
//		int   red[] = {7, 12, 9, 9, 7};
//		int green[] = {7, 10, 8, 8, 9};
//		int  blue[] = {8, 9, 5, 6, 13};
			
//		int   red[] = {842398, 491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150, 75799};
//		int green[] = {268944, 342402, 894352, 228640, 903885, 908656, 414271, 292588, 852057, 889141};
//		int  blue[] = {662939, 340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590, 505103};
		
		System.out.println(new BallsSeparating().minOperations(red, green, blue));

	}

}

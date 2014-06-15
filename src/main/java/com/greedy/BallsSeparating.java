package com.greedy;

import java.util.Arrays;
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
		
		LinkedList<Item> redBalls = new LinkedList<Item>();
		LinkedList<Item> greenBalls = new LinkedList<Item>();
		LinkedList<Item> blueBalls = new LinkedList<Item>();
		
		for (int i = 0; i < blue.length; i++) {
			
			redBalls.add(new Item(i, red[i], 0));
			greenBalls.add(new Item(i, green[i], 1));
			blueBalls.add(new Item(i, blue[i], 2));
			
		}
		
		Collections.sort(redBalls);
		Collections.sort(greenBalls);
		Collections.sort(blueBalls);
		
		Item baseRed = redBalls.peekLast();
		Item baseGreen = greenBalls.peekLast();
		Item baseBlue = blueBalls.peekLast();
		
		while (baseRed.getIndex() == baseGreen.getIndex() || baseGreen.getIndex() == baseBlue.getIndex() || baseBlue.getIndex() == baseRed.getIndex()) {
			if (baseRed.getIndex() == baseGreen.getIndex()) {

				if (greenBalls.peekLast().getValue() <= redBalls.peekLast()
						.getValue()) {
					baseGreen = greenBalls.get(greenBalls
							.lastIndexOf(baseGreen) - 1);
				} else {
					baseRed = redBalls.get(redBalls.lastIndexOf(baseRed) - 1);
				}
			}
			else if (baseGreen.getIndex() == baseBlue.getIndex()) {

				if (greenBalls.peekLast().getValue() <= blueBalls.peekLast()
						.getValue()) {
					baseGreen = greenBalls.get(greenBalls
							.lastIndexOf(baseGreen) - 1);
				} else {
					baseBlue = blueBalls
							.get(blueBalls.lastIndexOf(baseBlue) - 1);
				}

			}
			else if (baseBlue.getIndex() == baseRed.getIndex()) {

				if (redBalls.peekLast().getValue() <= blueBalls.peekLast()
						.getValue()) {
					baseRed = redBalls.get(redBalls.lastIndexOf(baseRed) - 1);
				} else {
					baseBlue = blueBalls
							.get(blueBalls.lastIndexOf(baseBlue) - 1);
				}

			}
		}
		
		redBalls.remove(baseRed);
		greenBalls.remove(baseGreen);
		blueBalls.remove(baseBlue);

		int movement = 0;
		while(!redBalls.isEmpty() && !greenBalls.isEmpty() && !blueBalls.isEmpty()) {
			
			LinkedList<Item> removals = new LinkedList<Item>();
			removals.add(redBalls.poll());
			removals.add(greenBalls.poll());
			removals.add(blueBalls.poll());
			
			Collections.sort(removals);
			
			printArray(red);
			printArray(green);
			printArray(blue);
			System.out.println(removals);
			

			while (!removals.isEmpty()) {
				Item item = removals.poll();
				if(item.getColor() == 0) {
					if(green[item.getIndex()] > 0 || blue[item.getIndex()] > 0) {
						movement = movement + red[item.getIndex()];
						red[baseRed.getIndex()] = red[baseRed.getIndex()] + red[item.getIndex()];
						red[item.getIndex()] = 0;
					}
				}
				else if(item.getColor() == 1) {
					if(red[item.getIndex()] > 0 || blue[item.getIndex()] > 0) {
						movement = movement + green[item.getIndex()];
						green[baseGreen.getIndex()] = green[baseGreen.getIndex()] + green[item.getIndex()];
						green[item.getIndex()] = 0;
					}
				}
				else {
					if(red[item.getIndex()] > 0 || green[item.getIndex()] > 0) {
						movement = movement + blue[item.getIndex()];
						blue[baseBlue.getIndex()] = blue[baseBlue.getIndex()] + blue[item.getIndex()];
						blue[item.getIndex()] = 0;
					}
				}
			}
		
		}
		
		printArray(red);
		printArray(green);
		printArray(blue);
		
		
		return movement;
	}
	
	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(String.format("%08d ", array[i]));
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		int   red[] = {1, 1, 1};
//		int green[] = {1, 1, 1};
//		int  blue[] = {1, 1, 1};
		
		
			
			
			
		int   red[] = {842398, 491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150, 75799};
		int green[] = {268944, 342402, 894352, 228640, 903885, 908656, 414271, 292588, 852057, 889141};
		int  blue[] = {662939, 340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590, 505103};
		
		System.out.println(new BallsSeparating().minOperations(red, green, blue));

	}

}

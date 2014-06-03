package com.bruteforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class EelAndRabbit {

	public int getmax(int[] l, int[] t) {
		
		
		Map<Integer, List<Integer>> density = new HashMap<Integer, List<Integer>>();
		int minIndex = Integer.MAX_VALUE;
		List<Integer> eelsToCatch = null;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j <= l[i]; j++) {
				List<Integer> eels = density.get(t[i] + j);
				if(eels == null) {
					eels = new ArrayList<Integer>();
					
				}
				eels.add(i);
				if(eelsToCatch == null || eels.size() > eelsToCatch.size()) {
					eelsToCatch = eels;
					if(minIndex > t[i] + j)
					minIndex = t[i] + j;
				}

				density.put(t[i] + j, eels);
			}
			
		}
		
		
		int eelsCatched = 0;
		// Catch the eels
		for (Integer eel : eelsToCatch) {
			// Search for each eel in the range t[eel] (+-) l[eel]
			for(int j = 0; j <= l[eel]; j++) {
				
				List<Integer> list1 = density.get(t[eel] - j);
				if(list1.contains(eel)) {
					list1.remove(eel);
					eelsCatched++;
				}
				List<Integer> list2 = density.get(t[eel] + j);
				if(list2.contains(eel)) {
					list2.remove(eel);
					eelsCatched++;
				}
				
			}
		}
		
		
		minIndex = Integer.MAX_VALUE;
		eelsToCatch = null;
		// Search for next maxEels 
		for (Entry<Integer, List<Integer>> entry : density.entrySet()) {
			if(eelsToCatch == null || entry.getValue().size() > eelsToCatch.size()) {
				eelsToCatch = entry.getValue();
				if(minIndex > entry.getKey())
				minIndex = entry.getKey();
			}
		}

		// Catch the eels
		for (Integer eel : eelsToCatch) {
			// Search for each eel in the range t[eel] (+-) l[eel]
			for(int j = 0; j <= l[eel]; j++) {
				
				List<Integer> list1 = density.get(t[eel] - j);
				if(list1.contains(eel)) {
					list1.remove(eel);
					eelsCatched++;
				}
				List<Integer> list2 = density.get(t[eel] + j);
				if(list2.contains(eel)) {
					list2.remove(eel);
					eelsCatched++;
				}
				
			}
		}
		
		
		return eelsCatched;
	}
	
	public static void main(String[] args) {
		
		int[] l = {2, 4, 3, 2, 2, 1, 10};
		int[] t = {2, 6, 3, 7, 0, 2, 0};
		
		System.out.println(new EelAndRabbit().getmax(l, t));

	}

}
 
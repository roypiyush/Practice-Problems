package com.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class SortWithStart implements Comparator<Eel> {

	public int compare(Eel e1, Eel e2) {
		return e1.getStart() - e2.getStart();
	}
	
}

class SortWithEnd implements Comparator<Eel> {

	public int compare(Eel e1, Eel e2) {
		return e1.getEnd() - e2.getEnd();
	}
	
}

class Eel {
	
	private int start;
	private int end;
	public Eel(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	
	@Override
	public boolean equals(Object o) {
		Eel eel = null;
		if(o == null || !(o instanceof Eel))
		{
			return false;
		}
		eel = (Eel) o;
		if(this.start == eel.getStart() && this.end == eel.getEnd())
			return true;
		else
			return false;
		
	}
	
	@Override
	public String toString() {
		return "Eel [start=" + start + ", end=" + end + "]";
	}
	
}

public class EelAndRabbit {

	public int getmax(int[] l, int[] t) {
		List<Eel> eelsSortedWithStart = new ArrayList<Eel>();
		
		int startIndex = Integer.MAX_VALUE;
		int endIndex = Integer.MIN_VALUE;
		
		for (int i = 0; i < t.length; i++) {
			Eel eel = new Eel(t[i], t[i] + l[i]);
			
			if(t[i] < startIndex)
				startIndex = t[i];
			if(t[i] + l[i] > endIndex)
				endIndex = t[i] + l[i];
			
			eelsSortedWithStart.add(eel);
		}
		Collections.sort(eelsSortedWithStart, new SortWithStart());
		
		ArrayList<Eel> eelsSortedWithEnd = new ArrayList<Eel>();
		eelsSortedWithEnd.addAll(eelsSortedWithStart);
		Collections.sort(eelsSortedWithEnd, new SortWithEnd());
		
		ArrayList<Eel> addedEels = new ArrayList<Eel>();
		
		int count = 0;
		int maxCount = 0;
		
		int eelFrontNumber = 0;
		int eelBackNumber = 0;

		for(int i = startIndex; i <= endIndex; i++) {
			
			eelBackNumber = i;
			while(eelBackNumber >= 0 && eelsSortedWithEnd.get(eelBackNumber - 1).getEnd() < i ) {
				addedEels.remove(eelBackNumber - 1);
				eelBackNumber--;
				count = count - 1;
			}
			
			while(i >= eelsSortedWithStart.get(eelFrontNumber).getStart() && i <= eelsSortedWithStart.get(eelFrontNumber).getEnd()) {
				// Add it
				addedEels.add(eelsSortedWithStart.get(eelFrontNumber));
				eelFrontNumber++;
				count = count + 1;
				if(count > maxCount)
					maxCount = count;
			}
		}
		
		return count;
		
	}
	
	public int getmax1(int[] l, int[] t) {

		Map<Integer, List<Integer>> density = new HashMap<Integer, List<Integer>>();

		List<Integer> eelsToCatch = new ArrayList<Integer>();
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j <= l[i]; j++) {
				List<Integer> eels = density.get(t[i] + j);
				if(eels == null) {
					eels = new ArrayList<Integer>();
					
				}
				eels.add(i);
				if(eelsToCatch == null || eels.size() > eelsToCatch.size()) {
					eelsToCatch.clear();
					eelsToCatch.addAll(eels);
				}

				density.put(t[i] + j, eels);
			}
			
		}
		
		
		int eelsCatched = 0;
		// Catch the eels
		for (Integer eel : eelsToCatch) {
			
			boolean isRemoved = false;
			// Search for each eel in the range t[eel] (+-) l[eel]
			for(int j = 0; j <= l[eel]; j++) {
				
				List<Integer> list1 = density.get(t[eel] - j);
				if(list1 != null && list1.contains(eel)) {
					isRemoved = list1.remove(eel);
				}
				List<Integer> list2 = density.get(t[eel] + j);
				if(list2 != null && list2.contains(eel)) {
					isRemoved = list2.remove(eel);
				}
				
			}
			
			if(isRemoved)
				eelsCatched++;
		}
		
		
		eelsToCatch.clear();;
		// Search for next maxEels 
		for (Entry<Integer, List<Integer>> entry : density.entrySet()) {
			if(entry.getValue().size() > eelsToCatch.size()) {
				eelsToCatch.clear();
				eelsToCatch.addAll(entry.getValue());
			}
		}

		// Catch the eels
//		for (Integer eel : eelsToCatch) {
//			
//			boolean isRemoved = false;
//			// Search for each eel in the range t[eel] (+-) l[eel]
//			for(int j = 0; j <= l[eel]; j++) {
//				
//				List<Integer> list1 = density.get(t[eel] - j);
//				if(list1 != null && list1.contains(eel)) {
//					isRemoved = list1.remove(eel);
//				}
//				List<Integer> list2 = density.get(t[eel] + j);
//				if(list2 != null && list2.contains(eel)) {
//					isRemoved = list2.remove(eel);
//				}
//				
//			}
//			
//			if(isRemoved)
//				eelsCatched++;
//		}
		
		
		return eelsCatched + eelsToCatch.size();
	}
	
	public static void main(String[] args) {
		
//		int[] l = {925860128, 352368525, 44902106, 860136733, 471569488, 139173200, 376482278, 463384991, 546870708, 625674455, 556427037, 591760935, 468854534, 455004214, 523333786, 230141605, 52231465, 103657267, 15081092, 502651897, 420460974, 937293703, 135014018, 693974683, 1000000000, 867250346, 641790292, 655972113, 932141290, 360889250, 518975058, 725606408, 316842192, 818357724, 708072309, 966080205, 776030859, 434747924, 688443645, 88292749, 107668054, 809869761, 408399458, 207422940, 745058701, 802273571, 358594999, 786743954, 822666157, 478381787};
//		int[] t = {925860128, 352368525, 44902106, 860136733, 471569488, 139173200, 376482278, 463384991, 546870708, 625674455, 556427037, 591760935, 468854534, 455004214, 523333786, 230141605, 52231465, 103657267, 15081092, 502651897, 420460974, 937293703, 135014018, 693974683, 1000000000, 867250346, 641790292, 655972113, 932141290, 360889250, 518975058, 725606408, 316842192, 818357724, 708072309, 966080205, 776030859, 434747924, 688443645, 88292749, 107668054, 809869761, 408399458, 207422940, 745058701, 802273571, 358594999, 786743954, 822666157, 478381787};
		int[] l = {2, 4, 3, 2, 2, 1, 10};
		int[] t = {2, 6, 3, 7, 0, 2, 0};		
		System.out.println(new EelAndRabbit().getmax(l, t));

	}

}
 
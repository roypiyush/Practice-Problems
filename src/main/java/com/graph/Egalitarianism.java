package com.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Egalitarianism {

	int maxDifference(String[] isFriend, int d) {
		
		int max = -1;
		for (int i = 0; i < isFriend.length; i++) {
			int distance = getMaxDistanceWithSource(isFriend, i);
			if(distance == -1) {
				return distance;
			}
			if(distance > max) {
				max = distance;
			}
		}
		
		return max * d;
	}
	
	private int getMaxDistanceWithSource(String[] adjMatrix, int s) {
		List<Integer> queue = new LinkedList<Integer>();
		Set<Integer> connected = new HashSet<Integer>();
		
		int[] colors = new int[adjMatrix.length];
		int[] d = new int[adjMatrix.length];
		
		queue.add(new Integer(s));
		connected.add(new Integer(s));
		
		int maxD = 0;
		while(!queue.isEmpty()) {
			
			int vertex = queue.remove(0);
			String adjList = adjMatrix[vertex];
			
			for(int i = 0; i < adjList.length(); i++) {
				if(adjList.charAt(i) == 'Y' && colors[i] == 0 && d[i] == 0) {
					
					
					
					queue.add(new Integer(i));
					d[i] = d[vertex] + 1;
					if(d[i] > maxD)
						maxD = d[i];
				}
			}
			connected.add(vertex);
			colors[vertex] = 1;
		}

		return connected.size() == adjMatrix.length ? maxD : -1;
	}
	
	
	
	public static void main(String[] args) {
		String[] isFriend = {"NY",
				 "YN"};
		int d = 0;
		
		System.out.println(new Egalitarianism().maxDifference(isFriend, d) + "  " + (int)1e9);

	}

}

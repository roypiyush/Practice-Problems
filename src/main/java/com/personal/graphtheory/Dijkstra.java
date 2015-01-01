package com.personal.graphtheory;

import java.util.HashMap;
import java.util.Stack;

public class Dijkstra {
	
	public HashMap<Integer, Vertex> dijkstraAlgo(int[][] adjMatrix) {
		PriorityQueueForGraph priorityQueue = new PriorityQueueForGraph();
		
		// Initialize with default values
		for (int i = 0; i < adjMatrix.length; i++) {
			Vertex vertex = new Vertex();
			vertex.setId(i);
			vertex.setParent(-1);
			
			if(i == 0) {// Setting on vertex to be minimum key to let algo take over
				vertex.setKey(0);
			}
			else
				vertex.setKey(Integer.MAX_VALUE);
			
			priorityQueue.add(vertex);
		}
		
		HashMap<Integer, Vertex> hashMap = new HashMap<Integer, Vertex>();
		
		while(!priorityQueue.isEmpty()) {
			
			Vertex u = priorityQueue.poll();
			hashMap.put(u.getId(), u);
			
			for (int i = 0; i < adjMatrix[u.getId()].length; i++) {
				// Considering Edges
				if(adjMatrix[u.getId()][i] > 0) {
					Vertex v = priorityQueue.getElementById(i);
					
					// Perform Relaxation
					int path = u.getKey() + adjMatrix[u.getId()][i];
					if(v != null &&	path < v.getKey() ) {
						v.setParent(u.getId());
						v.setKey(path);
						// If using PQ, then you need to find index of v in PQ
					}
				}
			}
			priorityQueue.buildMinHeap();
		}
		return hashMap;
	}
	
	public static void main(String[] args) {
		
		int[][] adjMatrix = {
				{0,7,9,0,0,14},
				{7,0,10,15,0,0},
				{9,10,0,11,0,2},
				{0,0,11,0,6,0},
				{0,0,0,6,0,9},
				{14,0,2,0,9,0}
		};

		Dijkstra dijkstra = new Dijkstra();
		HashMap<Integer, Vertex> hashMap = dijkstra.dijkstraAlgo(adjMatrix);
		System.out.println(hashMap);
		// Trace Vertex 0 to 4
		int d = 4;
		Vertex b = hashMap.get(d);
		Stack<Vertex> trace = new Stack<Vertex>();
		trace.add(b);
		while(b.getParent() >= 0 && b.getKey() != Integer.MAX_VALUE) {
			b = hashMap.get(b.getParent());
			trace.push(b);
		}
		int pathLength = trace.firstElement().getKey();
		while(!trace.empty()) {
			Vertex u = trace.pop();
			System.out.print((u.getId() + 1) + (trace.isEmpty() ? "\n" : " -> "));
		}
		System.out.printf("Path length = %s", pathLength);
	}

}

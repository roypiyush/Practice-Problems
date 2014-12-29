package com.personal.graphtheory;

import java.util.ArrayList;
import java.util.HashMap;

class PQ {
	private ArrayList<Vertex> vertexs;
	
	public PQ() {
		vertexs = new ArrayList<Vertex>();
	}
	public void add(Vertex v) {
		vertexs.add(v);
		vertexs.trimToSize();
		if(vertexs.size() > 1) {
			buildMaxHeap();
		}
	}
	public Vertex poll() {
		if(vertexs.size() <= 0)
			throw new RuntimeException("No items to be removed");
		
		Vertex t = vertexs.remove(0);
		buildMaxHeap();
		return t;
	}
	public void buildMaxHeap() {
		int size = vertexs.size();
		for(int i = size/2 - 1; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	public Vertex getElementById(int id) {
		for (Vertex vertex : vertexs) {
			if(vertex.getId() == id)
				return vertex;
		}
		return null;
	}
	public int size() {
		return vertexs.size();
	}
	public boolean isEmpty() {
		return vertexs.size() == 0;
	}
	private void maxHeapify(int k) {
		int lowest = k;
		int l = left(k);
		int r = right(k);
		int size = vertexs.size();
		if(l < size && vertexs.get(l).getKey() < vertexs.get(k).getKey())
			lowest = l;
		if(r < size && vertexs.get(r).getKey() < vertexs.get(lowest).getKey())
			lowest = r;
		if(lowest != k) {
			Vertex t = vertexs.get(lowest);
			vertexs.set(lowest, vertexs.get(k));
			vertexs.set(k, t);
			maxHeapify(lowest);
		}
			
	}
	public boolean contains(Vertex v) {
		return vertexs.contains(v);
	}
	private int left(int i) {
		return 2*i;
	}
	private int right(int i) {
		return 2*i + 1;
	}
	public String toString() {
		return vertexs.toString();
	}
	
}

public class Prims {

	public static void main(String[] args) {
		int[][] adjMatrix = {
				{0,3,0,0,1},
				{3,0,5,0,4},
				{0,5,0,2,6},
				{0,0,2,0,7},
				{1,4,6,7,0}
		};
		
		
		PQ priorityQueue = new PQ();
		
		for (int i = 0; i < adjMatrix.length; i++) {
			Vertex vertex = new Vertex();
			vertex.setId(i);
			if(i == 0)
				vertex.setKey(0);
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
					if(v != null &&	adjMatrix[u.getId()][i] < v.getKey() ) {
						v.setParent(u.getId());
						v.setKey(adjMatrix[u.getId()][i]);
					}
				}
			}
			priorityQueue.buildMaxHeap();
		}
		
		// hashmap holds the tree
		System.out.println(hashMap);
		
	}

}

package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Earthland {

	public static void main(String[] args) {
		
		Scanner sc = null;
		BufferedInputStream br = null;
		try {
			br = new BufferedInputStream(System.in);
			sc = new Scanner(br);
			
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				int numberOfRooms = sc.nextInt();
				int numberOfEdges = sc.nextInt();
				
				int graph[][] = new int[numberOfRooms][numberOfRooms];
				Set<Integer> traversingPoints = new HashSet<Integer>();
				for (int i = 0; i < numberOfEdges; i++) {
					int v1 = sc.nextInt();
					int v2 = sc.nextInt();
					
					traversingPoints.add(v1 - 1);
					graph[v1 - 1][v2 - 1] = 1;
					
				}
				
				calculateRequiredFriends(graph, traversingPoints);
				
			}
			

		} catch (Exception e) {
			System.out
					.println(String.format("Error due to %s", e.getMessage()));
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (sc != null) {
				sc.close();
			}
		}

	}

	private static void calculateRequiredFriends(int[][] graph,
			Set<Integer> traversingPoints) {
		
		int count = 0;
		do {
//			System.out.println(depthFirstSearch(graph, traversingPoints));
			depthFirstSearch(graph, traversingPoints);
			count++;
		} while(traversingPoints.size() > 0);
		
		System.out.println(count - 1);
	}
	
	static int depthFirstSearch(int[][] adjMatrix, Set<Integer> traversingPoints) {
		
		int longestPath = 0;
		
		List<Integer> lp = new LinkedList<Integer>();
		
		for (Iterator<Integer> iterator = traversingPoints.iterator(); iterator.hasNext();) {
			Integer vertex = iterator.next();
			
			List<Integer> lpt = longestPathFromGivenVertex(adjMatrix, vertex);
			
//			System.out.println(String.format("Longest Path for vertex = %s is %s", vertex, lpt));
			if(lpt.size() > lp.size())
				lp = lpt;
			
		}
		
		traversingPoints.removeAll(lp);
		
		return longestPath;
	}

	static private List<Integer> longestPathFromGivenVertex(int[][] adjMatrix,
			Integer vertex) {
		
		int[] adjacencyList = adjMatrix[vertex];
		List<Integer> existingPath = new LinkedList<Integer>();
		existingPath.add(vertex);
		
		List<Integer> lp = new LinkedList<Integer>();
		
		for (int i = 0; i < adjacencyList.length; i++) {
			if(adjacencyList[i] == 1) {

				List<Integer> lpTemp = longestPathFromGivenVertex(adjMatrix, i);
				if(lpTemp.size() > lp.size()) {
					lp = lpTemp;
				}
			}
		}
		
		existingPath.addAll(lp);
		return existingPath;
		
	}

}

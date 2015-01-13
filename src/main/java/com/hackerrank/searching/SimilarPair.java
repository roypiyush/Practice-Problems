package com.hackerrank.searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SimilarPair {

public static void main(String[] args) {
		
		Set<Integer> parents = new HashSet<>();
		HashMap<Integer, List<Integer>> node = new HashMap<>();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			int T = scanner.nextInt();
			
			for (int i = 1; i < n; i++) {
				int s = scanner.nextInt();
				int e = scanner.nextInt();
				parents.add(s);
				
				if(node.get(s) == null) {
					List<Integer> children = new LinkedList<Integer>();
					children.add(e);
					node.put(s, children);
				}
				else {
					List<Integer> children = node.get(s);
					children.add(e);
				}
			}

			int pairs = 0;
			for(Integer p : parents) {
				pairs += findSimilarPairs(node, p, T);
			}
			System.out.println(pairs);
            
			
		} catch (Exception e) {
		} finally {
			if(scanner != null)
				scanner.close();
		}
		
	}

	/**
	 * Use DFS to find the pairs
	 * 
	 * @param node
	 * @param p
	 * @param t
	 * @return
	 */
	private static int findSimilarPairs(HashMap<Integer, List<Integer>> node,
			Integer p, int t) {
		
		int count = 0;
		List<Integer> children = node.get(p);
		for (int i = 0; children != null && i < children.size(); i++) {

			count += dfsVisit(node, p, children.get(i), t);
		}
		return count;
	}
	
	private static int dfsVisit(HashMap<Integer, List<Integer>> node,
			Integer p, Integer currentNode, int t) {
		
		int count = (Math.abs(currentNode - p) <= t) ? 1 : 0;
		
		List<Integer> children = node.get(currentNode);
		for (int i = 0; children != null && i < children.size(); i++) {

			count += dfsVisit(node, p, children.get(i), t);
		}
		
		return count;
	}

}

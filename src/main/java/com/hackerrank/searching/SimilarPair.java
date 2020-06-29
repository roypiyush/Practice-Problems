package com.hackerrank.searching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SimilarPair {

    public static void main(String[] args) {

        HashMap<Integer, Integer> parents = new HashMap<>();
        HashMap<Integer, List<Integer>> node = new HashMap<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int T = scanner.nextInt();
            int root = 0;

            for (int i = 1; i < n; i++) {
                int s = scanner.nextInt();
                if (i == 1)
                    root = s;

                int e = scanner.nextInt();

                parents.put(e, s);

                if (node.get(s) == null) {
                    List<Integer> children = new LinkedList<Integer>();
                    children.add(e);
                    node.put(s, children);
                } else {
                    List<Integer> children = node.get(s);
                    children.add(e);
                }
            }

            int pairs = 0;
            pairs += findSimilarPairs(node, root, T, parents);
            System.out.println(pairs);


        } catch (Exception e) {
        } finally {
            if (scanner != null)
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
                                        Integer p, int t, HashMap<Integer, Integer> parents) {

        int count = 0;
        List<Integer> children = node.get(p);
        for (int i = 0; children != null && i < children.size(); i++) {

            count += dfsVisit(node, p, children.get(i), t, parents);
        }
        return count;
    }

    private static int dfsVisit(HashMap<Integer, List<Integer>> node,
                                Integer p, Integer currentNode, int t, HashMap<Integer, Integer> parents) {

        int count = 0;
        Integer parentNode = parents.get(currentNode);
        while (parentNode != null) {
            count += (Math.abs(currentNode - parentNode) <= t) ? 1 : 0;
            parentNode = parents.get(parentNode);
            ;
        }

        List<Integer> children = node.get(currentNode);
        for (int i = 0; children != null && i < children.size(); i++) {

            count += dfsVisit(node, p, children.get(i), t, parents);
        }

        return count;
    }

}

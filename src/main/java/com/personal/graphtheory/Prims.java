package com.personal.graphtheory;

import java.util.HashMap;

public class Prims {

    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 3, 0, 0, 1},
                {3, 0, 5, 0, 4},
                {0, 5, 0, 2, 6},
                {0, 0, 2, 0, 7},
                {1, 4, 6, 7, 0}
        };
        Prims prims = new Prims();
        HashMap<Integer, Vertex> hashMap = prims.primsAlgo(adjMatrix);

        // hashmap holds the tree
        System.out.println(hashMap);

    }

    public HashMap<Integer, Vertex> primsAlgo(int[][] adjMatrix) {
        PriorityQueueForGraph priorityQueue = new PriorityQueueForGraph();

        // Initialize with default values
        for (int i = 0; i < adjMatrix.length; i++) {
            Vertex vertex = new Vertex();
            vertex.setId(i);
            if (i == 0) // Setting on vertex to be minimum key to let algo take over
                vertex.setKey(0);
            else
                vertex.setKey(Integer.MAX_VALUE);
            priorityQueue.add(vertex);
        }

        HashMap<Integer, Vertex> hashMap = new HashMap<Integer, Vertex>();

        while (!priorityQueue.isEmpty()) {
            Vertex u = priorityQueue.poll();
            hashMap.put(u.getId(), u);
            for (int i = 0; i < adjMatrix[u.getId()].length; i++) {
                // Considering Edges
                if (adjMatrix[u.getId()][i] > 0) {
                    Vertex v = priorityQueue.getElementById(i);
                    if (v != null && adjMatrix[u.getId()][i] < v.getKey()) {
                        v.setParent(u.getId());
                        v.setKey(adjMatrix[u.getId()][i]);
                        // If using PQ, then you need to find index of v in PQ
                    }
                }
            }
            priorityQueue.buildMinHeap();
        }
        return hashMap;
    }

}

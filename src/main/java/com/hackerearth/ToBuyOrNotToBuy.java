package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Vertex {
    private int id;
    private int key = Integer.MAX_VALUE;
    private int next = -1;

    public Vertex(int id, int key) {
        super();
        this.id = id;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vertex [id=" + id + ", key=" + key + "]";
    }
}

class Edge implements Comparable<Edge> {
    private int source;
    private int destination;
    private int value;

    public Edge(int source, int destination, int value) {
        super();
        this.source = source;
        this.destination = destination;
        this.setValue(value);
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Edge [source=" + source + ", destination=" + destination
                + ", value=" + value + "]";
    }

    @Override
    public int compareTo(Edge o) {
        return value - o.value;
    }

}

class VertexComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex o1, Vertex o2) {
        return o1.getKey() - o2.getKey();
    }

}

public class ToBuyOrNotToBuy {

    public static void main(String[] args) {
        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);

            int T = sc.nextInt();

            while (T-- > 0) {

                int numberOfVertices = sc.nextInt();
                int numberOfEdges = sc.nextInt();

                int[][] graph = new int[numberOfVertices][numberOfVertices];
                int[][] mst = new int[numberOfVertices][numberOfVertices];

                HashMap<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();
                ArrayList<Edge> edges = new ArrayList<Edge>();
                HashSet<Integer> set = new HashSet<Integer>();

                for (int i = 0; i < numberOfEdges; i++) {
                    int v1 = sc.nextInt() - 1;
                    int v2 = sc.nextInt() - 1;
                    int cost = sc.nextInt();
                    graph[v1][v2] = cost;

                    Vertex e1 = new Vertex(v1, i == 0 ? 0 : Integer.MAX_VALUE);
                    if (vertices.get(v1) == null) {
                        vertices.put(v1, e1);
                    }

                    Vertex e2 = new Vertex(v2, Integer.MAX_VALUE);
                    if (vertices.get(v2) == null) {
                        vertices.put(v2, e2);
                    }
                    edges.add(new Edge(v1, v2, cost));
                }

                Collections.sort(edges);

                // TODO for MST properly. Vertices are not added properly
                for (int i = 0; i < edges.size(); i++) {
                    Edge e = edges.get(i);

                    if (!set.contains(e.getDestination())) {
                        set.add(e.getSource());
                        mst[e.getSource()][e.getDestination()] = graph[e.getSource()][e.getDestination()];
                        set.add(e.getDestination());
                    }
                }

                int query = sc.nextInt();
                int correct = 0;
                for (int i = 0; i < query; i++) {
                    int s = sc.nextInt();
                    int d = sc.nextInt();

                    if (graph[s][d] > 0 || graph[d][s] > 0)
                        correct++;
                }

                System.out.println(correct + "/" + query);
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

}

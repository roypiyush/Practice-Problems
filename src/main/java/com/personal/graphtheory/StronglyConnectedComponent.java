package com.personal.graphtheory;

import java.util.Comparator;
import java.util.List;


class SortVertex implements Comparator<Vertex> {
    public int compare(Vertex v1, Vertex v2) {
        return v2.getEndTime() - v1.getEndTime();
    }
}

public class StronglyConnectedComponent {

    private int time = 0;

    public static void main(String[] args) {
        String[] adjMatrix1 = {
                "01000000",
                "00101100",
                "00010010",
                "00100001",
                "10000100",
                "00000010",
                "00000101",
                "00000001"};
        stronglyConnectedComponents(adjMatrix1);
    }

    private static void stronglyConnectedComponents(String[] adjMatrix) {
        System.out.println("***** Strongly connected component ******");
        StronglyConnectedComponent scc = new StronglyConnectedComponent();
        Graph graph = new Graph();
        for (int i = 0; i < adjMatrix.length; i++) {
            Vertex vertex = new Vertex();
            vertex.setId(i);
            vertex.setColor(Color.WHITE);
            graph.addVertex(vertex);
        }

        scc.depthFirstSearch(graph, adjMatrix, false);

        scc.transpose(adjMatrix);
        for (int i = 0; i < adjMatrix.length; i++) {
            graph.getV().get(i).setColor(Color.WHITE);
        }

        graph.getV().sort(new SortVertex());
        scc.depthFirstSearch(graph, adjMatrix, true);
    }

    private void depthFirstSearch(Graph graph, String[] adjMatrix, boolean isTranspose) {

        List<Vertex> vertices = graph.getV();
        for (Vertex vertex : vertices) {
            if (vertex.getColor() == Color.WHITE) {
                depthFirstSearchVisit(graph, vertex, adjMatrix, isTranspose);

                if (isTranspose) System.out.println();
            }
        }
    }

    private void depthFirstSearchVisit(Graph graph, Vertex vertex, String[] adjMatrix, boolean isTranspose) {

        time = time + 1;
        vertex.setStartTime(time);
        vertex.setColor(Color.BLACK);

        if (isTranspose)
            System.out.print((char) (vertex.getId() + 97));

        String adjList = adjMatrix[vertex.getId()];

        for (int i = 0; i < adjList.length(); i++) {
            // Check color
            if (adjList.charAt(i) == '1') {
                for (Vertex temp : graph.getV()) {
                    if (temp.getId() == i && temp.getColor() == Color.WHITE) {
                        depthFirstSearchVisit(graph, temp, adjMatrix, isTranspose);
                    }

                }

            }
        }
        time = time + 1;
        vertex.setEndTime(time);
    }

    private void transpose(String[] adjMatrix) {

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = i; j < adjMatrix.length; j++) {
                char c = adjMatrix[i].charAt(j);
                char r = adjMatrix[j].charAt(i);

                StringBuffer buffer = new StringBuffer(adjMatrix[i]);
                buffer.deleteCharAt(j);
                buffer.insert(j, r);
                adjMatrix[i] = buffer.toString();

                buffer = new StringBuffer(adjMatrix[j]);
                buffer.deleteCharAt(i);
                buffer.insert(i, c);
                adjMatrix[j] = buffer.toString();
            }
        }

    }
}

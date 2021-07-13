package com.personal.graphtheory;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class GraphSearch {
    private Map<String, LinkedHashSet<String>> map = new HashMap<>();

    public void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = map.get(node1);
        if (adjacent == null) {
            adjacent = new LinkedHashSet<String>();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    public void addTwoWayVertex(String node1, String node2) {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }

    public boolean isConnected(String node1, String node2) {
        Set<String> adjacent = map.get(node1);
        if (adjacent == null) {
            return false;
        }
        return adjacent.contains(node2);
    }

    public LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null) {
            return new LinkedList<String>();
        }
        return new LinkedList<String>(adjacent);
    }
}

public class Search {

    private static String START;
    private static String END;

    public static void main(String[] args) {
        findRoutes("Bangalore", "Mumbai");
    }

    private static void findRoutes(String source, String destination) {

        START = source;
        END = destination;

        GraphSearch graph = new GraphSearch();
        graph.addEdge("Bangalore", "Mumbai");
        graph.addEdge("Bangalore", "Pune");
        graph.addEdge("Pune", "Mumbai");
        graph.addEdge("Bangalore", "Chennai");
        graph.addEdge("Chennai", "Pune");
        graph.addEdge("Pune", "Bangalore");

        LinkedList<String> visited = new LinkedList<String>();
        visited.add(START);
        System.out.print("[");
        new Search().breadthFirst(graph, visited);
        System.out.print("]\n");
    }

    private void breadthFirst(GraphSearch graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                String result = printPath(visited);
                System.out.print(result);
                System.out.print(", ");
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            breadthFirst(graph, visited);
            visited.removeLast();
        }
    }

    private String printPath(LinkedList<String> visited) {
        int size = visited.size();
        int i = 0;

        String result = "";
        for (String node : visited) {

            result += node;
            if (i != size - 1) {
                result += "->";
            }
            i++;
        }
        return result;
    }
}

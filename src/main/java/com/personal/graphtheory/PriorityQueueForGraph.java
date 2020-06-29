package com.personal.graphtheory;

import java.util.ArrayList;

public class PriorityQueueForGraph {

    private ArrayList<Vertex> vertexs;

    public PriorityQueueForGraph() {
        vertexs = new ArrayList<Vertex>();
    }

    public void add(Vertex v) {
        vertexs.add(v);
        vertexs.trimToSize();
        if (vertexs.size() > 1) {
            // buildMinHeap();
            heapDecreaseKey(vertexs.size(), v);
        }
    }

    public Vertex poll() {
        if (vertexs.size() <= 0)
            throw new RuntimeException("No items to be removed");

        Vertex t = vertexs.remove(0);
        buildMinHeap();
        return t;
    }

    public void buildMinHeap() {
        int size = vertexs.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public void heapDecreaseKey(int i, Vertex v) {
        if (vertexs.size() == i)
            vertexs.add(v);
        else
            vertexs.set(i, v);

        Vertex t = vertexs.get(i);
        while (i > 0 && t.getKey() < vertexs.get(parent(i)).getKey()) {
            vertexs.set(i, vertexs.get(parent(i)));
            vertexs.set(parent(i), t);
            i = parent(i);
            t = vertexs.get(i);
        }
    }

    public Vertex getElementById(int id) {
        for (Vertex vertex : vertexs) {
            if (vertex.getId() == id)
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

    private void minHeapify(int k) {
        int lowest = k;
        int l = left(k);
        int r = right(k);
        int size = vertexs.size();
        if (l < size && vertexs.get(l).getKey() < vertexs.get(k).getKey())
            lowest = l;
        if (r < size && vertexs.get(r).getKey() < vertexs.get(lowest).getKey())
            lowest = r;
        if (lowest != k) {
            Vertex t = vertexs.get(lowest);
            vertexs.set(lowest, vertexs.get(k));
            vertexs.set(k, t);
            minHeapify(lowest);
        }

    }

    public boolean contains(Vertex v) {
        return vertexs.contains(v);
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private int parent(int i) {
        return i >> 1;
    }

    public String toString() {
        return vertexs.toString();
    }

}
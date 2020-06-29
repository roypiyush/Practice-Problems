package com.personal.graphtheory;

import java.util.ArrayList;

class KEdge {
    int s;
    int e;
    int cost;

    public KEdge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + e;
        result = prime * result + s;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vertex))
            return false;
        KEdge other = (KEdge) obj;
        if ((other.e == e && other.s == s) || (other.e == s && other.s == e))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "(" + s + ", " + e + ")";
    }
}

public class Kruskal {

    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 3, 0, 0, 1},
                {3, 0, 5, 0, 4},
                {0, 5, 0, 2, 6},
                {0, 0, 2, 0, 7},
                {1, 4, 6, 7, 0}
        };

        ArrayList<KEdge> edges = new ArrayList<KEdge>();
        for (int i = 0; i < adjMatrix.length - 1; i++) {
            for (int j = i + 1; j < adjMatrix.length; j++) {
                edges.add(new KEdge(i, j, adjMatrix[i][j]));
            }
        }


    }

}

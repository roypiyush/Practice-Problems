/**
 *
 */
package com.personal.keypadproblem;

/**
 * @author piyush
 */
public class Edge {
    private int i;
    private int j;

    public Edge(int i, int j) {
        super();
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Edge)) return false;

        Edge other = (Edge) obj;
        if (i == other.i && j == other.j)
            return true;
        if (j == other.i && i == other.j)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        // For same numbers create same hash code
        // irrespective of order
        return i * j * (Math.max(i, j));
    }

    @Override
    public String toString() {
        return "[i=" + i + ", j=" + j + "]";
    }


}
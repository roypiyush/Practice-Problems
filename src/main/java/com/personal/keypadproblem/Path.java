/**
 *
 */
package com.personal.keypadproblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author piyush
 */
public class Path implements Cloneable {

    private boolean edgeRepeated = false;

    private LinkedList<Integer> path = new LinkedList<>();
    private Set<Edge> edges = new HashSet<>();

    public boolean addPoint(int point) {

        if (path.isEmpty()) {
            return path.add(point);
        }

        int lastPoint = path.getLast();
        if (lastPoint == point)
            return false;


        // Check if edge repeated in path
        Edge edge = new Edge(lastPoint, point);
        if (edges.contains(edge) && edgeRepeated == true) {
            return false; // this is double repetition
        }
        if (edges.contains(edge) && edgeRepeated == false) {
            edgeRepeated = true;
        }

        edges.add(edge);
        return path.add(point);
    }

    public boolean isEdgeRepeated() {
        return edgeRepeated;
    }

    public LinkedList<Integer> getPath() {
        return path;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    /**
     * Length of path
     *
     * @return length
     */
    public int getLength() {
        return path.size() - 1;
    }

    public void retract(int button) {
        int lastPoint = path.getLast();
        if (lastPoint == button)
            path.removeLast();

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
		/*Path path = new Path();
		path.edgeRepeated = edgeRepeated;
		path.edges = (Set<Edge>)new HashSet<>(edges);
		path.path = (LinkedList<Integer>) path.clone();
		return path;*/
    }
}

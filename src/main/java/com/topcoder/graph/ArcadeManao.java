/**
 *
 */
package com.topcoder.graph;

import java.util.LinkedList;

class Point {
    int row = -1;
    int col = -1;
    int color = 0;
}

/**
 * @author piyush
 */
@SuppressWarnings("unused")
public class ArcadeManao {

    /**
     * @param args
     */

    public static void main(String[] args) {

        String[] levels = {"XXXX....",
                "...X.XXX",
                "XXX..X..",
                "......X.",
                "XXXXXXXX"};

        int coinRow = 2;
        int coinColumn = 4;

        int[][] graph = createGraphForLevels(levels, coinRow - 1, coinColumn - 1);

    }

    private static int[][] createGraphForLevels(String[] levels, int row, int column) {

        int[][] adjMatrix = new int[levels.length][levels.length];
        int start = column;

        Point startingPoint = new Point();
        startingPoint.row = row;
        startingPoint.col = column;
        startingPoint.color = 1;

        Point points[] = new Point[levels.length];
        for (int i = 0; i < levels.length; i++) {
            Point point = new Point();
            points[i] = point;
        }


        LinkedList<Point> linkedList = new LinkedList<Point>();
        linkedList.offer(startingPoint);

        // Find distance of the levels reachable from coinRow and subsequent levels
        while (!linkedList.isEmpty()) {
            Point p = linkedList.poll();
            for (int j = 0; j < points.length; j++) {

                if (points[j].row != p.row && p.color == 0) {
                    int col = foundPath(levels, adjMatrix, p, j);
                    if (col != -1) {
                        Point pn = new Point();
                        pn.row = j;
                        pn.col = col;
                        if (pn.col != levels.length - 1)
                            linkedList.offer(pn);
                    }

                }
            }
            p.color = 2;
        }

        return null;
    }

    private static int foundPath(String[] levels, int[][] adjMatrix, Point p, int destination) {

        // Search for acceptable movement
        int leftIndex = p.col - 1;
        int rightIndex = p.col + 1;

        while (leftIndex >= 0 && levels[p.row].charAt(leftIndex - 1) == 'X')
            --leftIndex;

        while (rightIndex < levels[p.row].length() && levels[p.row].charAt(rightIndex + 1) == 'X')
            ++rightIndex;

        int distance = Integer.MAX_VALUE;
        for (int j = leftIndex; j <= rightIndex; j++) {
            if (levels[destination].charAt(j) == 'X') {
                distance = Math.abs(destination - p.row);
                if (adjMatrix[p.row][destination] > distance) {
                    adjMatrix[p.row][destination] = distance;
                    adjMatrix[destination][p.row] = distance;
                } else if (adjMatrix[p.row][destination] == 0) {
                    adjMatrix[p.row][destination] = distance;
                    adjMatrix[destination][p.row] = distance;
                }
                return j;
            }
        }

        return -1;
    }

}

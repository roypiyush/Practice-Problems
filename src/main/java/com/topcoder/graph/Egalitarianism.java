package com.topcoder.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * TopCoder Problem statement
 * ==========================
 *
 * A kingdom has n citizens. Each one has some amount of money, a number of dollars denoted by a non-negative integer.
 * Citizens are numbered from 0 to n-1. Some citizens have friends. Their friendship network is described by a String[]
 * called isFriend, such that if isFriend[i][j] == 'Y', the citizens numbered i and j are friends, and if isFriend[i][j] == 'N',
 * these citizens are not friends.
 *
 * The king decrees the following:
 * Each citizen's amount of money must be within d dollars of the amount of money belonging to any of his friends. In other words,
 * a citizen with x dollars must not have any friends with less than x-d dollars or more than x+d dollars.
 *
 * Given the number of citizens and their friendship network, what is the greatest possible money difference between any two people
 * (not necessarily friends) in this kingdom? If there is a finite answer, return it. Otherwise, return -1.
 */

public class Egalitarianism {

    public static void main(String[] args) {
        String[] isFriend = {"NYYYYYYYYYYYYYYYYYYYNYYY",
                "YNYYYYYYNYYYYYYYYNYNYYYY",
                "YYNYYYYYYYYYYYYYYYYYYYYY",
                "YYYNYYYYYYYYYYYYYYYYYYYY",
                "YYYYNYYYYYYYYYYYYYYYYYYY",
                "YYYYYNYYYYYYYYYYYYYYYYYY",
                "YYYYYYNYNYYYYYYYYYYYYYYY",
                "YYYYYYYNYYYYYYYYYYYYYYYY",
                "YNYYYYNYNYYYYNYYYYYYYYYY",
                "YYYYYYYYYNYYYYYYYYYYYYYY",
                "YYYYYYYYYYNYYYYYYYYYYYNY",
                "YYYYYYYYYYYNYYYYYYYYYYYY",
                "YYYYYYYYYYYYNYYYYYYYYYYY",
                "YYYYYYYYNYYYYNYYYYYYYYYY",
                "YYYYYYYYYYYYYYNYYYYYYYYY",
                "YYYYYYYYYYYYYYYNYYYYYYYY",
                "YYYYYYYYYYYYYYYYNYYYYYYY",
                "YNYYYYYYYYYYYYYYYNYYYYYY",
                "YYYYYYYYYYYYYYYYYYNYYYYY",
                "YNYYYYYYYYYYYYYYYYYNYYYY",
                "NYYYYYYYYYYYYYYYYYYYNYYY",
                "YYYYYYYYYYYYYYYYYYYYYNYY",
                "YYYYYYYYYYNYYYYYYYYYYYNY",
                "YYYYYYYYYYYYYYYYYYYYYYYN"};
        int d = 789;

        System.out.println(new Egalitarianism().maxDifference(isFriend, d));

    }

    int maxDifference(String[] isFriend, int d) {

        int max = -1;
        for (int i = 0; i < isFriend.length; i++) {
            int distance = getMaxDistanceWithSource(isFriend, i);
            if (distance == -1) {
                return distance;
            }
            if (distance > max) {
                max = distance;
            }
        }

        return max * d;
    }

    private int getMaxDistanceWithSource(String[] adjMatrix, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();

        Set<Integer> connected = new HashSet<Integer>();

        int[] colors = new int[adjMatrix.length];
        int[] d = new int[adjMatrix.length];

        queue.add(new Integer(s));
        connected.add(new Integer(s));

        int maxD = 0;
        while (!queue.isEmpty()) {

            int vertex = queue.poll();
            String adjList = adjMatrix[vertex];

            for (int i = 0; i < adjList.length(); i++) {
                if (adjList.charAt(i) == 'Y' && colors[i] == 0 && d[i] == 0) {


                    queue.add(new Integer(i));
                    d[i] = d[vertex] + 1;
                    if (d[i] > maxD)
                        maxD = d[i];
                }
            }
            connected.add(vertex);
            colors[vertex] = 1;
        }

        return connected.size() == adjMatrix.length ? maxD : -1;
    }

}

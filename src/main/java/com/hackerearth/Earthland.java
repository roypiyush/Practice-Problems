package com.hackerearth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Earthland {

    public static void main(String[] args) {

        Scanner sc = null;
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream(System.in);
            sc = new Scanner(br);

            int T = sc.nextInt();

            while (T-- > 0) {
                int numberOfRooms = sc.nextInt();
                int numberOfEdges = sc.nextInt();

                boolean graph[][] = new boolean[numberOfRooms][numberOfRooms];

                for (int i = 0; i < numberOfEdges; i++) {
                    int v1 = sc.nextInt() - 1;
                    int v2 = sc.nextInt() - 1;


                    graph[v1][v2] = true;
                }

                int[] parent = new int[numberOfRooms];
                boolean[] visited = new boolean[numberOfRooms];

                Arrays.fill(parent, -1);
                int count = 0;
                for (int i = 0; i < parent.length; i++) {
                    visited = new boolean[numberOfRooms];
                    if (!checkPath(graph, parent, visited, i)) {
                        count++;
                    }
                }
                System.out.println(count - 1);

            }


        } catch (Exception e) {
            e.printStackTrace();
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


    static boolean checkPath(boolean graph[][], int[] parent, boolean[] visited, int v) {

        boolean[] adjList = graph[v];
        for (int u = 0; u < adjList.length; u++) {
            if (adjList[u]) {
                if (!visited[u]) {
                    visited[u] = true;
                    if (parent[u] < 0 || checkPath(graph, parent, visited, parent[u])) {
                        parent[u] = v;
                        return true;
                    }
                }
            }

        }
        return false;

    }

}

/*
2
9 11
1 2
1 3
1 6
2 8
2 9
6 7
3 4
3 5
3 7
4 5
5 2
6 6
1 2
1 3
3 4
4 5
5 6
2 5
 */

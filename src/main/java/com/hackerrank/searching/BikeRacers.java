package com.hackerrank.searching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


class Vertex {

    private int id;
    private int x;
    private int y;

    public Vertex(int id, int x, int y) {
        super();
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

}


public class BikeRacers {


    /**
     * Do a DFS for specified vertex v
     *
     * @param adjMatrix
     * @param v
     * @param start
     */
    static long findClosestBike(long[][] adjMatrix, Vertex v, HashSet<Integer> ignoreBike, int start, long diff) {

        long min = Long.MAX_VALUE;
        for (int i = start; i < adjMatrix.length; i++) {

            if (ignoreBike.contains(i))
                continue;

            if (adjMatrix[v.getId()][i] > 0) {
                adjMatrix[v.getId()][i] = adjMatrix[v.getId()][i] - diff;

                if (adjMatrix[v.getId()][i] == 0)
                    ignoreBike.add(i);

                if (adjMatrix[v.getId()][i] < min) {
                    min = adjMatrix[v.getId()][i];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            scanner.nextLine();

            int vertexId = 0;
            ArrayList<Vertex> bikers = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Vertex p = new Vertex(vertexId++, x, y);
                bikers.add(p);
                scanner.nextLine();
            }

            // Start of vertexId for Bikes
            int start = vertexId;
            ArrayList<Vertex> bikes = new ArrayList<>(M);
            for (int i = 0; i < M; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Vertex p = new Vertex(vertexId++, x, y);
                bikes.add(p);
            }

            long[][] adjMatrix = new long[N + M][N + M];
            for (int i = 0; i < start; i++) {
                for (int j = start; j < adjMatrix.length; j++) {
                    Vertex biker = bikers.get(i);
                    Vertex bike = bikes.get(j - start);

                    int X = biker.getX() - bike.getX();
                    int Y = biker.getY() - bike.getY();

                    adjMatrix[i][j] = X * X + Y * Y;

                }
            }

            long sum = 0;
            HashSet<Integer> ignoreBiker = new HashSet<>();
            HashSet<Integer> ignoreBike = new HashSet<>();

            long nearest = 0;
            for (int k = 0; k < K; k++) {

                long min = Long.MAX_VALUE;
                for (int i = 0; i < bikers.size(); i++) {

                    if (ignoreBiker.contains(i))
                        continue;

                    long distance = findClosestBike(adjMatrix, bikers.get(i), ignoreBike, start, nearest);

                    if (distance < min) {
                        if (distance == 0)
                            ignoreBiker.add(bikers.get(i).getId());
                        else
                            min = distance;
                    }
                }
                nearest = min;
                sum += min;

            }

            System.out.println(sum);

        } catch (Exception e) {
        } finally {
            if (scanner != null)
                scanner.close();
        }

    }

}

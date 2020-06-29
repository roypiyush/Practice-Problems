package com.personal.backtracking;


enum Direction {
    RIGHT,
    LEFT,
    UP,
    DOWN;
}

class Point {
    private int x;
    private int y;
    private Point child;
    private int distance = Integer.MAX_VALUE;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Point getChild() {
        return child;
    }

    public void setChild(Point child) {
        this.child = child;
    }
}


public class MazeMain {

    public static void main(String[] args) {

        // SAMPLE PROVIDED IN PROBLEM STATEMENT
        int row = 5, column = 5;
        int[][] maze = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1}
        };

        // ANOTHER TEST CASE
//		int row = 6, column = 8;
//		int[][] maze = {
//				{1, 0, 1, 1, 1, 1, 1},
//				{1, 0, 1, 0, 0, 0, 0},
//				{1, 0, 0, 0, 1, 1, 0},
//				{1, 0, 1, 1, 0, 1, 0},
//				{0, 1, 1, 1, 0, 0, 0}
//			};


        MazeMain main = new MazeMain();

        int sx = 0;
        int sy = 1;
        int dx = 2;
        int dy = 3;

        Point path = main.findPath(maze, sx, sy, dx, dy, row, column);
        Point p = path;
        String mazepoint = "";
        while (p != null) {
            mazepoint += p.getX() + "," + p.getY() + "; ";
            if (p.getChild() == null) {
                System.out.print(p.getX() == dx && p.getY() == dy ? mazepoint : "No path exists.");
            }

            p = p.getChild();
        }

    }

    Point findPath(int[][] maze, int sx, int sy, int dx, int dy, int row, int column) {
        int[][] auxMaze = new int[row][column];

        return move(maze, sx, sy, dx, dy, 0, null, auxMaze);
    }

    Point move(int[][] maze, int sx, int sy, int dx, int dy, int distance, Direction fromDirection, int[][] auxMaze) {

        Point p = new Point(sx, sy);
        p.setDistance(distance);

        // Found destination
        if (sx == dx && sy == dy) {
            return p;
        }

        Point r = null;
        Point l = null;
        Point d = null;
        Point u = null;

        // Right
        int right = Integer.MAX_VALUE;
        if (sy + 1 < maze[sx].length && maze[sx][sy + 1] == 0 && (fromDirection == null || fromDirection != Direction.LEFT)) {

            if (auxMaze[sx][sy + 1] == 0 || auxMaze[sx][sy + 1] > distance + 1) {

                auxMaze[sx][sy + 1] = distance + 1;
                r = move(maze, sx, sy + 1, dx, dy, distance + 1, Direction.RIGHT, auxMaze);
                right = r.getDistance();

            }

        }

        // Left
        int left = Integer.MAX_VALUE;
        if (sy - 1 >= 0 && maze[sx][sy - 1] == 0 && (fromDirection == null || fromDirection != Direction.RIGHT)) {

            if (auxMaze[sx][sy - 1] == 0 || auxMaze[sx][sy - 1] > distance + 1) {

                auxMaze[sx][sy - 1] = distance + 1;
                l = move(maze, sx, sy - 1, dx, dy, distance + 1, Direction.LEFT, auxMaze);
                left = l.getDistance();
            }
        }

        // Down
        int down = Integer.MAX_VALUE;
        if (sx + 1 < maze.length && maze[sx + 1][sy] == 0 && (fromDirection == null || fromDirection != Direction.UP)) {

            if (auxMaze[sx + 1][sy] == 0 || auxMaze[sx + 1][sy] > distance + 1) {

                auxMaze[sx + 1][sy] = distance + 1;
                d = move(maze, sx + 1, sy, dx, dy, distance + 1, Direction.DOWN, auxMaze);
                down = d.getDistance();
            }
        }

        // Up
        int up = Integer.MAX_VALUE;
        if (sx - 1 >= 0 && maze[sx - 1][sy] == 0 && (fromDirection == null || fromDirection != Direction.DOWN)) {

            if (auxMaze[sx - 1][sy] == 0 || auxMaze[sx - 1][sy] > distance + 1) {


                auxMaze[sx - 1][sy] = distance + 1;
                u = move(maze, sx - 1, sy, dx, dy, distance + 1, Direction.UP, auxMaze);
                up = u.getDistance();
            }
        }

        int dist = Integer.MAX_VALUE;
        if (right < dist) {
            dist = right;
            p.setChild(r);
        }
        if (left < dist) {
            dist = left;
            p.setChild(l);
        }
        if (down < dist) {
            dist = down;
            p.setChild(d);
        }
        if (up < dist) {
            dist = up;
            p.setChild(u);
        }

        return p;
    }
}

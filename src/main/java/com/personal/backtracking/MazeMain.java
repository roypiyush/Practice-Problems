package com.personal.backtracking;

import java.util.ArrayList;
import java.util.List;


enum Direction {
	RIGHT,
	LEFT,
	UP,
	DOWN;
}

class Point {
	private int x; 
	private int y;
	
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
	
	
}



public class MazeMain {

	int move(int[][] maze, int sx, int sy, int dx, int dy, int distance, Direction fromDirection, List<Point> path) {
		
		// Found destination
		if(sx == dx && sy == dy) {
			return distance;
		}
		
		// Right
		int right = Integer.MAX_VALUE;
		if(sy + 1 < maze[sx].length && maze[sx][sy + 1] == 0 && (fromDirection == null || fromDirection != Direction.LEFT)) {
			right = move(maze, sx, sy + 1, dx, dy, distance + 1, Direction.RIGHT, path);
		}
		
		// Left
		int left = Integer.MAX_VALUE;
		if(sy - 1 >= 0 && maze[sx][sy - 1] == 0 && (fromDirection == null || fromDirection != Direction.RIGHT)) {
			left = move(maze, sx, sy - 1, dx, dy, distance + 1, Direction.LEFT, path);
		}
		
		// Down
		int down = Integer.MAX_VALUE;
		if(sx + 1 < maze.length && maze[sx + 1][sy] == 0 && (fromDirection == null || fromDirection != Direction.UP)) {
			down = move(maze, sx + 1, sy, dx, dy, distance + 1, Direction.DOWN, path);
		}
		
		// Up
		int up = Integer.MAX_VALUE;
		if(sx - 1 >= 0 && maze[sx - 1][sy] == 0 && (fromDirection == null || fromDirection != Direction.DOWN)) {
			up = move(maze, sx - 1, sy, dx, dy, distance + 1, Direction.UP, path);
		}
		
		Direction direction = null;
		int d = Integer.MAX_VALUE;
		if(right < left) {
			direction = Direction.RIGHT;
			d = right;
		}
		else if(left < right){
			direction = Direction.LEFT;
			d = left;
		}
		if(down < d) {
			direction = Direction.DOWN;
			d = down;
		}
		
		if(up < d) {
			direction = Direction.UP;
			d = up;
		}
		
		
		tracePath(sx, sy, direction, path);
		
		return d;
	}
	
	
	private void tracePath(int sx, int sy, Direction direction, List<Point> path) {
		if(direction == null)
			return;
		
		switch (direction) {
		case RIGHT:
			path.add(new Point(sx, sy + 1));
			break;
		case LEFT:
			path.add(new Point(sx, sy - 1));
			break;
		case DOWN:
			path.add(new Point(sx + 1, sy));
			break;
		case UP:
			path.add(new Point(sx - 1, sy));
			break;
		
		}
		

	}
	
	public static void main(String[] args) {
		
		int[][] maze = {
					{1, 0, 1, 1, 1},
					{1, 0, 1, 0, 0},
					{1, 0, 0, 0, 1},
					{1, 0, 1, 1, 1},
					{0, 1, 1, 1, 1}
				};
		
		MazeMain main = new MazeMain();
		
		int sx = 0;	int sy = 1;
		int dx = 2;	int dy = 3;
		
		List<Point> path = new ArrayList<Point>();
		main.move(maze, sx, sy, dx, dy, 0, null, path);
		if(path.isEmpty()) {
			System.out.println("No path exists.");
		}
		else {
			
			String printFormat = "%d, %d; ";
			
			System.out.printf(printFormat, sx, sy);
			for (int i = path.size() - 1; i >= 0; i--) {
				Point point = path.get(i);
				System.out.printf(printFormat, point.getX(), point.getY());
			}
		}

	}

}

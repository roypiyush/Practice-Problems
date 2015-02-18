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

	Point move(int[][] maze, int sx, int sy, int dx, int dy, int distance, Direction fromDirection) {
		
		Point p = new Point(sx, sy);
		p.setDistance(distance);
		
		// Found destination
		if(sx == dx && sy == dy) {
			return p;
		}
		
		Point r = null;
		Point l = null;
		Point d = null;
		Point u = null;
		
		// Right
		int right = Integer.MAX_VALUE;
		if(sy + 1 < maze[sx].length && maze[sx][sy + 1] == 0 && (fromDirection == null || fromDirection != Direction.LEFT)) {
			r = move(maze, sx, sy + 1, dx, dy, distance + 1, Direction.RIGHT);
			right = r.getDistance();
		}
		
		// Left
		int left = Integer.MAX_VALUE;
		if(sy - 1 >= 0 && maze[sx][sy - 1] == 0 && (fromDirection == null || fromDirection != Direction.RIGHT)) {
			l = move(maze, sx, sy - 1, dx, dy, distance + 1, Direction.LEFT);
			left = l.getDistance();
		}
		
		// Down
		int down = Integer.MAX_VALUE;
		if(sx + 1 < maze.length && maze[sx + 1][sy] == 0 && (fromDirection == null || fromDirection != Direction.UP)) {
			d = move(maze, sx + 1, sy, dx, dy, distance + 1, Direction.DOWN);
			down = d.getDistance();
		}
		
		// Up
		int up = Integer.MAX_VALUE;
		if(sx - 1 >= 0 && maze[sx - 1][sy] == 0 && (fromDirection == null || fromDirection != Direction.DOWN)) {
			u = move(maze, sx - 1, sy, dx, dy, distance + 1, Direction.UP);
			up = u.getDistance();
		}
		
		int dist = Integer.MAX_VALUE;
		if(right < left) {
			dist = right;
			p.setChild(r);
		}
		else if(left < right){
			dist = left;
			p.setChild(l);
		}
		if(down < dist) {
			dist = down;
			p.setChild(d);
		}
		if(up < dist) {
			dist = up;
			p.setChild(u);
		}
		
		return p;
	}
	
	
	public static void main(String[] args) {
		
//		int[][] maze = {
//					{1, 0, 1, 1, 1},
//					{1, 0, 1, 0, 0},
//					{1, 0, 0, 0, 1},
//					{1, 0, 1, 1, 1},
//					{0, 1, 1, 1, 1}
//				};
		
		int[][] maze = {
				{1, 0, 1, 1, 1},
				{1, 0, 1, 0, 0},
				{1, 0, 0, 0, 1},
				{1, 0, 1, 0, 1},
				{0, 0, 0, 0, 1}
			};
		
		MazeMain main = new MazeMain();
		
		int sx = 0;	int sy = 1;
		int dx = 2;	int dy = 3;
		
		Point path = main.move(maze, sx, sy, dx, dy, 0, null);
		Point p = path;
		while(p != null) {
			System.out.print(p.getX() + "," + p.getY() + "; ");
			p = p.getChild();
		}

	}
}

package com.hackerrank.searching;
import java.util.HashMap;
import java.util.Scanner;

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

	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

class BikerBikeInfo implements Comparable<BikerBikeInfo>{
	private Point biker;
	private Point bike;
	private int distance;
	
	public BikerBikeInfo(Point biker, Point bike) {
		super();
		this.biker = biker;
		this.bike = bike;
		int disX = biker.getX() - bike.getX();
		int disY = biker.getY() - bike.getY();
		distance = (disX * disX) + (disY * disY);
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(BikerBikeInfo o) {
		if(distance == o.getDistance()) {
			
		}
		return distance - o.getDistance();
	}
	
}

public class BikeRacers {
	
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int K = scanner.nextInt();
			scanner.nextLine();
			
			HashMap<Integer, Point> bikers = new HashMap<Integer, Point>(N);
			for (int i = 0; i < N; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				Point p = new Point(x, y);
				bikers.put(i, p);
				scanner.nextLine();
			}
			
			HashMap<Integer, Point> bikes = new HashMap<Integer, Point>(N);
			for (int i = 0; i < M; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				Point p = new Point(x, y);
				bikes.put(i, p);
				scanner.nextLine();
			}
           
//			System.out.println(result == 0 ? "impossible" : result);
			
		} catch (Exception e) {
		} finally {
			if(scanner != null)
				scanner.close();
		}

	}

}

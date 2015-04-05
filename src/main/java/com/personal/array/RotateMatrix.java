package com.personal.array;

public class RotateMatrix {

	public void rotateMatrix(int[][] a) {
		
		int midx = a.length >> 1; int midy = a.length >> 1;
		
		int ringIndex = 0;
		rotateRing(a, midx, midy, ringIndex);
	}
	
	private void rotateRing(int[][] a, int midx, int midy, int ringIndex) {
		
		int indexAvailable = a.length - 1; 
		int rotatingIndex = indexAvailable - ringIndex;
		
		for(int i = 0; i < a.length; i++) {
			
			int temp = a[midx + rotatingIndex][midy + i];
			a[midx][midy + i] = a[midx + i][midy + rotatingIndex];
			a[midx + i][midy + rotatingIndex] = a[midx - rotatingIndex][midy + rotatingIndex + indexAvailable - i];
			a[midx - rotatingIndex][midy + rotatingIndex + indexAvailable - i] = a[midx - rotatingIndex][midy + rotatingIndex];
			a[midx + rotatingIndex][midy + rotatingIndex] = temp;
		}
		
	}

	public static void main(String[] args) {
//		int[][] A = {
//				{1,2,3},
//			    {4,5,6},
//			    {7,8,9}
//			    };
		
		

	}

}

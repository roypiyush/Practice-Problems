#!/usr/bin/env python3

import sys;

def min(a, b):
	return a if a > b else b;

def minCost(arr, m, n):
	if(m < 0 || n < 0):
		return sys.maxsize;
	if(m == 0 || n == 0):
		return arr[m][n];

	min = sys.maxsize;
	arr[m][n] = min(arr[m-1][n-1], min(arr[m-1][n],  min(arr[m][n-1]     )    )



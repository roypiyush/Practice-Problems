#!/usr/bin/env python3

# -*- coding: utf-8 -*-
"""
Created on Sat Jan 14 20:08:02 2017

@author: piyush
"""
import math

def maxi(a, b):
    return a if a > b else b

def maximize(B, i, p, N):
	if(i == N):
		return 0;

	m = 0
	for k in range(1, B[i] + 1):
		m = maxi(m, math.fabs(k-p) + maximize(B, i + 1, k, N))

	return m;

B = [10, 1, 10, 1, 10]

max = 0
for j in range(1, B[0] + 1):
    max = maxi(max, maximize(B, 1, j, 5))
print max
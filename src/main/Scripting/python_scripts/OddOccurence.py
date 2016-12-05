#!/usr/bin/env python3

def oddOccurence(arr):
	result = arr[0];
	for i in range(1, len(arr)):
		result = result ^ arr[i];

	print "Number occuring odd times " + str(result);

A = [2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2];
oddOccurence(A);
#!/usr/bin/env python3

def isCircle(arr):
	
	first = 0; last = 0;
	str1 = ""; str2 = "";
	for i in range(0, len(arr)):
		string = arr[i]
		strlen = len(string);
		##if(ord(string[0]) == ord(string[strlen - 1])):
		##	str1 = str1.join(string[0]);
		##	str2 = str2.join(string[strlen - 1]);
		##else:
		first = first + ord(string[0]);
		last  = last  + ord(string[strlen - 1]);

	#if(str1 == str2)
	return 1 if (first - last) == 0  else 0;


arr = ["ijk", "kji", "abc", "cba"]

if(isCircle(arr) == 1):
	print "Yes"
else:
	print "No"
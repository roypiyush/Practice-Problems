#!/usr/bin/env python3

def hasTwoCandidates(arr, size, sum):
    arr = sorted(arr);
    print arr;
    i = 0; j = size - 1;
    while (i < j) :
        if(arr[i] + arr[j] < sum):
             i = i + 1
        elif (arr[i] + arr[j] > sum):
            j = j - 1
        else :
            return i, j;
            
    return -1, -1;
    
A = [1, 4, 45, 6, 10, -8];
sum = 16
i, j = hasTwoCandidates(A, len(A), sum);
if(i != -1):
    print (str(A[i]) + ' ' + str(A[j]));
else:
    print("No such candidates found.");
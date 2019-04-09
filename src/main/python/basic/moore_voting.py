#!/usr/bin/env python3


def find_candidate(arr):
    majority, count = 0, 1
    for i in range(1, len(arr)):
        if arr[i] == arr[majority]:
            count = count + 1
        else:
            count = count - 1
        
        if count == 0:
            majority = i
            count = 1
        
    return majority
    
        
def check_majority(arr, index):
    count = 0
    for i in range(0, len(arr)):
        if arr[index] == arr[i]:
            count = count + 1
            
    if count > len(arr)/2:
        return index
    else:
        return -1


def moore_algorithm(arr):
    pm = find_candidate(arr)
    m = check_majority(arr, pm)
    if m == -1:
        n = check_majority(arr, 1)
        if n != -1:
            print ("Majority Element is " + str(arr[n]))
        else:
            print ("No majority element found.")
    else:
        print ("Majority Element is " + str(arr[m]))
    
    
A = [1, 3, 3, 3, 3, 1, 1]
moore_algorithm(A)

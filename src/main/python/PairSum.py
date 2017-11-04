#!/usr/bin/env python3


def has_two_candidates(arr, size, summation):
    arr = sorted(arr)
    print (arr)
    i = 0
    j = size - 1
    while i < j:
        if arr[i] + arr[j] < summation:
             i = i + 1
        elif arr[i] + arr[j] > summation:
            j = j - 1
        else:
            return i, j
            
    return -1, -1


if __name__ == '__main__':
    A = [1, 4, 45, 6, 10, -8]
    summ = 16
    ii, jj = has_two_candidates(A, len(A), summ)
    if ii != -1:
        print (str(A[ii]) + ' ' + str(A[jj]))
    else:
        print("No such candidates found.")

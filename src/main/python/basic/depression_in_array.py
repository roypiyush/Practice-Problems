#!/usr/bin/python


def find_depression(arr, i, j):

    if arr[i] == arr[j]:
        return i

    while i < j:
        mid = (i + j) >> 1

        if arr[mid - 1] > arr[mid] <= arr[mid + 1]:
            return mid

        if arr[i] <= arr[mid]:
            i = mid
        else:
            j = mid

    return -1


if __name__ == '__main__':
    array = [10, 9, 8, 7, 11, 12, 13]
    print ("Lowest element : %d" % find_depression(array, 0, len(array) - 1))

#!/usr/bin/env python


import random


def number_generator(size):
    for i in range(1, size):
        yield i * random.randint(1, 100)


def binary_search(array, i, j, key):
    print ("Binary Search >>> Looking for key: %s" % key)

    while i <= j:
        mid = (i + j) / 2

        if array[mid] == key:
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1
    print ("Element Not Found")
    return -1


def upper_bound(array, i, j, key):
    while i <= j:
        mid = (i + j) / 2

        if key < array[mid] and (mid == 0 or array[mid - 1] <= key):
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1

    return -1


def upper_bound_util(array, i, j, key):
    print ("Binary Search Verify Upper Bound >>> Looking for key: %s" % key)
    index = upper_bound(array, i, j, key)
    index_next = upper_bound(array, i, j, array[index] + 1)
    print ("Binary Search Verify Upper Bound >>> Result: %s at index: %s" % (array[index_next - 1], index_next - 1))
    return index_next - 1


def lower_bound(array, i, j, key):
    print ("Binary Search Lower Bound >>> Looking for key: %s" % key)
    while i <= j:
        mid = (i + j) / 2

        if array[mid] < key and (mid == (len(array) - 1) or array[mid + 1] >= key):
            print ("Found Lower Bound Element %s" % array[mid])
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1

    return -1


if __name__ == '__main__':
    array1 = sorted(number_generator(10))
    print ("Array >>> %s" % array1)
    binary_search(array1, 0, len(array1) - 1, random.randint(1, 100))
    upper_bound_util(array1, 0, len(array1) - 1, random.randint(1, 100))
    lower_bound(array1, 0, len(array1) - 1, random.randint(1, 100))

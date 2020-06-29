#!/usr/bin/env python


import random


def number_generator(size):
    for i in range(1, size):
        yield i * random.randint(1, 100)


def binary_search(array, i, j, key):

    while i <= j:
        mid = (i + j) / 2

        if array[mid] == key:
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1
    return -1


def upper_bound(array, i, j, key):
    while i <= j:
        mid = (i + j) / 2

        if key < array[mid] and (mid == i or array[mid - 1] <= key):
            return mid
        elif key >= array[mid]:
            i = mid + 1
        else:
            j = mid - 1

    return -1


def lower_bound(array, i, j, key):
    while i <= j:
        mid = (i + j) / 2

        if array[mid] <= key and (mid == j or array[mid + 1] >= key):
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1

    return -1


if __name__ == '__main__':
    array1 = [27, 54, 60, 88, 148, 150, 207, 484, 576, 584, 616, 630] # sorted(number_generator(10))
    print ("Array >>> %s" % array1)
    k = 3330 # random.randint(1, 100)
    print ("Searching for Key: %s" % k)
    if binary_search(array1, 0, len(array1) - 1, k) == -1:
        ub = upper_bound(array1, 0, len(array1) - 1, k)
        lb = lower_bound(array1, 0, len(array1) - 1, k)
        print ("Element is NOT found. Lower Bound=%s and Upper Bound=%s" % (array1[lb], array1[ub]))
    else:
        print ("Element is found. Upper bound=%s" % array1[upper_bound(array1, 0, len(array1) - 1, k)])

    i, j = 2, 7,
    lb_index, ub_index = lower_bound(array1, i, j, 616), upper_bound(array1, i, j, 616)
    print ("Lower and Upper bound between indices i=%d and j=%d is %s, %s and %s, %s respectively." % (i, j, lb_index, array1[lb_index], ub_index, array1[ub_index]))

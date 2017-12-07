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
    print ("Binary Search Upper Bound >>> Looking for key: %s" % key)
    while i <= j:
        mid = (i + j) / 2

        if mid == 0 or (array[mid - 1] < key <= array[mid]):
            while mid + 1 < len(array) and array[mid] == array[mid + 1]:
                mid = mid + 1
            print ("Found Upper Bound Element %s" % array[mid])
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1

    return -1


def lower_bound(array, i, j, key):
    print ("Binary Search Lower Bound >>> Looking for key: %s" % key)
    while i <= j:
        mid = (i + j) / 2

        if mid == len(array) - 1 or (array[mid] <= key < array[mid + 1]):
            print ("Found Lower Bound Element %s" % array[mid])
            return mid
        elif key > array[mid]:
            i = mid + 1
        else:
            j = mid - 1

    return -1


if __name__ == '__main__':
    array1 = [9, 46, 93, 144, 189, 275, 368, 390, 459] # sorted(number_generator(10))
    print ("Array >>> %s" % array1)
    binary_search(array1, 0, len(array1) - 1, random.randint(1, 100))
    upper_bound(array1, 0, len(array1) - 1, random.randint(1, 100))
    lower_bound(array1, 0, len(array1) - 1, random.randint(1, 100))

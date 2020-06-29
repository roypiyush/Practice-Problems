#!/usr/bin/python
import random
from basic import binary_search_variants as bsv


def ubound(arr, i, j, key):
    index = bsv.upper_bound(arr, i, j, key)
    return j if index == -1 else index


def lbound(arr, i, j, key):
    index = bsv.lower_bound(arr, i, j, key)
    return i if index == -1 else index


def median(arr, i, j):
    m = (i + j) / 2
    if (j - i + 1) % 2 == 0:
        return m, m + 1, (arr[m] + arr[m+1] + 0.0) / 2
    else:
        return m, m, arr[m]


def number_generator(size):
    for i in range(1, size):
        yield i * random.randint(1, 100)


def median_of_non_overlapping_arrays(arr1, s1, e1, arr2, s2, is_odd):
    if is_odd:
        median_index = int((len(arr1) + len(arr2)) / 2)
        offset = median_index - (s1 + s2)
        if s1 + offset > e1:
            return arr2[s2 + offset - (e1 - s1 + 1)]
        else:
            return arr1[s1 + offset]
    else:
        i = int((len(arr1) + len(arr2)) / 2) - 1
        j = i + 1
        offset_i = i - (s1 + s2)
        if s1 + offset_i > e1:
            x = arr2[s2 + offset_i - (e1 - s1 + 1)]
        else:
            x = arr1[s1 + offset_i]

        offset_j = j - (s1 + s2)

        if s1 + offset_j > e1:
            y = arr2[s2 + offset_j - (e1 - s1 + 1)]
        else:
            y = arr1[s1 + offset_j]

        return (x + y) / 2


def find_median_element(arr1, s1, arr2, s2):
    median_index = (len(arr1) + len(arr2) - 2) / 2
    i = s1 + s2
    left, right = 0, 0
    # TODO Need to handle index overflow
    while i < median_index:
        if arr1[s1] <= arr2[s2]:
            s1 = s1 + 1
        else:
            s2 = s2 + 1
        i = i + 1
    if arr1[s1] <= arr2[s2]:
        left = arr1[s1]
        s1 = s1 + 1
    else:
        left = arr2[s2]
        s2 = s2 + 1
    if (len(arr1) + len(arr2)) % 2 == 0:
        if arr1[s1] <= arr2[s2]:
            right = arr1[s1]
        else:
            right = arr2[s2]
    return (left + right + 0.0) / 2


def median_of_arrays(arr1, i1, j1, arr2, i2, j2):
    """
    Find median of two arrays

    :param arr1: First Array
    :param i1: Start index of arr1
    :param j1: End index of arr1
    :param arr2: Second Array
    :param i2: Start index of arr2
    :param j2: End index of arr2
    :return: Median of two arrays
    """
    x1, y1, m1 = median(arr1, i1, j1)
    x2, y2, m2 = median(arr2, i2, j2)
    if m1 == m2:
        return m1
    elif j1 - i1 + 1 == 1 and j2 - i2 + 1 == 1:
        return find_median_element(arr1, x1, arr2, x2)
    elif j1 - i1 + 1 == 1 and j2 - i2 + 1 == 2:
        return find_median_element(arr1, x1, arr2, x2)
    elif j1 - i1 + 1 == 2 and j2 - i2 + 1 == 1:
        return find_median_element(arr1, x1, arr2, x2)
    elif j1 - i1 + 1 == 2 and j2 - i2 + 1 == 2:
        return find_median_element(arr1, x1, arr2, x2)
    else:
        i1 = lbound(arr1, i1, x1, m2)
        j1 = ubound(arr1, y1, j1, m2)
        i2 = lbound(arr2, i2, x2, m1)
        j2 = ubound(arr2, y2, j2, m1)
        return median_of_arrays(arr1, i1, j1, arr2, i2, j2)


def __main__():
    array1_size, array2_size = 12, 6

    # array1 = [12, 42, 85, 219, 300, 406, 495, 570, 588, 666, 776, 890]
    # array2 = [51, 56, 69, 172, 180, 205]
    array1 = sorted(number_generator(array1_size + 1))
    array2 = sorted(number_generator(array2_size + 1))

    print ("Array 1 >>> %s" % array1)
    print ("Array 2 >>> %s" % array2)
    array3 = sorted(array1 + array2)
    print ("Merged Array >>> %s" % array3)

    expected_median = median(array3, 0, len(array3) - 1)
    result = median_of_arrays(array1, 0, len(array1) - 1, array2, 0, len(array2) - 1)
    print ("\nMedian of two sorted arrays : %s" % result)
    print ("Expected Median of two sorted arrays : %s" % expected_median[2])


if __name__ == '__main__':
    __main__()

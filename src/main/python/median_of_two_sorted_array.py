#!/usr/bin/python


import random
import binary_search_variants as bsv


def median(arr, i, j):
    if j - i < 0:
        raise RuntimeError('Index underflow error')
    if (j - i + 1) % 2 == 0:
        mid = int((i + j) / 2)
        return float(arr[mid] + arr[mid + 1]) / 2

    mid = int((i + j) / 2)
    return arr[mid]


def number_generator(size):
    for i in range(1, size):
        yield i * random.randint(1, 100)


def median_of_two_sorted_array(arr1, s1, e1, arr2, s2, e2):
    m1 = median(arr1, s1, e1)
    m2 = median(arr2, s2, e2)
    if m1 < m2:
        return median_of_arrays(arr1, s1, e1, arr2, s2, e2)
    elif m2 < m1:
        return median_of_arrays(arr2, s2, e2, arr1, s1, e1)
    else:
        return m1


def median_of_arrays(arr1, s1, e1, arr2, s2, e2):
    """
    Here it is assumed that first array is medianly lower than second array

    :param arr1: First Array
    :param s1: Start index of arr1
    :param e1: End index of arr1
    :param arr2: Second Array
    :param s2: Start index of arr2
    :param e2: End index of arr2
    :return: Median of two arrays
    """

    total_size = e1 - s1 + 1 + e2 - s2 + 1
    is_odd = total_size % 2 == 1

    m1 = median(arr1, s1, e1)
    m2 = median(arr2, s2, e2)

    lb = bsv.lower_bound(arr1, s1, e1, m2)
    ub = bsv.upper_bound(arr2, s2, e2, m1)
    if lb == e1 and m2 != lb and ub == s2 and m1 != ub:
        # There is no overlapping
        if is_odd:
            element = total_size / 2
            return arr1[element] if element <= e1 else arr2[element - (e1 + 1)]
        else:
            first = total_size / 2 - 1
            second = total_size / 2

            element1 = arr1[first] if first <= e1 else arr2[first - (e1 + 1)]
            element2 = arr1[second] if second <= e1 else arr2[second - (e2 + 1)]
            return (element1 + element2) / 2
        pass
    else:

        number_of_left_elements = lb + ub
        number_of_right_elements = e1 - lb + e2 - ub
        if is_odd:
            if number_of_left_elements > number_of_right_elements:
                return min(arr1[lb], arr2[ub])
            else:
                return max(arr1[lb], arr2[ub])
        else:
            return (arr1[lb] + arr2[ub]) / 2


def __main__():
    array1_size, array2_size = 5, 6

    array1 = [55, 142, 285, 300, 340]  # sorted(number_generator(array1_size + 1))
    array2 = [11, 18, 120, 150, 260, 288]  # sorted(number_generator(array2_size + 1))

    print ("Array 1 >>> %s" % array1)
    print ("Array 2 >>> %s" % array2)

    array3 = sorted(array1 + array2)
    expected_median = median(array3, 0, len(array3) - 1)
    result = median_of_two_sorted_array(array1, 0, len(array1) - 1, array2, 0, len(array2) - 1)
    print ("\nMedian of two sorted arrays : %s" % result)
    print ("Expected Median of two sorted arrays : %s" % expected_median)
    print (array3)


if __name__ == '__main__':
    __main__()

#!/usr/bin/python


def alternate_positive_negative(array):
    """
    O(n) time O(1) space

    :param array:
    """
    size = len(array)
    if size <= 1:
        return 
    pivot = 0
    i = -1
    j = 0
    while j < size:
        if array[j] < pivot:
            i = i + 2
            array[i], array[j] = array[j], array[i]
        j = j + 2

    i = -2
    j = 1
    while j < size:
        if array[j] > pivot:
            i = i + 2
            array[i], array[j] = array[j], array[i]
        j = j + 2


def simple(array):
    """
    O(n^2) time O(1) space
    :param array:
    """
    size = len(array)
    for i in range(0, size):
        for j in range(i + 1, size):
            if i % 2 == 0 and array[i] < 0 < array[j]:
                array[i], array[j] = array[j], array[i]
                break
            if i % 2 == 1 and array[j] < 0 < array[i]:
                array[i], array[j] = array[j], array[i]
                break


if __name__ == '__main__':
    input_array = [-1, 2, -3, 4, 5, 6, -7, 8, 9]
    alternate_positive_negative(input_array)
    print(input_array)

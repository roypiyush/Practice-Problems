#!/usr/bin/python


def segregate(array):
    pivot = 0
    i = -1
    for j in range (0, len(array)):
        if array[j] <= pivot:
            array[i + 1], array[j] = array[j], array[i + 1]
            i = i + 1


def segregate_using_two_pointers(array):
    zero_pointer = -1
    one_pointer = len(array)
    i = 0
    while i < one_pointer:
        if array[i] == 0:
            zero_pointer = zero_pointer + 1
            array[i], array[zero_pointer] = array[zero_pointer], array[i]
        elif array[i] == 1:
            one_pointer = one_pointer - 1
            array[i], array[one_pointer] = array[one_pointer], array[i]
        i = i + 1


if __name__ == '__main__':
    input_array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
    segregate(input_array)
    print(input_array)
    input_array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
    segregate_using_two_pointers(input_array)

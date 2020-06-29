#!/usr/bin/python


def counting_sort(array, max_value):
    result_array = [0] * (len(array) + 1)
    temp_array = [0] * (max_value + 1)
    for i in range(0, len(array)):
        temp_array[array[i]] = temp_array[array[i]] + 1

    for i in range(0, max_value):
        temp_array[i + 1] = temp_array[i + 1] + temp_array[i]

    for i in range(len(array) - 1, -1, -1):
        result_array[temp_array[array[i]]] = array[i]
        temp_array[array[i]] = temp_array[array[i]] - 1

    return result_array


if __name__ == '__main__':
    import sys
    input_array = [2, 9, 7, 7, 1, 1, 4, 3, 8, 9]
    result = counting_sort(input_array, 9)
    print(result)
    print('Sizeof {} {}'.format(sys.getsizeof(result), sys.getsizeof(input_array)))

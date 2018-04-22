#!/usr/bin/python


def max_sum_array_rotation(array):
    total_sum = 0
    multi_sum = 0
    size = len(array)
    for i in range(0, size):
        total_sum = total_sum + array[i]
        multi_sum = multi_sum + array[i] * i

    max_result = multi_sum
    for i in range(1, size):
        multi_sum = multi_sum + total_sum - size * array[size - i]
        max_result = max(max_result, multi_sum)
    return max_result


if __name__ == '__main__':
    input_array = [10, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    print(max_sum_array_rotation(input_array))

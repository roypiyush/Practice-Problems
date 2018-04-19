#!/usr/bin/python


def interpolation_search(array, key):
    print("Searching key {}".format(key))
    low = 0
    high = len(array) - 1

    while low <= high and array[low] <= key <= array[high]:
        pos = low + int(((high - low) / (array[high] - array[low])) * (key - array[low]))

        if array[pos] == key:
            return pos
        elif key > array[pos]:
            low = pos + 1
        else:
            high = pos - 1
    return -1


if __name__ == '__main__':
    input_array = [2, 5, 9, 15, 20, 26, 30, 40, 51, 56, 60]
    position = interpolation_search(input_array, 20)
    if position == -1:
        print("Element not found")
    else:
        print("Element found at position {}".format(position))

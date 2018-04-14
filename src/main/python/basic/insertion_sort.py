#!/usr/bin/python


def insertion_sort(arr):
    n = len(arr)
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j = j - 1
        arr[j + 1] = key


if __name__ == '__main__':
    array = [3, 6, 2, 12, 56, 8]
    insertion_sort(array)
    print(array)
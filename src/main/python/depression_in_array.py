#!/usr/bin/python


def find_depression(arr, i, j):

    if arr[i] == arr[j]:
        return i

    while i < j:
        mid = (i + j) / 2

        if arr[mid - 1] > arr[mid] <= arr[mid + 1]:
            return mid

        if arr[i] <= arr[mid]:
            i = mid
        else:
            j = mid

    return -1


def binary_search(arr, i, j, key):
    if i > j:
        return -1

    mid = (i + j) / 2
    if arr[mid] == key:
        return mid
    elif key < arr[mid]:
        return binary_search(arr, i, mid, key)
    else:
        return binary_search(arr, mid, j, key)


def find_key_in_depression(arr, i, j, key):
    depression = find_depression(arr, i, j)

    # Range i to depression - 1
    if arr[i] <= key <= arr[depression - 1]:
        return binary_search(arr, i, depression - 1, key)
    else:
        return binary_search(arr, depression, j, key)


if __name__ == '__main__':
    array = [9, 11, 13, 15, 2, 4, 6]
    print ("Lowest element : %d" % find_depression(array, 0, len(array) - 1))
    print ("Finding element 13 : %d" % find_key_in_depression(array, 0, len(array) - 1, 13))
    print ("Finding element 4 : %d" % find_key_in_depression(array, 0, len(array) - 1, 4))

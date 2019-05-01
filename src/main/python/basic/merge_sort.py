def merge(array, i, mid, j):
    l_arr = array[i: mid + 1]
    r_arr = array[mid + 1: j + 1]
    left_index = 0
    right_index = 0
    left_size = len(l_arr)
    right_size = len(r_arr)
    k = i
    inversions = 0
    while left_index < left_size or right_index < right_size:
        if right_index < right_size and left_index < left_size and l_arr[left_index] <= r_arr[right_index]:
            array[k] = l_arr[left_index]
            k += 1
            left_index += 1
        elif right_index < right_size and left_index < left_size and r_arr[right_index] < l_arr[left_index]:
            array[k] = r_arr[right_index]
            k += 1
            right_index += 1
            inversions += (left_size - left_index)
        elif right_index == right_size:
            array[k] = l_arr[left_index]
            k += 1
            left_index += 1
        elif left_index == left_size:
            array[k] = r_arr[right_index]
            k += 1
            right_index += 1
    return inversions


def merge_sort(array, i, j):
    if i < j:
        mid = (i + j) >> 1
        left_inversion = merge_sort(array, i, mid)
        right_inversion = merge_sort(array, mid + 1, j)
        merged_inversion = merge(array, i, mid, j)
        return left_inversion + right_inversion + merged_inversion
    return 0


def main():
    limit = 1000000
    unsorted_array = []
    for i in range(0, limit):
        import random
        unsorted_array.append(random.randint(1, limit * 100))
    from datetime import datetime
    start = datetime.now()
    inversions = merge_sort(unsorted_array, 0, len(unsorted_array) - 1)
    done = datetime.now()
    import asserter as a
    a.assert_sorted(unsorted_array)
    print("Inversions {} ".format(inversions))
    print("Time taken for merge sort %s seconds" % str((done - start).total_seconds()))


if __name__ == '__main__':
    main()


def merge(array, i, mid, j):
    left_array = array[i: mid + 1]
    right_array = array[mid + 1: j + 1]
    l_size = len(left_array)
    r_size = len(right_array)
    # merge two sorted arrays
    left_index = 0
    right_index = 0
    p = i
    inversion_count = 0
    while p <= j:
        if left_index < l_size and right_index < r_size and left_array[left_index] <= right_array[right_index]:
            array[p] = left_array[left_index]
            left_index = left_index + 1
        elif left_index < l_size and right_index < r_size and right_array[right_index] < left_array[left_index]:
            array[p] = right_array[right_index]
            right_index = right_index + 1
            inversion_count += (l_size - left_index)
        elif left_index < l_size:
            array[p] = left_array[left_index]
            left_index = left_index + 1
        elif right_index < r_size:
            array[p] = right_array[right_index]
            right_index = right_index + 1
        p = p + 1
    return inversion_count


def merge_sort(array, i, j):
    inversion_count = 0
    if i < j:
        mid = (i + j) >> 1
        x = merge_sort(array, i, mid)
        y = merge_sort(array, mid + 1, j)
        z = merge(array, i, mid, j)
        return x + y + z
    return inversion_count


def naive_inversion_counting(array):
    count = 0
    for i in range(0, len(array)):
        key = array[i]
        j = i - 1
        while j > -1:
            if key < array[j]:
                count += 1
            j = j - 1
    return count


def main():
    limit = 100
    unsorted_array = []
    for i in range(0, limit):
        import random
        unsorted_array.append(random.randint(1, limit * 100))
    print("Generated Sequence ", unsorted_array)
    print("Naive inversion count ", naive_inversion_counting(unsorted_array))
    from datetime import datetime
    start = datetime.now()
    inversions = merge_sort(unsorted_array, 0, len(unsorted_array) - 1)
    done = datetime.now()
    if __name__ == '__main__':
        print('Inversions = ', inversions)
        print("Time taken %s seconds" % str((done - start).seconds))
    import asserter as a
    a.assert_sorted(unsorted_array)


if __name__ == '__main__':
    main()

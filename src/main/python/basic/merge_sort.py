
def merge(array, i, mid, j):
    L = array[i: mid + 1]
    R = array[mid + 1: j + 1]
    l_size = len(L)
    r_size = len(R)
    # merge two sorted arrays
    l = 0
    r = 0
    p = i
    while p <= j:
        if l < l_size and r < r_size and L[l] < R[r]:
            array[p] = L[l]
            l = l + 1
        elif l < l_size and r < r_size and R[r] < L[l]:
            array[p] = R[r]
            r = r + 1
        elif l < l_size:
            array[p] = L[l]
            l = l + 1
        elif r < r_size:
            array[p] = R[r]
            r = r + 1
        p = p + 1


def merge_sort(array, i, j):
    if i < j:
        mid = (i + j) >> 1
        merge_sort(array, i, mid)
        merge_sort(array, mid + 1, j)
        merge(array, i, mid, j)


def main():
    limit = 1000000
    array = []
    for i in range(0, limit):
        import random
        array.append(random.randint(1, limit * 100))
    print("Generated Sequence")
    from datetime import datetime
    start = datetime.now()
    merge_sort(array, 0, len(array) - 1)
    done = datetime.now()
    if __name__ == '__main__':
        print('sorted array', array)
        print("Time taken %s seconds" % str((done - start).seconds))
    import asserter as a
    a.assert_sorted(array)


if __name__ == '__main__':
    main()
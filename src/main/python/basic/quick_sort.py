

def quick_sort(array, p, r):

    """
    Performs quick sort on given array from start position p 
    till end position r
    """

    if p < r:
        q = _partition(array, p, r)
        quick_sort(array, p, q - 1)  # Sort items to the left side of partition q
        quick_sort(array, q + 1, r)  # Sort items to the right side of partition q


def tail_recursive_quick_sort(array, p, r):
    while p < r:
        q = _partition(array, p, r)
        quick_sort(array, p, q - 1)
        p = q + 1


def _partition(array, p, r):

    i = p - 1  # from 0 till i have elements which are less than pivot
    j = p
    while j < r:
        if array[j] < array[r]:
            i = i + 1
            array[i], array[j] = array[j], array[i]
        j = j + 1

    array[i + 1], array[r] = array[r], array[i + 1]
    return i + 1


def main(algorithm):
    limit = 1000000
    array = []
    for i in range(0, limit):
        import random
        array.append(random.randint(1, limit * 100))
    from datetime import datetime
    start = datetime.now()
    size = len(array) - 1
    if algorithm == 'r':
        print('Calling Recursive Tails \v')
        tail_recursive_quick_sort(array, 0, size)
    else:
        print('Calling Simple \v')
        quick_sort(array, 0, size)
    done = datetime.now()
    import asserter as a
    a.assert_sorted(array)
    print("Time taken %s seconds" % str((done - start).total_seconds()))


if __name__ == '__main__':
    main('s')
    main('r')

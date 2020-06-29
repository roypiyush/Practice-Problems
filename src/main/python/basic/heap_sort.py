import sys


def left(i):
    return i * 2 + 1


def right(i):
    return i * 2 + 2


def parent(i):
    return int(i/2)


def max_heapify(array, i, heap_size):
    largest = i

    if left(i) < heap_size and array[left(i)] > array[i]:
        largest = left(i)
    if right(i) < heap_size and array[right(i)] > array[largest]:
        largest = right(i)
    if largest != i:
        array[largest], array[i] = array[i], array[largest]
        max_heapify(array, largest, heap_size)


def build_max_heap(array):
    i = len(array) >> 1
    while i >= 0:
        max_heapify(array, i, heap_size=len(array))
        i = i - 1


def heap_sort(array):
    build_max_heap(array)
    heap_size = len(array)
    i = heap_size - 1
    while i > 0:
        array[i], array[0] = array[0], array[i]
        i = i - 1
        heap_size = heap_size - 1
        max_heapify(array, 0, heap_size)


def heap_increase_key(array, index, key):
    if key <= array[index]:
        raise ValueError('key {} should be greater than element being increased'.format(key))
    array[index] = key
    while index >= 0 and parent(index) >= 0 and array[parent(index)] < array[index]:
        array[parent(index)], array[index] = array[index], array[parent(index)]
        index = parent(index)


def max_heap_insert(array, key, heap_size):
    array[heap_size - 1] = -10000000000000
    heap_increase_key(array, heap_size - 1, key)


def build_max_heap_prime(array, heap_size):
    for i in range(1, len(array)):
        heap_size += 1
        max_heap_insert(array, array[i], heap_size)


def heap_sort_2(array):
    heap_size = len(array)
    build_max_heap_prime(array, 1)
    i = heap_size - 1
    hs = heap_size
    while i > 0:
        array[hs - 1], array[0] = array[0], array[hs - 1]
        hs -= 1
        max_heapify(array, 0, hs)
        i -= 1


def main(heap_function, array):
    from datetime import datetime
    import asserter as a
    start = datetime.now()
    heap_function(array)
    end = datetime.now()
    print("Time taken %s seconds" % str((end - start).seconds))
    a.assert_sorted(array)


if __name__ == '__main__':
    limit = 1000000
    unsorted_array = []
    for k in range(0, limit):
        import random
        unsorted_array.append(random.randint(1, limit * 100))
    old_array = unsorted_array.copy()
    main(getattr(sys.modules[__name__], 'heap_sort'), unsorted_array)
    main(getattr(sys.modules[__name__], 'heap_sort_2'), old_array)

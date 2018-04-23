
def left(i):
    return i * 2 + 1


def right(i):
    return i * 2 + 2


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


def main():
    limit = 1000
    array = []
    for i in range(0, limit):
        import random
        array.append(random.randint(1, limit * 100))
    from datetime import datetime
    start = datetime.now()
    heap_sort(array)
    done = datetime.now()
    print('sorted array', array)
    print("Time taken %d ms" % (int((done - start).microseconds)/1000))


if __name__ == '__main__':
    main()

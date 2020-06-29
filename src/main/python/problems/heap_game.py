
MAX_VALUE = 10000000000


def left(i):
    return i * 2 + 1


def right(i):
    return i * 2 + 2


def parent(i):
    return i >> 1


def min_heapify(array, i, heap_size):
    minimum = i

    if left(i) < heap_size and array[left(i)] < array[i]:
        minimum = left(i)
    if right(i) < heap_size and array[right(i)] < array[minimum]:
        minimum = right(i)
    if minimum != i:
        array[minimum], array[i] = array[i], array[minimum]
        min_heapify(array, minimum, heap_size)


def heap_decrease_key(array, key, i):
    if key > array[i]:
        return
    array[i] = key
    while i > -1 and array[parent(i)] > array[i]:
        array[parent(i)], array[i] = array[i], array[parent(i)]
        i = parent(i)


def min_heap_insert(array, key):
    heap_size = len(array) + 1
    array.append(key + 1)
    heap_decrease_key(array, key, heap_size - 1)


def internal_find_element(array, key, index):
    if array[index] == key:
        return index

    l = internal_find_element(array, key, left(index))
    if l > -1:
        return l
    r = internal_find_element(array, key, right(index))
    if r > -1:
        return r
    raise ValueError('Not found')


def find_element(array, key):
    start_index = 0
    return internal_find_element(array, key, start_index)


def delete_key(array, key):
    index = find_element(array, key)
    array[index] = MAX_VALUE
    size = len(array)
    min_heapify(array, index, size)
    if size - 1 > 0 and array[size - 1] == MAX_VALUE:
        array.pop(size - 1)
    elif size - 2 > 0 and array[size - 2] == MAX_VALUE:
        array.pop(size - 2)


def main():
    array = []
    n = input()
    for i in range(int(n)):
        items = input().split(' ')
        if items[0] == '3':
            print(array[0])
        elif items[0] == '1':
            min_heap_insert(array, int(items[1]))
        elif items[0] == '2':
            delete_key(array, int(items[1]))


if __name__ == '__main__':
    main()

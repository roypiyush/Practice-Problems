from basic import merge_sort, quick_sort, heap_sort

from datetime import datetime
import random
import threading

def main():

    print("Creating data samples")
    t_start = datetime.now()

    limit = 100000
    array1 = []
    array2 = []
    array3 = []
    for i in range(0, limit):
        array1.append(random.randint(1, limit * 100))
        array2.append(random.randint(1, limit * 100))
        array3.append(random.randint(1, limit * 100))

    print("Starting algorithms")
    t1 = threading.Thread(target=run_qsort, args=(array1, ))
    t2 = threading.Thread(target=run_msort, args=(array2, ))
    t3 = threading.Thread(target=run_hsort, args=(array3, ))
    t1.start()
    t2.start()
    t3.start()

    t1.join()
    t2.join()
    t3.join()

    t_done = datetime.now()
    print("Total Time taken %d sec" % (t_done - t_start).seconds)


def run_hsort(array):
    h_start = datetime.now()
    heap_sort.heap_sort(array)
    h_done = datetime.now()
    print("Heap Sort Time taken %d ms" % ((h_done - h_start).microseconds / 1000))


def run_msort(array):
    m_start = datetime.now()
    merge_sort.merge_sort(array, 0, len(array) - 1)
    m_done = datetime.now()
    print("Merge Sort Time taken %d ms" % ((m_done - m_start).microseconds / 1000))


def run_qsort(array):
    q_start = datetime.now()
    quick_sort.quick_sort(array, 0, len(array) - 1)
    q_done = datetime.now()
    print("Quick Sort Time taken %d ms" % ((q_done - q_start).microseconds / 1000))


if __name__ == '__main__':

    try:
        main()
    except Exception as e:
        print("Caught Exception %s" % e.message)

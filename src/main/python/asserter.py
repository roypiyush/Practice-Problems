def assert_sorted(array):
    size = len(array)
    if size <= 1:
        return
    for i in range(1, size):
        if array[i - 1] > array[i]:
            print("########## Invalid Sequence ##########")
            return

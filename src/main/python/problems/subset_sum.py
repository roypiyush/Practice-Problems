def find_subset_internal(arr, total, i):
    if i >= 0:
        print(total, i)
    if total == 0:
        return 1
    if total < 0 or i < 0:
        return 0
    if total < arr[i]:
        return find_subset_internal(arr, total, i - 1)
    return find_subset_internal(arr, total - arr[i], i - 1) + find_subset_internal(arr, total, i - 1)


def find_subset(arr, total):
    return find_subset_internal(arr, total, len(arr) - 1)


if __name__ == '__main__':
    target = 6  # {1, 2, 3} {2, 4}
    array = [3, 2, 4, 1]
    result = find_subset(array, target)
    print(result)

import random


def median(arr, i, j):
    if j - i < 0:
        raise RuntimeError('Index underflow error')
    if (j - i + 1) % 2 == 0:
        mid = int((i + j) / 2)
        return float(arr[mid] + arr[mid + 1]) / 2

    mid = int((i + j) / 2)
    return arr[mid]


def median_three(a, b, c):
    return a + b + c - max(a, max(b, c)) - min(a, min(b, c))


def median_four(a, b, c, d):
    return (a + b + c + d - max(a, max(b, max(c, d))) - min(a, min(b, min(c, d)))) / 2.0


def median_of_two_sorted_array(arr1, i, j, arr2, k, l):
    while True:
        print ("")

        m1 = median(arr1, i, j)
        m2 = median(arr2, k, l)
        print ("Median1=%s i=%d j=%d %s" % (m1, i, j, arr1[i: j + 1]))
        print ("Median2=%s k=%d l=%d %s" % (m2, k, l, arr2[k: l + 1]))

        if j - i == 1 and l - k == 0:
            return median_three(arr1[i], arr1[j], arr2[k])

        elif j - i == 0 and l - k == 1:
            return median_three(arr1[i], arr2[k], arr2[l])

        elif j - i == 1 and l - k == 1:
            return median_four(arr1[i], arr1[j], arr2[k], arr2[l])

        else:
            if j - i == 0 and l - k == 0:
                return float((arr1[j] + arr2[k]) / 2)
            if m1 < m2:
                i = (i + j) / 2
                l = (k + l) / 2
            elif m1 > m2:
                j = (i + j) / 2
                k = (k + l) / 2
            else:
                return m1


def __main__():
    array1_size, array2_size = 5, 6

    array1 = sorted(random.randint(1, 100) for i in range(array1_size))
    array2 = sorted(random.randint(1, 100) for i in range(array2_size))
    array3 = sorted(array1 + array2)

    expected_median = median(array3, 0, len(array3) - 1)
    result = median_of_two_sorted_array(array1, 0, len(array1) - 1, array2, 0, len(array2) - 1)
    print ("\nMedian of two sorted arrays : %s" % result)
    print ("Expected Median of two sorted arrays : %s" % expected_median)
    print (array3)


if __name__ == '__main__':
    __main__()

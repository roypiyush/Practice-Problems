import numpy as np


def compute_prefix_function(pattern):
    """
    Create an array where 'substring' has suffix same
    as prefix

    :param pattern:
    :return suffix-prefix array:
    """
    size = len(pattern)
    lps = [0] * size
    lps[0] = -1
    i = 0
    for j in range(1, size):
        if pattern[i] == pattern[j]:
            lps[j] = lps[j - 1] + 1
            i += 1
        else:
            i = 0
    return lps


def kmp(pattern, text):
    """

    :param pattern:
    :param text:
    :return: index of pattern or -1 if pattern not found
    """
    index = 0
    pattern_index = 0
    lps = compute_prefix_function(pattern)
    while index < len(text):
        if pattern[pattern_index] == text[index]:
            index += 1
            pattern_index += 1
            if pattern_index == len(pattern):
                # Found match now return
                return index - pattern_index
        else:
            if pattern_index - 1 < 0:
                pattern_index = 0
                index += 1
            pattern_index = lps[pattern_index - 1]

    return -1


if __name__ == '__main__':
    text = "ACXACACXACACAGT"
    pattern = 'ACACAGT'
    lps = compute_prefix_function(pattern)
    print(lps)
    result = kmp(pattern, text)
    print(result)

from termcolor import colored


def compute_prefix_function(pattern):
    """
    Create an array where 'substring' has suffix same
    as prefix. -1 in table denotes no further backtracking possible

    :param pattern:
    :return suffix-prefix array:
    """
    m = len(pattern)
    pi = [0] * m
    pi[0] = -1
    k = -1
    for i in range(1, m):
        while k > -1 and pattern[k + 1] != pattern[i]:
            k = pi[k]
        if pattern[k + 1] == pattern[i]:
            k = k + 1
        pi[i] = 0 if k == -1 else k
    return pi


def kmp(pattern, text):
    """

    :param pattern:
    :param text:
    :return: index of pattern or -1 if pattern not found
    """
    positions = list()
    pi = compute_prefix_function(pattern)
    m = len(pattern)
    n = len(text)
    k = 0
    for i in range(0, n):
        while k != -1 and text[i] != pattern[k]:
            k = pi[k]   # Find backtrack position
        if k == -1:
            k = 0
        if text[i] == pattern[k]:
            k = k + 1
        if k == m:
            positions.append(i - m + 1)
            k = pi[k - 1]
    return positions


def print_matched(pattern, text, start_index):
    if start_index == -1:
        print('Pattern not present')
        return

    size = len(pattern)
    matched_pattern = colored(pattern, 'grey', attrs=['bold', 'underline'])
    print("Matched Pattern at index %2d -> %s%s%s" % (
        start_index, text[0: start_index], matched_pattern, text[start_index + size:]))


def __main__():
    text = "ACXACACXACACAGTAAAA"
    pattern = 'ACA'

    positions = kmp(pattern, text)
    for p in positions:
        print_matched(pattern, text, p)


if __name__ == '__main__':
    __main__()

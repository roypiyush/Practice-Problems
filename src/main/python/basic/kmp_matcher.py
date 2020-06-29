from termcolor import colored

"""
Psuedo Code for KMP Algorithm

kmp_matcher(T, P):
    n = T.length
    m = P.length
    q = 0
    𝚷 = COMPUTE_PREFIX_FUNCTION(P)
    for i  1 to n:
        while q > 0 and P[q + 1] != T[i]:
            q = 𝚷[q]
        if P[q + 1] == T[i]:
            q = q + 1
        if q == m:
            print "Match found at " i - m
            q = 𝚷[q]

compute_prefix_function(P)
    m = P.length
    𝚷 = new array of size m
    𝚷[1] = 0
    k = 0
    for q  1 to m:
        while k > 0 and P[k + 1] != P[q]
            k = 𝚷[k]
        if P[k + 1] == P[q]
            k = k + 1
        𝚷[q] = k
    return 𝚷
"""


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
        if k == -1:
            """
            This condition is added because first value of pi array = -1
            """
            pi[i] = 0
        else:
            pi[i] = k
    return pi


def kmp(pattern, text):
    """

    :param pattern:
    :param text:
    :return: array of found index position. Empty
    """
    positions = list()
    pi = compute_prefix_function(pattern)
    m = len(pattern)
    n = len(text)
    k = -1
    i = 0
    while i < n:
        while k > -1 and text[i] != pattern[k + 1]:
            k = pi[k]   # Find backtrack position
        if text[i] == pattern[k + 1]:
            k = k + 1
        if k + 1 == m:
            positions.append(i - m + 1)
            k = pi[k]
        i += 1
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
    text = "ACXAACACXAACAACAGTAAAA"
    pattern = 'AACA'

    positions = kmp(pattern, text)
    if len(positions) == 0:
        print('Pattern not found...')
        return
    for p in positions:
        print_matched(pattern, text, p)


if __name__ == '__main__':
    __main__()

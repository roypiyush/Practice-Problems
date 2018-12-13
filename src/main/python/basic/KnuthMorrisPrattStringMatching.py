from termcolor import colored, COLORS


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


def kmp_first_match(pattern, text):
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


def kmp_all_match(pattern, text):
    """

    :param pattern:
    :param text:
    :return: index of pattern or -1 if pattern not found
    """
    index = 0
    pattern_index = 0
    lps = compute_prefix_function(pattern)
    positions = list()
    while index < len(text):
        if pattern[pattern_index] == text[index]:
            index += 1
            pattern_index += 1
            if pattern_index == len(pattern):
                # Found match now return
                found_index = index - pattern_index
                positions.append(found_index)
                pattern_index = lps[pattern_index - 1]
                if pattern_index == -1:
                    pattern_index = 0
        else:
            if pattern_index - 1 < 0:
                pattern_index = 0
                index += 1
            pattern_index = lps[pattern_index - 1]

    return positions


def print_matched(pattern, text, start_index):
    if start_index == -1:
        print('Pattern not present')
        return

    size = len(pattern)
    matched_pattern = colored(pattern, 'grey', attrs=['bold', 'underline'])
    print("Matched Pattern at index {} -> {}{}{}".format(start_index, text[0: start_index], matched_pattern, text[start_index + size:]))


def __main__():
    text = "ACXACACXACACAGT"
    pattern = 'ACX'
    lps = compute_prefix_function(pattern)
    print(lps)
    start_index = kmp_first_match(pattern, text)
    print_matched(pattern, text, start_index)

    positions = kmp_all_match(pattern, text)
    for p in positions:
        print_matched(pattern, text, p)


if __name__ == '__main__':
    __main__()


from termcolor import colored


def cut_rod_recursive(price_list, length):
    if length < 0:
        return 0

    max_price = 0
    i = 1
    while i <= length:
        max_price = max(max_price, price_list[i] + cut_rod_recursive(price_list, length - i))
        i += 1
    return max_price


def cut_rod(price_list, length, results):
    if length < 0:
        return 0

    if results[length] >= 0:
        return results[length]

    max_price = 0
    i = 1
    while i <= length:
        max_price = max(max_price, price_list[i] + cut_rod(price_list, length - i, results))
        i += 1
    results[length] = max_price
    return max_price


def main():
    price_list = [0, 1, 5, 8, 9, 10, 17, 20, 24, 30]
    length = 4
    result = cut_rod_recursive(price_list, length)
    print(colored("Solution by recursion %s" % result, 'magenta'))
    results = [-1] * len(price_list)
    results[0] = 0
    result = cut_rod(price_list, length, results)
    print(colored("Solution by dp %s" % result, 'cyan'))


if __name__ == '__main__':
    main()

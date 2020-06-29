
def longest_parenthesis_pair(string):
    stack = [-1]
    longest_so_far = 0
    size = len(string)
    for i in range(size):
        if string[i] == '(':
            stack.append(i)
        else:
            stack.pop()
            if len(stack) > 0:
                longest_so_far = max(longest_so_far, i - stack[-1])
            else:
                stack.append(i)
    return longest_so_far


def main():

    string = '((()()'
    print(longest_parenthesis_pair(string))
    string = '()(()))))'
    print(longest_parenthesis_pair(string))
    string = '((()(()()))()'
    print(longest_parenthesis_pair(string))
    string = '())'
    print(longest_parenthesis_pair(string))
    string = '()(()(()())()'
    print(longest_parenthesis_pair(string))


if __name__ == '__main__':
    main()

#!/usr/bin/python


class Stack:

    def __init__(self):
        self.items = []
        self.size = 0

    def is_not_empty(self):
        return self.is_empty() is False

    def is_empty(self):
        return self.size == 0

    def push(self, item):
        if item is None:
            raise ValueError("Cannot push 'None' value")
        self.items.append(item)
        self.size = self.size + 1

    def pop(self):
        if self.size == 0:
            return None
        self.size = self.size - 1
        return self.items.pop()

    def peek(self):
        return self.items[self.size - 1]

    def size(self):
        return self.size

    def __repr__(self):
        return self.items.__str__()


def calculate_span(prices):

    stack = Stack()
    n = len(prices)
    stack.push(0)
    s = [0] * len(prices)
    s[0] = 1

    for i in range(1, n):
        while stack.is_not_empty() and prices[stack.peek()] <= prices[i]:
            stack.pop()

        s[i] = i + 1 if stack.is_empty() else i - stack.peek()
        stack.push(i)

    return s


if '__main__' == __name__:
    price_list = [100, 80, 60, 70, 60, 75, 85]
    span = calculate_span(price_list)
    print(span)

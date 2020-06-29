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


def next_greater_element(array):
    n = len(array)
    stack = Stack()
    for i in range(n - 1, -1, -1):
        key = array[i]
        while stack.is_not_empty() and stack.peek() < key:
            stack.pop()

        if stack.is_empty():
            array[i] = -1
        elif stack.peek() > key:
            array[i] = stack.peek()
        stack.push(key)
    for i in range(n - 1, -1, -1):
        print(array[i], end=' ')


if __name__ == '__main__':
    elements = [15, 14, 13, 7, 6, 12]
    next_greater_element(elements)

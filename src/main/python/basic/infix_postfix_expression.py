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


def is_operator(e):
    return e in '+-/*'


def get_precedence(e):
    if e == '+' or e == '-':
        return 1
    elif e == '/' or e == '*':
        return 2


# def infix_postfix(expr):
#     n = len(expr)
#     stack = Stack()
#     for i in range(0, n):
#         e = expr[i]
#         if is_operator(e) is not True:
#             print(e, end='')
#         else:
#             if stack.is_empty() or get_precedence(e) >= get_precedence(stack.peek()):
#                 stack.push(e)
#             else:
#                 while stack.is_not_empty() and get_precedence(stack.peek()) >= get_precedence(e):
#                     print(stack.pop(), end='')
#                 stack.push(e)
#     while stack.is_not_empty():
#         print(stack.pop(), end='')


def infix_postfix(expr):
    n = len(expr)
    stack = Stack()
    for i in range(0, n):
        e = expr[i]
        if is_operator(e) is not True:
            print(e, end='')
        else:
            print(',', end='')
            while stack.is_not_empty() and get_precedence(stack.peek()) >= get_precedence(e):
                print(stack.pop(), end=',')
            stack.push(e)
    while stack.is_not_empty():
        print(',', end='')
        print(stack.pop(), end='')


if __name__ == '__main__':
    expression = '100+4*10-10/5+1'
    infix_postfix(expression)

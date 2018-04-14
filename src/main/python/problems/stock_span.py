

class Stack:
    def __init__(self):
        self.items = []

    def is_not_empty(self):
        return self.items != []

    def is_empty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items) - 1]

    def size(self):
        return len(self.items)

    def __repr__(self):
        return self.items.__str__()


def calculate_span(prices):

    stack = Stack()
    n = len(prices)
    stack.push(0)
    S = [0 for i in range(len(prices))]
    S[0] = 1

    for i in range(1, n):
        while stack.is_not_empty() and prices[stack.peek()] <= prices[i]:
            stack.pop()

        S[i] = i + 1 if stack.is_empty() else i - stack.peek()
        stack.push(i)

    return S


if '__main__' == __name__:
    prices = [100, 80, 60, 70, 60, 75, 85]
    S = calculate_span(prices)
    print(S)

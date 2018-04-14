# -*- coding: utf-8 -*-


class UglyNumber:

    def __init__(self, number):
        self.number = number
        self.current_number = number

    def next(self):
        self.current_number = self.number * (self.current_number/self.number + 1)

    def __repr__(self):
        return "Number: %d Current Number: %d" % (self.number, self.current_number)


def find(n):
    i2 = UglyNumber(2)
    i3 = UglyNumber(3)
    i5 = UglyNumber(5)

    array = [0, 1]
    count = 1

    list_of_items = [i2, i3, i5]
    while count < n:
        list_of_items = sorted(list_of_items, key=lambda item: item.current_number)
        item = list_of_items.pop(0)
        if array[len(array) - 1] == item.current_number:
            continue

        array.append(item.current_number)
        item.next()
        count = count + 1
        list_of_items.append(item)

    print ("Entire Array " + str(array))
    return array[n]


if __name__ == '__main__':
    N = 7
    print ("N=%s Nth ugly number %d" % (N, find(n=N)))


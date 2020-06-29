
def brute_force(histogram):
    max_area = 0
    for i in range(len(histogram)):
        max_area = max(max_area, histogram[i])
        height = histogram[i]
        for j in range(i, len(histogram)):
            height = min(height, histogram[j])
            area = height * (j - i + 1)
            max_area = max(max_area, area)
    return max_area


def stack_solution(hist):
    size = len(hist)
    index_stack = []
    height_stack = []
    max_area = 0
    for i in range(0, size):
        if len(index_stack) == 0 or height_stack[-1] < hist[i]:
            index_stack.append(i)
            height_stack.append(hist[i])
        else:
            index = -1
            while len(height_stack) > 0 and height_stack[-1] >= hist[i]:
                h = height_stack.pop()
                index = index_stack.pop()
                w = i - index
                area = h * w
                max_area = max(max_area, area)

            index_stack.append(index)
            height_stack.append(hist[i])
    while len(index_stack) > 0:
        index = index_stack.pop()
        w = size - index
        h = height_stack.pop()
        max_area = max(max_area, h * w)
    return max_area


if __name__ == '__main__':
    array = [0, 1, 2, 4, 3, 5, 2, 1, 0]
    print(brute_force(array))
    print(stack_solution(array))
    array = [6, 2, 5, 4, 5, 1, 6]
    print(brute_force(array))
    print(stack_solution(array))
    array = [1, 2, 3, 2, 2, 4, 1]
    print(brute_force(array))
    print(stack_solution(array))


def find_rain_trapped(arr):
    stack = [0]
    size = len(arr)
    rain = 0
    for i in range(1, size):
        previous_position = -1
        while len(stack) > 0 and arr[i] >= arr[stack[-1]]:
            previous_position = stack.pop()
        if len(stack) == 0:
            rain = rain + calculate(arr, previous_position, i)
        stack.append(i)
    if len(stack) > 0:
        current_position = stack.pop()
        while len(stack) > 0:
            previous_position = stack.pop()
            rain = rain + calculate(arr, previous_position, current_position)
            current_position = previous_position
    return rain


def calculate(arr, previous_position, current_position):
    if previous_position == -1:
        return 0
    rain_height = min(arr[previous_position], arr[current_position])
    rain = 0
    for i in range(previous_position + 1, current_position):
        rain = rain + (rain_height - arr[i])
    return rain


if __name__ == '__main__':
    array = [4, 0, 2, 4, 1, 2, 3]
    print(find_rain_trapped(array))
    array = [1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print(find_rain_trapped(array))
    array = [2, 0, 2]
    print(find_rain_trapped(array))
    array = [3, 0, 0, 2, 0, 4]
    print(find_rain_trapped(array))
    array = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print(find_rain_trapped(array))
    array = [9, 1, 4, 0, 2, 8, 6, 3, 5]
    print(find_rain_trapped(array))

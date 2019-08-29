
def strong_password_checker(passwd):
    has_number = 0
    has_upper_case = 0
    has_lower_case = 0
    has_not_repeating = 1

    repeat_count = 1
    size = len(passwd)
    if size < 6 or size > 20:
        return False

    c = passwd[0]
    if c.isnumeric():
        has_number = 1
    if c.isalpha() and c.isupper():
        has_upper_case = 1
    if c.isalpha() and c.islower():
        has_lower_case = 1

    for i in range(1, size):
        c = passwd[i]
        if c.isnumeric():
            has_number = 1
        if c.isalpha() and c.isupper():
            has_upper_case = 1
        if c.isalpha() and c.islower():
            has_lower_case = 1
        if passwd[i - 1].lower() == c.lower():
            repeat_count = repeat_count + 1
        else:
            repeat_count = 1
        if repeat_count == 3:
            has_not_repeating = 0

    return (has_number + has_lower_case + has_upper_case + has_not_repeating) == 4


if __name__ == '__main__':
    password = 'Ddd1234343'
    print(strong_password_checker(password))

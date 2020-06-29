
def binary_to_decimal(binary):
    decimal, i, n = 0, 0, 0
    while binary != 0:
        dec = binary % 10
        decimal = decimal + dec * pow(2, i)
        binary = binary/10
        i += 1
    print(decimal)


if __name__ == '__main__':
    ip_address = '192.168.0.104'
    octets = ip_address.split('.')
    string_int = ''
    for octet in octets:
        string_int = string_int + str('{0:08b}'.format(int(octet)))
    print(string_int)
    print(int(string_int, 2))

import math


def is_perfect(n) -> bool:
    # Your implementation here!
    return False


if __name__ == '__main__':
    with open('PerfectIN.txt', 'r') as f:
        while True:
            n = f.readline()
            if n == '':
                break
            n = int(n)
            out = is_perfect(n)
            if out:
                print('true')
            else:
                print('false')

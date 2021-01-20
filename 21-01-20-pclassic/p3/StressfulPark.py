def path(park) -> int:
    # Your implementation here!
    return 0


if __name__ == '__main__':
    with open('StressfulParkIN.txt', 'r') as f:
        while True:
            s = f.readline()
            if s == '':
                break
            N, M = map(int, s.strip().split())
            park = []
            for i in range(N):
                park.append(list(map(int, f.readline().strip().split())))
            print(path(park))

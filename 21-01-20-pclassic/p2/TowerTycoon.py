from typing import List


def tower(l) -> List[str]:
    # Your implementation here!
    return []


if __name__ == '__main__':
    with open('TowerTycoonIN.txt', 'r') as f:
        while True:
            s = f.readline()
            if s == '':
                break
            s = int(s)
            l = []
            for i in range(s):
                l.append(f.readline().strip().split())
            print('[' + ', '.join(tower(l)) + ']')

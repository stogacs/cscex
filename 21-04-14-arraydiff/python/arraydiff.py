import unittest
from typing import List, Tuple


def array_diff(a: List[int], b: List[int]) -> List[int]:
    # IMPLEMENTATION HERE
    raise NotImplementedError()


# HERE BE TESTS

class Test(unittest.TestCase):

    def test_empty(self):
        self.__testc(
            ([], [], []),
            ([5], [], [5]),
            ([3, 4], [], [3, 4]),
            ([], [2], [])
        )

    def test_single(self):
        self.__testc(
            ([1, 2], [1], [2]),
            ([2, 3], [0], [2, 3]),
            ([6, 4], [5], [6, 4]),
            ([0, 1], [1, 3], [0])
        )

    def test_multiple(self):
        self.__testc(
            ([1, 2, 2, 3], [2], [1, 3]),
            ([3, 3, 5, 2], [2], [3, 3, 5]),
            ([2, 4, 6, 2, 5], [2], [4, 6, 5])
        )

    def __testc(self, *cases: Tuple[List[int], List[int], List[int]]):
        for a, b, expected in cases:
            self.__test(a, b, expected)

    def __test(self, a: List[int], b: List[int], expected: List[int]):
        result = array_diff(a, b)
        self.assertEqual(result, expected)


if __name__ == '__main__':
    unittest.main()

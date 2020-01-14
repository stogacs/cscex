import unittest


def solve(arr):
    # Your implementation here

    return 0

class CasinoTest(unittest.TestCase):

    def test(self):
        self.assertEqual(solve([1, 1, 1]), 1)
        self.assertEqual(solve([1, 2, 1]), 2)
        self.assertEqual(solve([8, 2, 8]), 9)
        self.assertEqual(solve([8, 1, 4]), 5)
        self.assertEqual(solve([7, 4, 10]), 10)
        self.assertEqual(solve([12, 12, 12]), 18)
        self.assertEqual(solve([1, 23, 2]), 3)

if __name__ == "__main__":
    unittest.main()

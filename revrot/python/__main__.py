import unittest


def revrot(s: str, sz: int) -> str:
    # Your implementation here!
    pass


# Below are tests!
class Tests(unittest.TestCase):
    # tests: ((string, chunk size), correct answer)
    cases = [(('123456987654', 6), '234561876549'),
             (('123456987653', 6), '234561356789'),
             (('66443875', 4), '44668753'),
             (('66443875', 8), '64438756'),
             (('664438769', 8), '67834466'),
             (('123456779', 8), '23456771'),
             (('', 8), ''),
             (('123456779', 0), ''),
             (('563000655734469485', 4), '0365065073456944')]

    def test(self):
        for (s, sz), answer in self.cases:
            self.run_test(s, sz, answer)

    def run_test(self, s: str, sz: int, answer: str):
        res = revrot(s, sz)
        self.assertEqual(res, answer)


if __name__ == '__main__':
    unittest.main()

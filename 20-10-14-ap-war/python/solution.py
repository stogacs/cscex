import unittest


def under_vs_upper(under: str, upper: str) -> str:
    # Write your implementation here...
    und = under.split(" ")
    upp = upper.split(" ")
    un = [0, 3, 5, 6, 8]
    up = [3, 4, 5, 5, 8]
    unds = 0
    upps = 0
    for i in range(len(un)):
        unds += un[i]*int(und[i])
        upps += up[i]*int(upp[i])
    if unds > upps:
        return ("Underclassmen are victorious")
    elif unds < upps:
        return ("Upperclassmen are victorious")
    else:
        return("No victor on this battlefield")


class TestAPWar(unittest.TestCase):
    under_victory = "Underclassmen are victorious"
    upper_victory = "Upperclassmen are victorious"
    tie = "No victor on this battlefield"
    correct = ["Expected under victory",
               "Expected upper victory", "Expected tie"]

    def test_under_wins(self):
        self.run_test("0 0 0 0 10", "0 0 0 0 0",
                      self.under_victory, self.correct[0])
        self.run_test("1 0 1 0 0", "0 1 0 0 0",
                      self.under_victory, self.correct[0])

    def test_upper_wins(self):
        self.run_test("0 1 0 0 1", "0 0 0 1 1",
                      self.upper_victory, self.correct[1])
        self.run_test("0 0 0 0 0", "0 0 0 0 10",
                      self.upper_victory, self.correct[1])

    def test_tie(self):
        self.run_test("0 0 1 0 1", "1 0 1 1 0", self.tie, self.correct[2])
        self.run_test("2 0 4 0 5", "6 2 2 0 3", self.tie, self.correct[2])
        self.run_test("0 0 0 0 10", "0 0 0 0 10", self.tie, self.correct[2])

    def run_test(self, under, upper, answer, message):
        self.assertEqual(under_vs_upper(under, upper),
                         answer, message)


if __name__ == '__main__':
    unittest.main()

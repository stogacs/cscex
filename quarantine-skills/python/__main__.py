import unittest


# Your implementation here!
def get_skill_levels(art_req: str, epl_req: str, to_spend: str) -> str:
    # Replace with your implementation
    pass


# Tests below!
class Tests(unittest.TestCase):
    cases = [
        ("1 4", "3 8", "7 24", "4 1"),
        ("11 13", "5 17", "102 176", "7 5"),
        ("1 5", "2 10", "5 4", "-1 -1"),
        ("0 1", "1 0", "5 12", "12 5"),
        ("1 1", "0 1", "3 4", "3 1"),
        ("0 0", "0 0", "0 0", "-1 -1"),
        ("1001 101", "130 1195", "3393 3888", "3 3"),
        ("203 407", "805 212", "3031 3273", "7 2"),
        ("1 2", "3 7", "896 1920", "512 128"),
        ("100 99", "10 9", "0 9", "-1 -1"),
        ("12 2", "4872 2910", "0 0", "0 0")]

    def test(self):
        for art_req, epl_req, to_spend, answer in self.cases:
            self.assertEqual(get_skill_levels(
                art_req, epl_req, to_spend), answer)


if __name__ == '__main__':
    unittest.main()

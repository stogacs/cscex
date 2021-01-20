import unittest


# Your implementation here!
def get_skill_levels(art_req: str, epl_req: str, to_spend: str) -> str:
    # Replace with your implementation
    art_time_s, art_effort_s = art_req.split(' ')
    art_time = int(art_time_s)
    art_effort = int(art_effort_s)

    epl_time_s, epl_effort_s = epl_req.split(' ')
    epl_time = int(epl_time_s)
    epl_effort = int(epl_effort_s)

    total_time_s, total_effort_s = to_spend.split(' ')
    total_time = int(total_time_s)
    total_effort = int(total_effort_s)

    a, b = 0, 0
    det = art_time * epl_effort - art_effort * epl_time
    if det == 0:
        return '-1 -1'
    a = int((total_time * epl_effort - total_effort * epl_time) / det)
    b = int((- total_time * art_effort + total_effort * art_time) / det)
    if a < 0 or b < 0:
        return '-1 -1'
    return '{} {}'.format(a, b)


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

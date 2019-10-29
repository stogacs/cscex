from math import floor


def pythagorean_triples(c):
    """

    :param c: the length of the aqueduct you want to construct.
    :return: a list containing all possible configurations of the other two
             sides that are of positive integer length. Output each
             configuration as a separate element in a list in the format a b
             where a is in ascending order and b is in descending order in
             respect to the other configurations.
    """

    output = []
    #write ur code here
    
    return output


def parse_file_and_call_function():
    with open("TrickyIN.txt", "r") as f:
        for line in f:
            print(list(pythagorean_triples(int(line))))


if __name__ == "__main__":
    parse_file_and_call_function()

import random
import itertools


def sudoku_solver(puzzle):
    """

    :param puzzle: a 9 x 9 grid (list of lists) of integers denoting the unsolved puzzle
    :return: a 9 x 9 grid (list of lists) of integers denoting the solved puzzle
    """
    free_positions = []
    for r in xrange(9):
        for c in xrange(9):
            if puzzle[r][c] == 0:
                free_positions.append((r, c))

    while True:
        if fill_guess(puzzle, free_positions) and check_sudoku(puzzle):
            return puzzle
        clear_guess(puzzle, free_positions)


def clear_guess(puzzle, free_positions):
    for free_row, free_col in free_positions:
        puzzle[free_row][free_col] = 0


def fill_guess(puzzle, free_positions):
    for free_row, free_col in free_positions:
        options = set(range(1, 10))
        options -= set(puzzle[free_row])
        options -= set([row[free_col] for row in puzzle])
        options = list(options)
        if len(options) == 0:
            return False
        puzzle[free_row][free_col] = random.choice(options)
    return True


def check_sudoku(grid):
    """
    Basic sudoku checker, copied from http://stackoverflow.com/questions/17605898/sudoku-checker-in-python
    """

    def sudoku_ok(line):
        return (len(line) == 9 and sum(line) == sum(set(line)))

    bad_rows = [row for row in grid if not sudoku_ok(row)]
    grid = list(zip(*grid))
    bad_cols = [col for col in grid if not sudoku_ok(col)]
    squares = []
    for i in xrange(0, 9, 3):
        for j in xrange(0, 9, 3):
            square = [
                grid[r][c] for c in xrange(j, j + 3) for r in xrange(i, i + 3)
            ]
            squares.append(square)
    bad_squares = [square for square in squares if not sudoku_ok(square)]
    return not (bad_rows or bad_cols or bad_squares)


def parse_file_and_call_function():
    with open("SudokuSolverIN.txt", "r") as f:
        puzzles = []
        current_puzzle = []
        for line in f:
            line = line.strip()
            if len(line) > 0:
                current_puzzle.append([int(x) for x in line.split()])
                if len(current_puzzle) == 9:
                    puzzles.append(current_puzzle)
                    current_puzzle = []

        for puzzle in puzzles:
            ans = sudoku_solver(puzzle)
            out = ''
            for line in ans:
                out += ' '.join([str(x) for x in line])
                out += '\n'
            print out


if __name__ == "__main__":
    parse_file_and_call_function()

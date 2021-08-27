# Don't name this file json.py

from __future__ import annotations

import unittest
from typing import Dict, List, Tuple, Union

"A JSON value can be a string, number, boolean, array, nested object, or null."
Value = Union[str, int, float, bool, List['Value'], 'Map', None]
"The root of a JSON object must have strings as keys."
Map = Dict[str, Value]


def parse(json: str) -> Map:
    """
    Parse a JSON string of arbitrary size and depth into an equivalent
    dictionary structure.

    You can assume that the JSON string is correct. Assume that no string
    literals have escaped characters.

    Obviously, don't use the stdlib's json module. Feel free to write any
    helper functions as needed.
    """
    _, json = whitespace(json)
    o, json = obj(json)
    _, json = whitespace(json)
    return o


def value(json: str) -> Tuple[Value, str]:
    start = json[0]
    if start == '"':
        v, json = string(json)
    elif start.isdigit():
        v, json = number(json)
    elif start == 't' or start == 'f':
        v, json = boolean(json)
    elif start == 'n':
        v, json = null(json)
    elif start == '[':
        v, json = array(json)
    elif start == '{':
        v, json = obj(json)
    else:
        print(json)
        assert False, "Unreachable!"

    return v, json


def array(json: str) -> Tuple[List[Value], str]:
    _, json = lbracket(json)
    _, json = whitespace(json)

    values = []
    while (json[0] != ']'):
        v, json = value(json)
        values.append(v)

        _, json = whitespace(json)

        if json[0] != ',':
            break

        _, json = comma(json)
        _, json = whitespace(json)

    _, json = whitespace(json)
    _, json = rbracket(json)
    return (values, json)


def obj(json: str) -> Tuple[Map, str]:
    _, json = lbrace(json)
    _, json = whitespace(json)

    o = {}
    while (json[0] != '}'):
        k, v, json = pair(json)
        o[k] = v

        _, json = whitespace(json)
        if json[0] != ',':
            break

        _, json = comma(json)
        _, json = whitespace(json)

    _, json = whitespace(json)
    _, json = rbrace(json)

    return (o, json)


def pair(json: str) -> Tuple[str, Value, str]:
    k, json = string(json)

    _, json = whitespace(json)
    _, json = colon(json)
    _, json = whitespace(json)

    v, json = value(json)
    return (k, v, json)


def boolean(json: str) -> Tuple[bool, str]:
    start = json[0]
    if start == 't':
        s = 4
        v = True
    else:
        s = 5
        v = False
    return (v, json[s:])


def string(json: str) -> Tuple[str, str]:
    _, json = quote(json)

    s = 0
    for i, c in enumerate(json):
        if c == '"':
            s = i
            break

    k = json[:s]
    json = json[s:]

    _, json = quote(json)
    return (k, json)


def number(json: str) -> Tuple[Union[int, float], str]:
    s = 0
    for i, c in enumerate(json):
        if not c.isdigit():
            s = i
            break

    if json[s] == '.':
        for i, c in enumerate(json[s + 1:]):
            if not c.isdigit():
                s += 1 + i
                break
        v = float(json[:s])
    else:
        v = int(json[:s])

    json = json[s:]
    return v, json


def null(json: str) -> Tuple[None, str]:
    return (None, json[4:])


def whitespace(json: str) -> Tuple[None, str]:
    for i, c in enumerate(json):
        if c != ' ':
            return (None, json[i:])
    return (None, json)


def discard1(json: str) -> Tuple[None, str]:
    return (None, json[1:])


def lbracket(json: str) -> Tuple[None, str]:
    return discard1(json)


def rbracket(json: str) -> Tuple[None, str]:
    return discard1(json)


def lbrace(json: str) -> Tuple[None, str]:
    return discard1(json)


def rbrace(json: str) -> Tuple[None, str]:
    return discard1(json)


def colon(json: str) -> Tuple[None, str]:
    return discard1(json)


def quote(json: str) -> Tuple[None, str]:
    return discard1(json)


def comma(json: str) -> Tuple[None, str]:
    return discard1(json)


# Here be test cases.

class TestJSON(unittest.TestCase):
    def test_empty(self):
        self.__test({})

    def test_onelevel_literal(self):
        cases = [
            {'x': 5},
            {'one': 'a', 'two': 'a and b'},
            {'yes': True, 'no': False},
            {'null': None},
            {
                'string': 'this is a string',
                'number': 39.5,
                'boolean': True,
                'null': None
            },
            {':sneaky:': 'oops'},
            {'number': '5', 'bool': 'False', 'null': 'null'}
        ]

        self.__test(*cases)

    def test_onelevel_array(self):
        cases = [
            {'empty': []},
            {'one': ['this']},
            {'mixed': [None, 'a', 5, False]},
            {'first': [True], 'second': ['true', None]}
        ]
        self.__test(*cases)

    def test_twolevel(self):
        cases = [
            {'empty': {}},
            {'something': {'a': 5}},
            {'mixed': {'a': 3, 'b': False, 'c': 'zzz'}},
            {
                'multiple': {
                    'x': 13.333,
                    'notnull': None
                },
                'more': {
                    'and': 'more'
                }
            },
            {'arrays': {'first': [], 'second': ['stuff']}},
            {
                'mixed+': {'5': '6', 'arr': ['x', 7.8, False]},
                '+': 30,
                'more': [None, 'b']}
        ]
        self.__test(*cases)

    def test_allthestuff(self):
        # Too lazy to write more
        cases = [
            {
                'random': [1.1, 'and', 10, None, 'true', True,
                           {
                               'more': {'more': 'done'},
                               'more 2': [0.3, 'x'],
                           }],
                'other': [[5, 5], [True, False]],
                'more': {'7': 7},
            }
        ]

        self.__test(*cases)

    def __test(self, *cases: Map):
        import json
        for case in cases:
            s = json.dumps(case)
            parsed = parse(s)
            self.assertEqual(parsed, case)


if __name__ == '__main__':
    unittest.main()

# Don't name this file json.py

from __future__ import annotations

import unittest
from typing import Dict, List, Optional, Type, TypeVar, Union

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
    # IMPLEMENTATION HERE
    raise NotImplementedError()


T = TypeVar('T')


def parse_deserialize(json: str, cls: Type[T]) -> T:
    """
    Parse and deserialize a JSON string of arbitrary size and depth into an
    instance of the class passed in for :cls.

    You can assume that the JSON string is correct and matches the given class
    structure.

    Above assumptions also apply.
    """
    raise NotImplementedError()


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

    def test_deserialize(self):
        import json
        from dataclasses import dataclass

        @dataclass
        class Target:
            x: int
            numbers: List[Union[int, float]]
            flag: bool
            optional: Optional[str]
            children: List[Target]

            def to_json(self) -> str:
                return json.dumps(self.__dict__, default=lambda o: o.__dict__)

        # Too lazy to write more
        cases = [
            Target(x=5, numbers=[13], flag=True, optional='a b c',
                   children=[
                       Target(x=6, numbers=[], flag=False, optional=None,
                              children=[]),
                       Target(x=7, numbers=[14.5], flag=False, optional=None,
                              children=[])],
                   ),
            Target(x=9, numbers=[2.2], flag=False, optional=':::',
                   children=[])
        ]

        def to_dict(case: Target) -> Dict:
            return {
                'x': case.x,
                'numbers': case.numbers,
                'flag': case.flag,
                'optional': case.optional,
                'children': [to_dict(c) for c in case.children]
            }

        for case in cases:
            d = to_dict(case)
            s = json.dumps(d)
            parsed = parse_deserialize(s, case.__class__)
            self.assertEqual(parsed, case)

    def __test(self, *cases: Map):
        import json
        for case in cases:
            s = json.dumps(case)
            parsed = parse(s)
            self.assertEqual(parsed, case)


if __name__ == '__main__':
    unittest.main()

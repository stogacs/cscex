'''
Conestoga Computer Science Club Programming Challenges

Instructions:
Finish each method and run the test.py file to test the methods.
'''



'''
Karaca Encrypt
--------------
Make a function that encrypts a given input with these steps:

Input: "apple"

Step 1: Reverse the input: "elppa"

Step 2: Replace all vowels using the following chart:

a => 0
e => 1
i => 2
o => 3
u => 4

# "1lpp0"
Step 3: Add "aca" to the end of the word: "1lpp0aca"

Output: "1lpp0aca"

Examples:
encrypt("banana") ➞ "0n0n0baca"

encrypt("karaca") ➞ "0c0r0kaca"

encrypt("burak") ➞ "k0r3baca"

encrypt("alpaca") ➞ "0c0pl0aca"

Notes:
All inputs are strings, no uppercases and all output must be strings.
'''
def karacaEncrypt(word):
    # Code here

    map = {"a": "0", "e": "1", "i": "2", "o": "3", "u": "4"}
    backwords = word[:-1]




'''
Convert to Hex
Create a function that takes a strings characters as ASCII and returns each characters hexadecimal value as a string.

Examples:
convert_to_hex("hello world") ➞ "68 65 6c 6c 6f 20 77 6f 72 6c 64"

convert_to_hex("Big Boi") ➞ "42 69 67 20 42 6f 69"

convert_to_hex("Marty Poppinson") ➞ "4d 61 72 74 79 20 50 6f 70 70 69 6e 73 6f 6e"

Notes:
Each byte must be seperated by a space.
All alpha hex characters must be lowercase.
'''
def convertToHex(string):
    # Code here
    pass

'''
Moran Numbers
A Harshad number is a number which is divisible by the sum of its digits. For example, 132 is divisible by 6 (1+3+2).

A subset of the Harshad numbers are the Moran numbers. Moran numbers yield a prime when divided by the sum of their digits. For example, 133 divided by 7 (1+3+3) yields 19, a prime.

Create a function that takes a number and returns "M" if the number is a Moran number, "H" if it is a (non-Moran) Harshad number, or "Neither".

Examples
moran(132) ➞ "H"

moran(133) ➞ "M"

moran(134) ➞ "Neither"

Notes:
You may need to make a method to determine whether a number is prime.
'''
def moran(num):
    # Code here
    pass

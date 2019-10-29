'''
Conestoga Computer Science Club Programming Challenges

Instructions:
Finish each method and run the test.py file to test the methods.
'''

#EASY

'''
Count Letters in a Word Search
Create a function that counts the number of times a particular letter shows up in the word search.

Examples
letter_counter([
  ["D", "E", "Y", "H", "A", "D"],
  ["C", "B", "Z", "Y", "J", "K"],
  ["D", "B", "C", "A", "M", "N"],
  ["F", "G", "G", "R", "S", "R"],
  ["V", "X", "H", "A", "S", "S"]
], "D") ➞ 3

# "D" shows up 3 times: twice in first row, once in third row.

letter_counter([
  ["D", "E", "Y", "H", "A", "D"],
  ["C", "B", "Z", "Y", "J", "K"],
  ["D", "B", "C", "A", "M", "N"],
  ["F", "G", "G", "R", "S", "R"],
  ["V", "X", "H", "A", "S", "S"]
], "H") ➞ 2
'''
def letter_counter(lst, letter):
	pass

'''
H4ck3r Sp34k
Create a function that takes a string as an argument and returns a coded (h4ck3r 5p34k) version of the string.

Examples
hacker_speak("javascript is cool") ➞ "j4v45cr1pt 15 c00l"

hacker_speak("programming is fun") ➞ "pr0gr4mm1ng 15 fun"

hacker_speak("become a coder") ➞ "b3c0m3 4 c0d3r"
Notes
In order to work properly, the function should replace all 'a's with 4, 'e's with 3, 'i's with 1, 'o's with 0, and 's's with 5.
'''
def hacker_speak(txt):
	pass

#MEDIUM

'''
Change Every Letter to the Next Letter
Write a function that changes every letter to the next letter:

"a" becomes "b"
"b" becomes "c"
"d" becomes "e"
and so on ...
Examples
move("hello") ➞ "ifmmp"

move("bye") ➞ "czf"

move("welcome") ➞ "xfmdpnf"
Notes
There will be no z's in the tests.
'''
def move(word):
	pass

'''
Swimming Pool
Suppose a swimming pool blueprint can be represented as a 2D list, where 1s represent the pool and 0s represent the rest of the backyard.

[[0, 0, 0, 0, 0, 0, 0, 0],
[0, 1, 1, 1, 1, 1, 0, 0],
[0, 1, 1, 1, 1, 1, 0, 0],
[0, 1, 1, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0]]
# Legitimate
Suppose a pool is considered legitimate if it does not touch any of the four borders in this 2D list.

[[1, 1, 0, 0, 0, 0, 0, 0],
[1, 1, 1, 1, 1, 1, 0, 0],
[0, 1, 1, 1, 1, 1, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0]]
# Illegitimate! 
# The 1s are touching both the left "fence" and the upper "fence".
Create a function that returns True if the pool plan is legitimate, and False otherwise.

Examples
is_legitimate([
  [0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 1, 1, 1, 0, 0, 0],
  [0, 1, 1, 1, 1, 1, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0]
]) ➞ True

is_legitimate([
  [0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 1, 1, 1, 0, 0, 0],
  [0, 1, 1, 1, 1, 1, 0, 0],
  [0, 0, 1, 1, 1, 0, 0, 0]
]) ➞ False

is_legitimate([
  [0, 0, 0, 0, 0],
  [0, 1, 1, 1, 0],
  [0, 1, 1, 1, 0],
  [0, 0, 0, 0, 0]
]) ➞ True
'''
def is_legitimate(lst):
	pass

#HARD

'''
Farthest Hamming Anagrams
An anagram is a word, x, formed by rearranging the letters that make up another word, y, and using up all the letters in y at the same frequency. For example, "dear" is an anagram of "read" and "plead" is an anagram of "paled".

The Hamming distance between two strings is the number of positions at which they differ. Hamming distances can only be calculated for strings of equal length.

s1 = "eleven"

s2 = "twelve"
They only have the third position (index 2) in common, giving them a Hamming distance of 5.

As anagrams are of identical length, the Hamming distance between them can be calculated.

s1 = "read"

s2 = "dear"
These strings differ at the first and last positions, giving them a Hamming distance of 2. "Plead" and "paled" have a Hamming distance of 3.

Create a function that takes two strings, and returns:

True if they are anagrams of each other and their Hamming distance is equal to their length (i.e. no letters in the same positions).
False if they aren't anagrams, or
Their Hamming distance if they are anagrams with >=1 letter at the same index.
Examples
max_ham("dear", "read") ➞ 2

max_ham("dare", "read") ➞ True

max_ham("solemn", "molest") ➞ False
'''
def max_ham(s1, s2):
	pass

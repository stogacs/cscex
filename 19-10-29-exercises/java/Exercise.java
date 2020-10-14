package exercise;

import java.util.ArrayList;

public class Exercise {

  public Exercise() {}

  //**********COMPLETE THE METHODS BELOW**********

  // EASY

  /*
  Capitalize the Names
          Create a method that takes an array of names and returns an array with
  the first letter capitalized.

  Examples
          capMe(["mavis", "senaida", "letty"]) ➞ ["Mavis", "Senaida", "Letty"]
          capMe(["samuel", "MABELLE", "letitia", "meridith"]) ➞ ["Samuel",
  "Mabelle", "Letitia", "Meridith"] capMe(["Slyvia", "Kristal", "Sharilyn",
  "Calista"]) ➞ ["Slyvia", "Kristal", "Sharilyn", "Calista"]

  Notes
          Don't change the order of the original array.
          Notice in the second example above, "MABELLE" is returned as
  "Mabelle".
  */

  public ArrayList<String> capitalizeTheNames(ArrayList<String> names) {}

  /*
  Compounding Letters
          Create a function that takes a string and returns a new string with
  each new character accumulating by +1. Separate each set with a dash.

  Examples
          accumulate("abcd") ➞ "A-Bb-Ccc-Dddd"
          accumulate("RqaEzty") ➞ "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"\
          accumulate("cwAt") ➞ "C-Ww-Aaa-Tttt"

  Notes
          Capitalize the first letter of each set.
          All tests contain valid strings with alphabetic characters (a-z, A-Z).
  */

  public String accumulate(String str) {}

  // MEDIUM

  /*
  Is This a Right Angled Triangle?
          Given three numbers, x, y and z, determine whether they are the edges
  of a right angled triangle.

  Examples
          rightTriangle(3, 4, 5) ➞ true
          // This is the classic example of a "nice" right angled triangle.

          rightTriangle(145, 105, 100) ➞ true
          // This is a less famous example.

          rightTriangle(70, 130, 110) ➞ false
          // This isn't a right angled triangle.
  Notes
          Notice the largest side of the triangle might not be the last one
  passed to the function. All numbers will be integers (whole numbers).
  */

  public boolean rightTriangle(int x, int y, int z) {}

  /*
  Narcissistic Numbers
          A number is narcissistic when the sum of its digits, with each digit
  raised to the power of digits quantity, is equal to the number itself. 153 ➞ 3
  digits ➞ 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 ➞ Narcissistic 84 ➞ 2 digits ➞ 8² +
  4² = 64 + 16 = 80 ➞ Not narcissistic Given a positive integer n, implement a
  function that returns true if the number is narcissistic, and false if it's
  not.

  Examples
          isNarcissistic(8208) ➞ true
          // 8⁴ + 2⁴ + 0⁴ + 8⁴ = 8208

          isNarcissistic(22) ➞ false
          // 2² + 2² = 8

          isNarcissistic(9) ➞ true
          // 9¹ = 9
  Notes
          Trivially, any number in the 1-9 range is narcissistic and any
  two-digit number is not. Curious fact: Only 88 numbers are narcissistic.
  */

  public boolean isNarcissistic(int num) {}

  // HARD

  /*
  Strip URL Query Parameters
  Create a function that takes a URL (string), removes duplicate query
  parameters and parameters specified within the 2nd argument (which will be an
  optional array).

  Examples
          stripUrlParams("https://edabit.com?a=1&b=2&a=2") ➞
  "https://edabit.com?a=2&b=2" stripUrlParams("https://edabit.com?a=1&b=2&a=2",
  ["b"]) ➞ "https://edabit.com?a=2" stripUrlParams("https://edabit.com", ["b"])
  ➞ "https://edabit.com"

  Notes
          The 2nd argument paramsToStrip is optional.
          paramsToStrip can contain multiple params.
          If there are duplicate query parameters with different values, use the
  value of the last occuring parameter (see examples #1 and #2 above).
  */
  public String stripUrlParams(String url, String[] paramsToStrip) {}
}

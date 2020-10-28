"""
Recursion Practice Solutions
Aditya Sirohi
"""

list = []


def sumFun(listLen, n=0):
    """
    Create a program that will print a list of n length where
    the value of the nth term is n plus the value of n-1

    E.X. 0, 1, 3, 6, 10, 15, 21 …

    ***This is only one possible solution***
    """
    if n == 0:
        list.append(0)
    else:
        list.append(n + list[n - 1])
    if n == listLen - 1:  # this is the base case
        return
    sumFun(listLen, n + 1)  # recursive call to the function


def productFun(array):
    """
    Take in an array and produce a new array that has the nth term
    as the products of all other elements in that array
    [1, 2, 3, 4, 5] --->  [120, 60, 40, 30, 24]

    ***This is only one possible solution***
    """
    listLen = len(array)
    # initialize the new array where the new values will be stored
    tempArray = []

    # I define a recursive function that will help calculate the product
    def recursiveFun(listLen, n, curN, product):
        if curN == listLen - 1:  # base case
            # make sure to multiply the last num to product as long it is not
            # the n that will be changed
            if n != curN:
                # e.x. I would not want to multiply the 5th term if I was
                # calculating the value for the 5th term
                product *= array[curN]
            tempArray.append(product)
            return

        if n != curN:  # if the current index is not the one being calculated
            product *= array[curN]

        recursiveFun(listLen, n, curN + 1, product)  # recursive call

    # for loop that will make the call the recursive function as many times as
    # needed
    for n in range(listLen):
        product = 1
        recursiveFun(listLen, n, 0, product)

    print(tempArray)


def printFun(num):
    """
    Create a function that takes a number as a parameter and prints out those
    numbers in descending order and then rescinding order within the same
    function.

        Function(5):    5, 4, 3, 2, 1 ~~~ 1, 2, 3, 4, 5

    ***This is only one possible solution***
    """

    if num < 1:  # this is the base case
        print("~~~")
        return
    else:
        print(num)  # number that are printed first
        printFun(num - 1)  # recursive call
        print(num)  # numbers that are printed second
        return

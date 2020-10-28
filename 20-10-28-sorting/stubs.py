list1 = [5, 4, 3, 2, 1]
list2 = [-32, 6, 3, -55, 626]
list3 = [1, 2, 3, 4, 99, 5]

def list_to_str(l):

    retStr = "["
    for num in l:
        retStr += str(num)
        retStr += ", "
        
    retStr = retStr[:-2]
    retStr += "]"

    return retStr


def bubble_sort(list_to_sort):

    for upper_bound in range(len(list_to_sort)):
        for swap_index in range(0, len(list_to_sort) - upper_bound - 1):
            # Implement next line. Hint: Check which value is bigger, the value at index swap_index or the one after it?
            if (REPLACE_HERE):
                list_to_sort[swap_index], list_to_sort[swap_index+1] = list_to_sort[swap_index+1], list_to_sort[swap_index]

    return list_to_sort
    
def selection_sort(list_to_sort):
    
    for first_index in range(len(list_to_sort)):
        # Implement next line. Hint: Where is the earliest the min_index can be?
        min_index = REPLACE_HERE
        for look_index in range(first_index, len(list_to_sort)):
            # Implement next line. Hint: Which two values are we comparing?
            if (REPLACE_HERE):
                min_index = look_index
                
        list_to_sort[first_index], list_to_sort[min_index] = list_to_sort[min_index], list_to_sort[first_index]

    return list_to_sort

def merge_sort(list_to_sort):
    
    list_to_sort = list_to_sort[:] # Copies the list (makes sure we don't change the original list)
    
    if len(list_to_sort) > 1:
        
        midpoint = len(list_to_sort)//2 # Get the midpoint index of the list
        
        # Divides the list into two halves
        left_list = list_to_sort[:midpoint]
        right_list = list_to_sort[midpoint:] 

        # Implement the next two lines. Hint: How can we split up the problem into two parts?
        left_list = REPLACE_HERE # Recursively sorts the first half
        right_list = REPLACE_HERE # Recursively sorts the second half
         
        left_counter = 0
        right_counter = 0
        total_counter = 0
         

        # Puts largest of first values of each list (left_list and right_list) into list_to_sort until one is empty
        while left_counter < len(left_list) and right_counter < len(right_list):

            # Implement the next line. Hint: How can we compare the first two values of our left and right lists?
            if (REPLACE_HERE):
                list_to_sort[total_counter] = left_list[left_counter]
                left_counter += 1
            else:
                list_to_sort[total_counter] = right_list[right_counter]
                right_counter += 1
                
            total_counter += 1

        # if there are still values in the left_list, we put them all into the corresponding values in list_to_sort
        while left_counter < len(left_list):
            list_to_sort[total_counter] = left_list[left_counter]
            left_counter += 1
            total_counter += 1

        # if there are still values in the right_list, we put them all into the corresponding values in list_to_sort  
        while right_counter < len(right_list):
            # Implement the next three lines. Hint: We did this for the left list just above!
            REPLACE_HERE
            
    return list_to_sort

#list1 tests
print("list1 unsorted: " + list_to_str(list1))
print("list1 sorted: " + list_to_str(sorted(list1)))
print("Your bubble_sort result: " + list_to_str(bubble_sort(list1)) + (" Correct" if sorted(list1) == bubble_sort(list1) else " Incorrect"))
print("Your selection_sort result: " + list_to_str(selection_sort(list1)) + (" Correct" if sorted(list1) == selection_sort(list1) else " Incorrect"))
print("Your merge_sort result: " + list_to_str(merge_sort(list1)) + (" Correct" if sorted(list1) == merge_sort(list1) else " Incorrect"))
print("")
#list2 tests
print("list2 unsorted: " + list_to_str(list2))
print("list2 sorted: " + list_to_str(sorted(list2)))
print("Your bubble_sort result: " + list_to_str(bubble_sort(list2)) + (" Correct" if sorted(list2) == bubble_sort(list2) else " Incorrect"))
print("Your selection_sort result: " + list_to_str(selection_sort(list2)) + (" Correct" if sorted(list2) == selection_sort(list2) else " Incorrect"))
print("Your merge_sort result: " + list_to_str(merge_sort(list2)) + (" Correct" if sorted(list2) == merge_sort(list2) else " Incorrect"))
print("")
#list3 tests
print("list3 unsorted: " + list_to_str(list3))
print("list3 sorted: " + list_to_str(sorted(list3)))
print("Your bubble_sort result: " + list_to_str(bubble_sort(list3)) + (" Correct" if sorted(list3) == bubble_sort(list3) else " Incorrect"))
print("Your selection_sort result: " + list_to_str(selection_sort(list3)) + (" Correct" if sorted(list3) == selection_sort(list3) else " Incorrect"))
print("Your merge_sort result: " + list_to_str(merge_sort(list3)) + (" Correct" if sorted(list3) == merge_sort(list3) else " Incorrect"))

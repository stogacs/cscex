import main as m

if __name__ == '__main__':
    completed = 0
    methodsNotWorking = []

    if m.letter_counter([
    ['D', 'E', 'Y', 'H', 'A', 'D'],
    ['C', 'B', 'Z', 'Y', 'J', 'K'],
    ['D', 'B', 'C', 'A', 'M', 'N'],
    ['F', 'G', 'G', 'R', 'S', 'R'],
    ['V', 'X', 'H', 'A', 'S', 'S']
], "d") == 1:
        completed += 1
    else:
        methodsNotWorking.append("letter_counter")

    if m.hacker_speak("programming is fun") == "pr0gr4mm1ng 15 fun":
        completed += 1
    else:
        methodsNotWorking.append("hacker_speak")

    if m.move("hello") == "ifmmp":
        completed += 1
    else:
        methodsNotWorking.append("move")

    if m.is_legitimate([
[0, 0, 0, 0, 0, 0, 0, 0], 
[0, 1, 1, 1, 1, 1, 0, 0], 
[0, 1, 1, 1, 1, 1, 0, 0], 
[0, 1, 1, 0, 0, 1, 0, 0], 
[0, 1, 1, 1, 1, 1, 0, 0], 
[0, 0, 0, 0, 0, 0, 0, 0]
]) == True:
        completed += 1
    else:
        methodsNotWorking.append("is_legitimate")

    if m.max_ham('emigrants','streaming') == True && m.max_ham('teardrop','predated') == False:
        completed += 1
    else:
        methodsNotWorking.append("max_ham")

    print("You completed " + str(completed) + " tasks.")
    if completed != 5:
        print("The following are not working:")
        for method in methodsNotWorking:
            print("\t" + method)
    else:
        print("Congratulations!")


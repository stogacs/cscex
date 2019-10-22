import main as m

if __name__ == '__main__':
    completed = 0
    methodsNotWorking = []

    if m.karacaEncrypt("compsciclub") == "b4lc2cspm3caca":
        completed += 1
    else:
        methodsNotWorking.append("karacaEncrypt")

    if m.convertToHex("compsciclub") == "63 6f 6d 70 73 63 69 63 6c 75 62":
        completed += 1
    else:
        methodsNotWorking.append("convertToHex")

    if m.moran(132) == "H" and m.moran(133) == "M" and m.moran(134) == "Neither":
        completed += 1
    else:
        methodsNotWorking.append("moran")

    print("You completed " + str(completed) + " tasks.")
    if completed != 3:
        print("The following are not working:")
        for method in methodsNotWorking:
            print("\t" + method)
    else:
        print("Congratulations!")


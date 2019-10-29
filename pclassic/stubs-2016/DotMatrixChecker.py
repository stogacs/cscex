def draw_dot_matrix_letter(N):
    letter = ""
    #write ur code here
    
    return letter

#DONT CHANGE THIS SHIT - THIS WILL BE PROVIDED (I DONT KNOW ENOUGH PYTHON TO FIX IT)
if __name__ == "__main__":
    with open("DotMatrixCheckerIN.txt", "r") as f:
        while True:
            s = f.readline()
            if s == '':
                break
            N = int(s)
            print(draw_dot_matrix_letter(N))

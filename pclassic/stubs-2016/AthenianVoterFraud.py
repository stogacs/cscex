def athenian_voter_fraud(votes):
    """

    :param votes: list containing the identifier for every ballot which was submitted
    :return: list of identifiers of voters who voted more than once
    """
    #write your code here
   
    

#TOUCH THIS, YOU MUSNT
def parse_file_and_call_function():
    with open("AthenianVoterFraudIN.txt", "r") as f:
        for line in f:
            votes = [int(vote) for vote in line.split(',')]
            out = ','.join(
                [str(vote) for vote in sorted(athenian_voter_fraud(votes))])
            if len(out) > 0:
                print(out)
            else:
                print ('none')


if __name__ == "__main__":
    parse_file_and_call_function()

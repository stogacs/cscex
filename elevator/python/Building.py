from Elevator import Elevator

class Building:

    allPassengers = []
    elevator = None

    def __init__(self, allpassengers):
        if allpassengers is None:
            raise Exception("Passengers cannot be None")

        self.elevator = Elevator(self)
        self.allPassengers = allpassengers

    def run(self):
        # You will implement this function
        pass

    def getPassengersOnFloor(self, floor):
        floor_passengers = []
        for p in self.allPassengers:
            if p.getCurrentFloor() == floor:
                floor_passengers.append(p)
        return floor_passengers

    def getAllPassengers(self):
        return self.allPassengers

    def getElevator(self):
        return self.elevator
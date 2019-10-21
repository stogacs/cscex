class Passenger:

    currentFloor = 0
    destinationFloor = 0

    def __init__(self, currrentfloor, destinationfloor):
        self.currentFloor = currrentfloor
        self.destinationFloor = destinationfloor

    def arrived(self):
        return self.currentFloor == self.destinationFloor

    def getCurrentFloor(self):
        return self.currentFloor

    def setCurrentFloor(self, currentfloor):
        self.currentFloor = currentfloor

    def getDestinationFloor(self):
        return self.destinationFloor

    def __str__(self):
        return "Passenger{" + "currentFloor=" + self.currentFloor + ", destinationFloor=" + self.destinationFloor + "}"
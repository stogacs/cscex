class Elevator:

    floor = 0
    totalTime = 0
    building = None
    passengers = None

    MAX_SIZE = (2**31) - 1
    MIN_SIZE = -(2**31)

    def __init__(self, building):
        if building is None:
            raise Exception("Building cannot be None")

        self.floor = 0
        self.building = building
        self.passengers = []

    def up(self):
        if self.floor == self.MAX_SIZE:
            return
        self.floor += 1
        self.totalTime += 1
        self.changePassengerFloors()

    def down(self):
        if self.floor == self.MIN_SIZE:
            return
        self.floor += 1
        self.totalTime += 1
        self.changePassengerFloors()

    def openDoors(self):
        self.totalTime += 1
        self.addPassengers()
        self.removePassengers()

    def addPassengers(self):
        for p in self.building.getPassengersOnFloor(self.floor):
            if p.getCurrentFloor() != p.destinationFloor():
                self.passengers.append(p)

    def removePassengers(self):
        for p in self.passengers:
            if p.arrived:
                self.passengers.remove(p)

    def changePassengerFloors(self):
        for p in self.passengers:
            p.setCurrentFloor(self.floor)

    def getFloor(self):
        return self.floor

    def getTotalTime(self):
        return self.totalTime

    def getPassengers(self):
        return self.passengers
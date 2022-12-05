## deque (double sided queue) implementation

class Deque():
    def __init__(self):
        self.deque = []

    def get_deque(self):
        return self.deque

    def isEmpty(self):
        return len(self.deque)==0

    def size(self):
        return len(self.deque)

    def addFront(self, ele):
        self.deque.insert(0, ele)

    def addRear(self, ele):
        self.deque.append(ele)

    def removeFront(self):
        self.deque.pop(0)

    def removeRear(self):
        self.deque.pop()


myDeque = Deque()
even = [x for x in range(1, 11, 2)]
myDeque.addRear(even)

myDeque.addFront(100)
myDeque.addRear(200)
myDeque.addFront(250)
myDeque.addRear(400)

print(myDeque.get_deque())

myDeque.removeFront()
myDeque.removeRear()

print(myDeque.get_deque())


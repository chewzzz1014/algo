# rear at front of list; front at the end of list

class Deque:
    def __init__(self):
        self.dequeue = []

    def isEmpty(self):
        return len(self.dequeue) == 0

    def addFront(self, item):
        self.dequeue.append(item)

    def addRear(self, item):
        self.dequeue.insert(0, item)

    def removeFront(self):
        return self.dequeue.pop()

    def removeRear(self):
        return self.dequeue.pop(0)

    def size(self):
        return len(self.dequeue)

if __name__ == '__main__':
    d = Deque()
    print(d.isEmpty())
    d.addRear(4)
    d.addRear('dog')
    d.addFront('cat')
    d.addFront(True)
    print(d.size())
    print(d.isEmpty())
    d.addRear(8.4)
    print(d.removeRear())
    print(d.removeFront())
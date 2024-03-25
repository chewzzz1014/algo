
class CircularQueue:
    def __init__(self, size):
        self.elements = [None] * self.size
        self.size = size
        self.front = -1
        self.rear = -1

    def enqueue(self, item):
        if self.is_empty():
            self.front = 0
        if self.is_full():
            self.rear = (self.rear+1)%self.size
        self.elements[self.rear] = item

    def dequeue(self):
        if not self.is_empty():
            element = self.elements[self.front]
            self.front += 1
            if self.front == self.rear:
                self.front = -1
                self.rear = -1
            return element
        return None

    def is_empty(self):
        return self.front<0

    def is_full(self):
        return (self.rear+1) == (self.size-1)
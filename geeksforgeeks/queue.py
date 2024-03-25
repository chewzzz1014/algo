# enqueue, dequeue, peek, isEmpty, isFull

class Queue:
    def __init__(self):
        self.elements = []
        self.front = -1
        self.rear = -1

    def enqueue(self, item):
        # enqueue first element
        if self.is_empty():
            self.front += 1
        self.rear += 1
        self.elements.append(item)

    def dequeue(self):
        element = self.elements[self.front]
        self.front += 1
        if self.front == self.rear:
            self.front = -1
            self.rear = -1
        return element

    def peek(self):
        if self.front > -1:
            return self.elements[self.front]
        return None

    def is_empty(self):
        return self.front == -1

    def __str__(self):
        if not self.is_empty():
            return ", ".join(map(str, self.elements[self.front: self.rear]))
        return "[]"


q = Queue()
q.enqueue(1)
q.enqueue(2)
q.enqueue(3)
q.enqueue(4)
q.enqueue(5)
print(q)
q.dequeue()
print("After removing an element", q)
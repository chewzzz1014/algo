# Implementation of circular queue
import random

class CircularQueue():
    def __init__(self, size):
        self.size = size
        self.queue = [None] * size
        self.head = self.tail = -1

    def enqueue(self, ele):
        # the queue is full (even after circularly increment)
        if ((self.tail+1) % self.size == self.head):
            print("Circular queue is full!")

        # queue is empty
        elif (self.head == -1):
            self.head = 0
            self.tail = 0
            self.queue[self.tail] = ele

        # add it
        else:
            self.tail = (self.tail + 1) % self.size
            self.queue[self.tail] = ele

    def dequeue(self):
        # if queue is empty
        if (self.head==-1):
            print("The circular queue is empty!")

        # if empty
        elif(self.head == self.tail):
            temp = self.queue[self.head]
            self.head = -1
            self.tail = -1
            return temp

        # remove it
        else:
            temp = self.queue[self.head]
            self.head = (self.head+1)%self.size
            return temp


    def print_queue(self):
        if (self.head==-1):
            print("No element in circular queue")

        elif (self.tail >= self.head):
            for i in range(self.head, self.tail+1):
                print(self.queue[i], end=" ")
            print()

        # circularly print them
        else:
            for i in range(self.head, self.size):
                print(self.queue[i], end=" ")
            for i in range(0, self.tail+1):
                print(self.queue[i], end=" ")
            print()


myCicularQueue = CircularQueue(8)
for i in range(8):
    myCicularQueue.enqueue(random.randint(1, 101))

myCicularQueue.print_queue()

myCicularQueue.dequeue()
print("Removed one element...")
myCicularQueue.print_queue()
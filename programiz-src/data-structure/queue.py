# implementation of queue
import random

class Queue():
    def __init__(self, max_size=100):
        self.queue = []
        self.maxSize = max_size

    def get_queue(self):
        return self.queue

    def enqueue(self, ele):
        if (not self.is_full()):
            self.queue.append(ele)

    def dequeue(self):
        if(not self.is_empty()):
            return self.queue.pop(0)
        return None

    def is_empty(self):
        return len(self.queue)==0

    def is_full(self):
        return len(self.queue)==self.maxSize

myQueue = Queue()
for i in range(20):
    myQueue.enqueue(random.randint(1, 100))

print("Current waiting list:", myQueue.get_queue())

for i in range(5):
    print("Order Number:", myQueue.dequeue(),"\nYour food is ready!\n")
    print("Current waiting list:", myQueue.get_queue())
# Implementation of heap
# Heapify is IMPORTANT!!!!!!!
import random

class Heap:
    def __init__(self):
        self.array = []


    def heapify(self, i):
        # i is index for current element
        # let i be the index for largest element
        largest = i
        l = 2 * i + 1
        r = 2 * i + 2

        if l<len(self.array) and self.array[l]>self.array[largest]:
            largest = l

        if r<len(self.array) and self.array[r]>self.array[largest]:
            largest = r

        if largest != i:
            # swap them
            self.array[largest], self.array[i] = self.array[i], self.array[largest]
            # recursively call it
            self.heapify(largest)


    def insert(self, newNode):
        if len(self.array) == 0:
            self.array.append(newNode)
        else:
            self.array.append(newNode)
            for i in range( len(self.array)//2-1, -1, -1 ):
                self.heapify(i)


    def delete(self, nodeToBeDeleted):
        size = len(self.array)
        i = 0
        for i in range(0, size):
            if nodeToBeDeleted == self.array[i]:
                break

        self.array[i], self.array[size-1] = self.array[size-1], self.array[i]

        self.array.remove(nodeToBeDeleted)

        for i in range(size//2-1, -1, -1):
            self.heapify(i)


my_heap= Heap()
for _ in range(10):
    my_heap.insert(random.randint())

print("Max-Heap array: " + str(my_heap))

my_heap.delete(my_heap.array[4])

print("After deleting an element: " + str(my_heap))

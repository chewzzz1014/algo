# implementation of linked list in python
# each item (also known as node) in the list hold data and reference to next node
from Node import Node

# linked list must maintain a reference to the first node
# list itself does not contain any node object, but it only contains a single reference to first node
class UnorderedList:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head == None

    # newly inserted item becomes head of list
    def add(self, item):
        temp = Node(item)
        temp.setNext(self.head)
        self.head = temp

    # method size, search, remove are based on linked list traversal
    def size(self):
        current = self.head
        count = 0
        # traversal
        while current != None:
            count += 1
            current = current.getNext()
        return count

    def search(self, item):
        current = self.head
        found = False
        while current!=None and not found:
            if current.getData() == item:
                found = True
            else:
                current = current.getNext()
        return found

    def remove(self, item):
        current = self.head
        previous = None
        found = False

        while not found:
            if current.getData() == item:
                found = True
            else:
                previous = current
                #  known as “inch-worming” as previous must catch up to current before current moves ahead
                current = current.getNext()

        if previous == None:
            self.head = current.getNext()
        else:
            previous.setNext(current.getNext())

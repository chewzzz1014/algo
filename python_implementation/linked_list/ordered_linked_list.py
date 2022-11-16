from Node import Node
class OrderedList:
    def __init__(self):
        self.head = None

    def size(self):
        current = self.head
        count = 0
        # traversal
        while current != None:
            count += 1
            current = current.getNext()
        return count

    def isEmpty(self):
        return self.head == None

    def search(self, item):
        current = self.head
        found = False
        stop = False

        while current != None and not found and not stop:
            if current.getData() == item:
                found = True
            else:
                if current.getData() > item:
                    stop = True
                else:
                    current = current.getNext()

        return found

    # the items in the ordered list are in ascending order
    def add(self, item):
        current = self.head
        previous = None
        stop = False

        while current != None and not stop:
            if current.getData() > item:
                stop = True
            else:
                previous = current.getNext()
                current = current.getNext()

        temp = Node(item)
        if previous == None:
            temp.setNext(self.head)
            self.head = temp
        else:
            temp.setNext(current)
            previous.setNext(temp)
# implementation of stack

class Stack():
    def __init__(self, max_size=100):
        self.stack = []
        self.maxSize = max_size

    def get_stack(self):
        return self.stack

    def push(self, ele):
        if (not self.isFull()):
            self.stack.append(ele)

    def pop(self):
        self.stack.pop()

    def isEmpty(self):
        return (len(self.stack) == 0)

    def isFull(self):
        return (len(self.stack)==self.maxSize)


myStack = Stack()
for i in range(1, 27, 2):
    myStack.push(i)

print(myStack.get_stack())

myStack.pop()
myStack.pop()

print(myStack.get_stack())
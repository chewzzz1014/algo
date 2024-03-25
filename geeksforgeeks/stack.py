# push, pop, peek, isEmpty, isFull

class Stack:
    def __init__(self):
        self.elements = []

    def push(self, item):
        self.elements.append(item)

    def pop(self):
        if not self.is_empty():
            return self.elements.pop()
        return None

    def peek(self):
        if not self.is_empty():
            return self.elements[len(self.elements) - 1]
        return None

    def is_empty(self):
        return len(self.elements) == 0

    def __str__(self):
        return "[" + ", ".join(map(str, self.elements)) + "]"

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
print(f"Popped: {stack.pop()}")
print(f"Top element: {stack.peek()}")
print("stack after popping an element: " + str(stack))
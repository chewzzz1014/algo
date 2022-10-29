# implementation of stack in Python

class Stack:
    def __init__(self):
        self.stack = []

    def size(self):
        return len(self.stack)

    def isEmpty(self):
        return self.size() == 0

    def peek(self):
        if not self.isEmpty():
            return self.stack[-1]
        else:
            return "Stack is Empty!"

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        return self.stack.pop()

    def __str__(self):
        # x = [str(x) for x in self.stack]
        return ", ".join([str(x) for x in self.stack])

# use stack to reverse string
def revstring(myStr):
    s = Stack()
    rS = []
    for x in myStr:
        s.push(x)
    while not s.isEmpty():
        rS.append(s.pop())
    return "".join(rS)



s = Stack()

print(s.isEmpty())
s.push(4)
s.push('dog')
print(s.peek())
s.push(True)
print(s.size())
print(s.isEmpty())
s.push(8.4)
print(s.pop())
print(s.pop())
print(s.size())
print(s)
print(revstring("hello world"))
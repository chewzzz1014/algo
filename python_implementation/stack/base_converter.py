from stack import Stack
# convert decimal to binary using stack

def to_binary(n):
    s = Stack()
    binary = []

    while n > 0:
        s.push(n%2)
        n = n // 2

    while not s.isEmpty():
        binary.append(str(s.pop()))

    return "".join(binary)

def to_base(n, base):
    s = Stack()
    binary = []

    while n > 0:
        s.push(n%base)
        n = n // base

    while not s.isEmpty():
        binary.append(str(s.pop()))

    return "".join(binary)

print(to_binary(25))
print(to_binary(42))
print(to_base(25, 16))
print(to_base(25, 8))
print(to_base(256, 16))
print(to_base(26, 26))
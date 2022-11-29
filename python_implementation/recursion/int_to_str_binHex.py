# convert an integer to a string in base 2-16
from pythonds.basic import Stack

rStack = Stack()

def toStr(n, base):
    convertStr = '0123456789ABCDEF'
    while n > 0:
        if n < base:
            rStack.push(convertStr[n])
        else:
            rStack.push(convertStr[n%base])
        n = n // base
    res = ''
    while not rStack.isEmpty():
        res += str(rStack.pop())
    return res


print(toStr(1453, 16))
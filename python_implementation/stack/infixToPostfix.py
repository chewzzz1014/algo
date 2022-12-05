from stack import Stack


def infix_to_postfix(myStr):
    prec = {}
    prec["*"] = 2
    prec["/"] = 2
    prec["-"] = 1
    prec["+"] = 1
    prec["("] = 0

    my_list = myStr.split()
    s = Stack()
    outputs = []

    for c in my_list:
        if c == "(":
            s.push(c)
        elif c in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" or c in "1234567890":
            outputs.append(c)
        elif c == ")":
            top = s.pop()
            while top != "(":
                outputs.append(top)
                top = s.pop()
        elif c in "+-/*":
            while not s.isEmpty() and prec[s.peek()]>prec[c]:
                outputs.append(s.pop())
            s.push(c)

    while not s.isEmpty():
        outputs.append(s.pop())

    return " ".join(outputs)

print(infix_to_postfix("A * B + C * D"))
print(infix_to_postfix("( A + B ) * C - ( D - E ) * ( F + G )"))
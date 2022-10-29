from stack import Stack

def check_balanced_parentheses(myStr):
    myStack = Stack()
    is_balanced = True
    idx = 0
    while idx<len(myStr) and is_balanced:
        c = myStr[idx]

        if c == '(':
            myStack.push(c)
        elif c == ')':
            if myStack.isEmpty():
                is_balanced = False
            else:
                myStack.pop()
        idx += 1

    return (is_balanced and myStack.isEmpty())

print(check_balanced_parentheses("(()()()())"))
print(check_balanced_parentheses("(()"))
print(check_balanced_parentheses("((hello)))66()"))
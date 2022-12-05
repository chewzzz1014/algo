from stack import Stack

opens = "([{"
closers = ")]}"

def is_balanced_symbol(myStr):
    s = Stack()
    is_balanced = True
    idx = 0

    while idx<len(myStr) and is_balanced:
        c = myStr[idx]

        if c in "[{(":
            s.push(c)
        elif c in "]})":
            if s.isEmpty():
                is_balanced = False
            else:
                open = s.pop()
                if not opens.index(open) == closers.index(c):
                    is_balanced = False
        idx += 1

    return (is_balanced and s.isEmpty())

print(is_balanced_symbol("((()}]))"))
print(is_balanced_symbol("{({([][])}())}"))
print(is_balanced_symbol("[{()]"))
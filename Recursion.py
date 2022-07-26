# recursive function that uses the call stack

# call stack (bottom to top) for x = 3:
# {} => {x=3} => {x=3, x=2} => {x=3, x=2, x=1}

# when x = 1, return 1. The stack x=1 is removed:
# { x=3, x=2, x=1} => return 1 => {x=3, x=2} => return (2*factorial(1)), that is 2*1, 2 => {x=3} => return (3*factorial(2)), that is 3*2, 6 => {}

def factorial(x):
    # base case
    if x == 1:
        return 1

    # recursive case
    else:
        return x * factorial(x-1)
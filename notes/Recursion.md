- Recursive Function: A function that calls itself.
- Components of recursion:  Base Case and Recursive Case
- Base Case: When the function doesn't call itself again.
- Recursive Case: When the function calls itself


        def countdown(i):
            print(i)
            
            # base case
            if i <= 0:
                return

            # recursive case
            else:
                countdown(i-1)

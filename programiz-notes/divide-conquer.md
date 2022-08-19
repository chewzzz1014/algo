## Divide and Conquer Algorithm
- A strategy of solving a large prob by:
  1. Break prob into smaller sub-probs
  2. Solving the sub-prob
  3. Combining theme to get the desired output
- Recursion required

- Steps:
  1. Divide: Divide given prb into sub-prb using recursion
  2. Conquer: Solve smaller sub-prob recursively. If subprob is small enough, solve it directly.
  3. Combine: Combine the solution of sub-prob that're part of recursive process to solve the actual prob.

## Divide and Conquer Vs Dynamic Approach
- For D&C, the result of each subproblem is not stored for future reference.
- For dynamic approach, the result for each subproblem is stored for future reference.
- Example (find the fibonacci series):
  - Divide and Conquer
    ```
    fib(n)
        If n<2, return 1
        Else, return f(n-1)+f(n-2)
    ```
  - Dynamic Approach
    ```
    mem = []
    fib(n)
        If n in mem: return mem[n]
        
        else, 
            If n<2, f=1
            else, f=f(n-1) + f(n-2)
            mem[n] = f
            return f
    ```
 
## Divide and Conquer Application
- Binary Search
- Merge Sort
- Quick Sort
- Strassen's Matrix Multiplication
- Karatsuba Algorithm

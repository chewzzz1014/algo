## Asymptotic Analysis
- Measure the efficiency of an algorithm, that depend on amount of time, storage and other resources.
- Asymptotic notations are the mathematical notations used to describe the running time of an algorithm when the input tends towards a particular value or a limiting value.
- Best Case: In bubble sort, when the input array is already sorted, the time taken by the algorithm is linear
- Worst Case: Input array is in reverse condition, the algorithm takes the maximum time (quadratic) to sort the elements
- 3 asymptotic notations:
  - Big-O notation
  - Omega Notation
  - Theta Notation

## Big-O Notation (O-notation)
- Represents the upper bound of the running time of an algorithm.
- Gives the worst-case complexity of an algorithm
- `O(g(n)) = { f(n): there exist positive constants c and n0 such that 0<= f(n) <= cg(n) for all n>= n0`
- f(n) belongs to the set O(g(n)) if there exist...
- For any value of n, the running time of an algorithm does not cross the time provided by O(g(n)) 

## Omega Notation 
- Represents the lower bound of the running time of an algorithm.
- Provded best case complexity of an algorithm.
- `Omega(g(n)) = { f(n): there exists positive constants c and n0 such that 0<= cg(n) <= f(n) for all n>= n0 }`

## Theta Notation (θ-notation)
- Encloses function from above and below.
- Represents the upper and lower bound of running time of an algorithm
- Analyzing average-case complexity of an algorithm.
- `θ(g(n)) = { f(n): there exist potitive constants c1m c2 and n0 such that 0<= c1g(n) <= f(n) <=c2g(n) for all n>=n0}`


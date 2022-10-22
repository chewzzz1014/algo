- Linear Time `O(n)`: Maximum number of guesses = Size of list
- Logarithmic Time/Log Time `O(log n)`: Number of guesses os much smaller than size of list (eg, If the list is 100 items long, it takes at most 7 guesses. If the list is 4 billion items, it takes at most 32 guesses.)
## Big O Notation
- Notation that tells how fast an algorithm is and how fast an algorithm grows.
- O(Number of Operations)
- Example: 
   - Supposed a list of size `n`. 
   - Simple search checks every element and thus take n operations. Runtime is`O(n)`.
   - Binary search takes log(n) operations to search n elements and thus has run time of `O(log(n))`.
- Best Case: Found the target at the first try
- Worse Case: Found the target at the last try
- Average Case:

|Big O (Fastest to Slowest)|Example|
|-----|------|
|O(log n)|Binary Search|
|O(n) | Simple Search|
|O(n log n) | Quicksort|
|O(n^2)|Selection Sort|
|O(n!)|Traveling salesperson|
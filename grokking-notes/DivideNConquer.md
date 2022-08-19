- Divide and Conquer Algorithm: A recursive algorithm
- Steps:
  1. Figure out the base case (simplest possible case)
  2. Divide / decrease the problem until it becomes the base case

- Quick Sort `O(n log n)`: 
   1. Determine base case (when length of array is less than 2).
   2. Choose any element as pivot. Free to choose any element, but middle element as pivot requires smaller call stack size.
   3. Find elements smaller than pivot and elements larger than pivot.
   4. Now we have 1 sub-array of numbers smaller than pivot, pivot, 1 sub-array of numbers larger than pivot. Both sub-arrays aren't sorted but just partitioned.
   5. Call quicksort recursively on the 2 sub-arrays.

- Example:
    - Calculate an array of numbers.
    - Base case: Array with only 0 or 1 element.
    - Recursive case: Move closer to empty array with every recursive call.

             sum ([2, 4, 6])              12
              :arrow_down:               :arrow_up:
      
            2 + sum([4, 6])             2 + 10 = 12
              :arrow_down:               :arrow_up:
      
            4 + sum([6])                4 + 6 = 10
              :arrow_down:
      
            Base case: sum([6]) = 6    :arrow_upper_right:

  

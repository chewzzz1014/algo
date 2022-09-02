## The linear search algorithm

Linear search (or sequential search) is a simple algorithm for searching an element with a specific value in the array. The algorithm checks each array element until it finds the target value or reaches the array end.

In the worst case, it performs exactly nnn comparisons, where nnn is the length of the input array. The time complexity is O(n).

## Example

Suppose we have an array of 666 elements:

![image](https://user-images.githubusercontent.com/92832451/188074117-7147293d-f934-4c52-969f-d06914eb6c0f.png)

Our goal is to find the index of an element with the value 202020. We will start from the first element with index 111 and compare each array element with the target value until we find the target value.


![image](https://user-images.githubusercontent.com/92832451/188074152-74bffb39-882a-4cbc-ba24-a3b52821f5cb.png)


As you may see, the linear search is a simple algorithm with an important advantage: it can search in unsorted arrays.

## Pseudocode of the linear search function
```
  function found_value(array, value):
      for index in [1, len(array)]:      // looking through the array
          if array[index] == value then  // if the current value is equal to the value we are 
                                         // searching for,
              return index               // then we return the index of this element;
      return -1                          // if the sought value is not in the array, we return -1
```

## Possible modifications

Possible modifications of the linear search algorithm are:

- check whether the array contains an element, return true or false;
- search for the first or the last occurrence of an element in the array;
- count all occurrences of an element in the array;
- search for all occurrences of an element in the array;
- search for an element in the subarray of the array with the given indices.

Also, the linear search algorithm can be used as a subroutine in more complex algorithms. For example, to count all occurrences of all array elements in another array.

If we know that our array is sorted (e.g. in ascending order), we could modify the linear search algorithm. If the next checked element is greater than the target value, it means we will not find the value in the rest of the array, and the algorithm should stop. In the next topics, we will examine how to make searching in sorted arrays more effective.

[Here is a visualization of the algorithm](https://www.cs.usfca.edu/~galles/visualization/Search.html). To see it, enter the target value and select Linear Search at the top of the page.


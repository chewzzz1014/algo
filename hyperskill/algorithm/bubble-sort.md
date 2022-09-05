## Bubble Sort
Bubble sort is one of the simplest sorting algorithms. It repeatedly goes through the array we want to sort, compares each pair of adjacent elements, and swaps them if they are in the wrong order.

The wrong and correct orders depend on the required sorting order. If we need to sort the array in ascending order, the wrong order is when the previous element is greater than the next one. If we need to sort the array in descending order, the wrong order is the case when the previous element is smaller than the next one.

This algorithm is not suitable for large arrays, since its average and worst-case time complexity is O(n<sup>2</sup>), where n is the array length.

The algorithm is stable: it doesn't change the relative order of identical elements.

## Example
Suppose we have an unsorted array of integers and we want to sort it in ascending order. 

![image](https://user-images.githubusercontent.com/92832451/188384585-9c34eb24-3e97-48eb-bc6e-c4985a56ebee.png)

The array has six elements, the first element has the index 0, the last one has the index 5.

The following image illustrates how the bubble sort algorithm works step by step. The array is sorted in ascending order.

![image](https://user-images.githubusercontent.com/92832451/188384630-fbd26138-8953-4392-8cf9-bd5bbfa24ad9.png)

In a loop, the algorithm compares each pair of adjacent array elements and swaps them if they are in the wrong order (dark blue color). If the order is correct (blue color), it does not do anything to the elements.

As you can see, the max elements gradually float to the end of the array, which justifies the name of the algorithm. The algorithm doesn't swap elements in the right sorted part.

To get a better idea of how the algorithm works, you can have a look at a [visualization](http://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html).

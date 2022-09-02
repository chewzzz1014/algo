## Sorting
The sorting problem often arises in programming practice and is one of the most studied problems in computer science. There are a lot of different algorithms for solving the problem. Often, sorting is the basic building block for other algorithms; hence, understanding sorting is integral to solving many other problems.

## What is sorting?

It is very often that we have to organize a sequence of elements. The required order can be ascending or descending. Usually, the ascending order is considered a default.

To represent sequences of elements, many languages support arrays or/and lists.

Here is an array of six elements:

![image](https://user-images.githubusercontent.com/92832451/188082778-effd0a76-a52c-4a82-9277-35f0d03b7524.png)

As a sorting result, we get another array of the same size:

![image](https://user-images.githubusercontent.com/92832451/188082805-e855499d-262f-49e2-9015-d1595c313f33.png)

Many programming languages provide built-in algorithms for sorting lists and arrays. There are many different sorting algorithms in computer science, and in the following sections we will learn their basic principles.

## What can we sort?

It is possible to sort data of different types:
- numbers in accordance with the arithmetic order;
- Unicode characters in accordance with their order in the Unicode character table;
- strings (lexicographically or by size);
- dates and times in accordance with the chronological order.

Also, it's often possible to sort data of more complex types if we know how to compare items. As a rule, such data has one or more fields called sorting keys, by which sorting is performed.

## Key features of sorting algorithms

- Time efficiency. The size of an array we want to sort is very important for efficiency. If we want to sort an array consisting of a few dozen elements, we can use any sorting algorithm. But what if the array contains a lot of data? In that case, we should use more effective sorting algorithms, otherwise, the results might take too long.

- Stability. An array may contain several identical elements. Stable sorting algorithms always sort identical elements in the same order as they appear in the input. Otherwise, the sorting algorithm is unstable. Stability is important when we sort complex structures such as objects, strings, or something else.

- In-place/out-of-place sorting. An algorithm performs in-place sorting if it requires only a constant amount of additional space, otherwise, the algorithm performs out-of-place sorting. The larger the size of the array, the more additional memory out-of-place algorithms require.

- Internal or external sorting. An algorithm performs internal sorting if the data is kept entirely within the main memory of the computer. In turn, we need external sorting when the data does not fit into the main memory of the computing device. In such a case, we keep it in the slower external memory (usually a hard drive).


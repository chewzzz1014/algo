## The big O notation 
Suppose you need to choose one of several algorithms to solve a problem. How can you pick the best one? To do it, you need to measure the algorithm efficiency somehow.

One of the options might be to measure the time your program needs to process its input. However, different computers may take different time to process the same data. Furthermore, the processing time may depend on the data itself. We obviously need something more universal. So, let's try to estimate the efficiency using big O notation.

## Input Size
What does an algorithm usually do? It makes some calculations. Let's call operations the basic actions, such as addition, multiplication, comparison, variable assignment, etc. Of course, the calculation time depends on the machine, but it doesn't matter now because we want to compare algorithms, not machines. Now let's try to estimate the number of operations in an algorithm!

![image](https://user-images.githubusercontent.com/92832451/187607543-208b4685-83eb-4d4a-9281-d2fec68e0ad4.png)


Buses aren't always punctual, are they? One day it may happen that they are there on time, while the other day they will take a lifetime to arrive. You can't blame solely the driver for that: the time of the trip depends directly on the number of passengers on the bus. The more passengers, the more stops, the longer the time to arrive. Likewise, the running time of an algorithm depends on the input data. Naturally, the program will take a different time to proceed with 10 or 1 000 000 numbers. We will use the term input size as a proxy measure of the size of input data. If you need to work with m numbers, then m is the input size. The input size isn’t always the amount of the input data itself. If you need to find the first nnn prime numbers, then searching for 10 first primes or 10 000 first primes will also take a different time, however, you only enter a single number n as input. In such cases, that number’s value is typically considered the input size.


If we can estimate how the number of operations depends on the input size, we will have a machine-independent measure of algorithm complexity. This is exactly what we need! Also, if we want to find a good algorithm, we are mostly interested in its behavior with big data. For this, we can compare the behavior of the algorithm’s running time with some standard functions.

## Big O Notation
As we already mentioned, we will use the big O notation to measure the efficiency of algorithms. As a matter of fact, we have borrowed this symbol from mathematics; however, we shall not worry about the mathematical meaning or definition of the big O. Less formally, we can say that an algorithm has the time complexity O(f(n)) if its number of operations grows bigger similar to (or slower than) the function f(n) when the input size nnn is a large number. In order to avoid unnecessary abstractness, let's consider the following task: given a n×n tables table with integers in its cells. Find the number k in the given table.

![image](https://user-images.githubusercontent.com/92832451/187607807-ce3e539a-a140-4e15-baea-21ea749d1d6a.png)


Alice and Bob have come up with their own algorithms to solve the problem. Bob's algorithm consists in scanning every cell of the table and checking if the corresponding value is equal to k. Well, this implies a maximum of n<sup>2</sup> comparisons, which means that the time complexity of Bob's algorithm is O(n<sup>2</sup>). On the other hand, Alice somehow knows earlier in which column the number k will be located, hence, she only needs to scan the elements of that column. A column consists of nnn cells, meaning that Alice's algorithm will take O(n) time.

Basically, on a table 2×2, Bob will have to perform a maximum of 4 operations; meanwhile, Alice will perform no more than 2. Not a big difference really, is it? What if we have a table n×n for a large n? In this case, n<sup>2</sup> will be considerably bigger than n, as shown below. This is exactly what determines the efficiency of an algorithm – the way it behaves with large input sizes. Hence, we conclude that Alice's algorithm is faster than Bob's, as the big O notation suggests.

However, a simple question arises: why can't we write simply n<sup>2</sup> or n for the complexities? Why do we need to add this beautiful round letter in front of these functions? Well, imagine that the element k is placed in the first cell of the table. Bob will find it immediately and terminate his algorithm. How many steps does he perform: n<sup>2</sup>? No, just one.


![image](https://user-images.githubusercontent.com/92832451/187607930-71a80e91-1cfa-4cfa-ac8d-843e8ef3c528.png)

That is why we use the big O: roughly speaking, it describes the upper bound for the function's growth rate. This is one of the big O notation's essential advantages. It means that you can calculate how much time to allocate for processing a certain amount of input data and be sure that the algorithm will process it all in due time. In practice, an algorithm might sometimes work even better than what the big O notation shows for its complexity, but not worse.

## Common growth rates

Below are, from best to worse, some common values of the big O function for the time complexity, also known as complexity classes.

- O(1) (constant time). The algorithm performs a constant number of operations. Maybe one, two, twenty-six, or two hundred – it doesn't matter. What is important is that it doesn't depend on the input size. Typical algorithms of this class include calculating the answer using a direct formula, printing a couple of values, all letters of the English alphabet, etc.

- O(log ⁡n)(logarithmic time). Perhaps a quick reminder on logarithms is necessary. We usually refer to logarithms of base 2; however, the base does not affect the class. By definition, log<sub>2</sub>n equals the number of times nnn must be divided by 222 to get 111. That being said, it should not be difficult to guess that such algorithms divide the input size into halves at each step. They are relatively fast: if the size of the input is huge, say, 2<sup>31</sup> (programmers should know the importance of this number), the algorithm will perform approximately log<sub>2</sub>(2<sup>31</sup>) = 31 operations, which is pretty effective.

- O(n) (linear time). The time is proportional to the input size, i.e., the time grows linearly as the input size increases. Often, such algorithms are iterated only once. They occur quite frequently, because it is usually necessary to go through every input element before calculating the final answer. This makes the O(n)O(n)O(n) class one of the most effective classes in practice.

- O(n<sup>2</sup>) (quadratic time). Normally, such algorithms go through all pairs of input elements. Why? Well, mathematics is generous, it constantly provides us with important results: in this case, basic maths confirms that the number of unordered pairs in a set of nnn elements is equal to n(n−1)/2, which, as we will learn later in this topic, is O(n<sup>2</sup>). If you find it scary or difficult to understand, it is completely normal, it happens to the best of us. On the other hand, for those who are familiar with programming terms, the following sentence might come in handy: quadratic time algorithms usually contain two nested loops.

- O(2<sup>n</sup>) (exponential time). Just in case, let's mention that 2<sup>n</sup> is the same as multiplying 2 by itself n times. Again, maths states that the number of subsets of a set of nnn elements is equal to 2<sup>n</sup>, therefore, it is reasonable to expect that such algorithms scan all the subsets of the input elements. It is worth noting that this class is extremely inefficient in practice; even for small input sizes, the time taken by the algorithm will be remarkably high.

![image](https://user-images.githubusercontent.com/92832451/187609538-c4163a22-fdc7-4a6b-a8b7-6a0a9de25a24.png)


## Calculating complexity

Let's look at a simple example. You want to find the maximum of nnn numbers. You will probably decide to go through them and compare every new element with the maximum so far. You will make nnn comparisons, so the time complexity is O(n).

However, algorithms are usually quite complex and consist of several steps, whose time complexity may belong to different time complexity classes from the list above. Therefore, to be able to calculate complexities by yourself, it is essential for you to get familiar with the basic properties of the Big O:

![image](https://user-images.githubusercontent.com/92832451/187609618-460dcbff-fe3c-49a4-b8bb-5bfb67d40a8c.png)

![image](https://user-images.githubusercontent.com/92832451/187609653-a523ac1f-3bca-4b0e-965d-3965d4c649fb.png)


![image](https://user-images.githubusercontent.com/92832451/187609680-faf4c775-5442-4b6c-80b9-b5a1d58d5d66.png)


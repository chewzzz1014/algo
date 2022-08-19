## Trees
- Binary search tree: Each node has maximum of 2 children such that left node < right node
- Searching: `O(log n)` for average and `O(n)` for the worst case

|Operation|Array|Binary Search Tree|
|---|---|---|
|Search|O(log n)|O(log n)|
|Insert|O(n)|O(log n)|
|Delete|O(n)|O(log n)|

- Other trees:
  1. B-trees
  2. Red-black trees
  3. Heaps
  4. Splay trees

## Inverted Indexes
- Usually used to build search engine
- Suppose in a hash tree, keys are words and their values are pages each word appears on.

## Fourier Transform
- Easy explanation:  given a smoothie, the Fourier transform will tell you the ingredients in the smoothie. Or, to put it another way, given a song, the transform can separate it into individual frequencies.

## Parallel Algorithm
- The best you can do with a sorting algorithm is roughly O(n log n). It’s well known that you can’t sort an array in O(n) time—unless you use a parallel algorithm
- By using parallel version of quicksort, we can sort an array in O(n) time

## Map Reduce
- Distributed algorithm to run across multiple machines, especially in running parallel algorithm that requires hundred and thousands of cores.

## Map Function
- Takes an array and applies the same function to each item in array

        arr = [x for x in range(1, 6)]
        arr1 = map(lambda x: 2 * x, arr)

## Reduce Function 
- "Reduce" a whole list of items down into one item
    
        arr = [x for x in range(1. 6)]
        reduce(lambda x, y: x+y, arr)

## Bloom filters
- Probabilistic data structure that gives an answer that could be wrong but is probably correct
- Take up very little space
- Did not have to store every value like hash table. Bloom filters are great when we don't need an exact answer.

## HyperLogLog
- Approximates the number of unique element in a set. Not exact answer but comes very closely and uses only faction of memory

## SHA Algorithm
- SHA: Secured Hash Algorithm
- Hash function that generates different for every string 
- Locality-sensitive hash function (Simhash): If you make a small change to a string, Simhash generates a hash that’s only a little different. This allows us to compare hashes and see how similar two strings are.  

## Diffie-Hellman
- Used for encryption
- Both parties don't need to know the cipher and don't have to meet and agree to what the cipher should be.
- Encrypted messages are extremely hard to decode
- Has two keys, public key and private key.

## Linear Programming
- To maximize something given some constraints.
- All the graph algorithms can be done through linear programming instead. 
- Linear programming is a much more general framework, and graph problems are a subset of that.
- Linear programming uses the Simplex algorithm.

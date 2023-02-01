## Priority Queue
- A type of queue where each element is associated with a priority value.
- All elements are served on the basis of their priority: higher priority elements are served first
- Same priority = served according to order in queue
## Assigning Priority Value
- Common rule: element with highest value is considered the highest priority element
- We can also  set priorities according to our needs

## Implementation
- Can be implemented using array, linked list, a heap or binary search tree
- Heap is the most efficient implementation of priority queues

|Operations|peek|insert|delete|
|---|---|---|---|
Linked List|O(1)|O(n)|O(1)
Binary Heap|O(1)|O(log n)|0(log n)
Binary Search Tree|O(1)|O(log n)|O(log n)

## Operations
1. Insert element into priority queue 
   - Insert new element at the end of tree
   - Heapify the tree
```
If there's no node
    create a node
else (a node ady present)
    insert newNode at the end(last node from left to right)
heapify the array
```

2. Delete an element from priority queue
   - Select the element to be deleted
   - Swap it w/ the last element
   - Remove the last element
   - Heapify the tree
```
If nodeToBeDeleted is the lastLeafNode
    remove the node
Else swap nodeToBeDeleted with the lastLeafNode
    remove nodeToBeDeleted
    
heapify the array
```

3. Peeking from Priority Queue
- Return maximum element from Max Heap or minimum element from Min Heap w/o deleting the nodes
```
return rootNote 
```

4. Extract-Max/Min
- Extract-Max returns the node with maximum value after removing it from a Max Heap
- Extract-Min returns the node with minimum value after removing it from Min Heap.

## Application
- Dijkstra's Algorithm
- Implementing stack
- Load balancing and interrupt handling in an operating system
- data compression in Huffman code
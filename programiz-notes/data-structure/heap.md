## Heap
- Complete binary tree that satisfies the heap property
- For any given node:
  - `Max Heap Property`: The node is always greater than its child node(s). Key of root node is the largest among all others nodes.
  - `Min Heap Property`: The node is always smaller than the child node/s and the key of the root node is the smallest among all other nodes
## Heapify
- Processing of creating a heap data from binary tree
```
1. Given an array, create a complete binary tree from it.

2. Start from the first index of non-leaf node, with index = [n/2 - 1]

3. Set index of current element, i as largest
        largest = i
        
4. Index of left child is given by 2i+1 and right child is given by 2i+2
        leftChild = 2i+1
        rightChild = 2i+2
        If leftChild>array[largest]:
          largest = leftChildIndex
        If rightChild>array[largest]:
          largest = rightChildIndex
          
5. Swap array[largest] and array[largest]
 ```

## Insert Element into Heap
```
If no node in array:
  create a new node
else:
  insert newNode at end
  
heapify array 
```

## Delete Element from Heap
```
If nodeToBeDeleted is leafNode:
    remove the node
Else swap nodeToBeDeleted with lastLeafNode:
    remove nodeToBeDeleted
    
Heapify array 
```


## Peek (Get Min/Max)
```
return rootNode 
```

## Application
- Implement priority queue
- Dijkstra's Algorithm
- Heap Sort
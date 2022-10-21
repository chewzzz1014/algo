## Deque / Double Ended Queue
- A type of queue in which insertion and removal of elements can either be performed from the front or rear.
## Type of Deque
- Input Restricted Deque:  input is restricted at a single end but allows deletion at both the ends.
- Output Restricted Deque: output is restricted at a single end but allows insertion at both the ends.
## Operations on Deque
- Circular Array Implementation: If the array is full, start from beginning
- Linear Array Implementation: If the array is full,  no more elements can be inserted.
## First Step
- Array of size n
- Set 2 pointers at first position, `front = -1` and `rear = 0`
## Insert at Front
``` 
1. check postion of front
2. if front < 1:
      front = n - 1
   else:
      front = front - 1
3. Add new key into array[front]
```

## Insert at Rear
```
1. If array is full:
        rear = 0
   else:
        rear = rear + 1
2. Add new key into array[rear] 
```

## Delete from Front
```
1. If deque is empty(front=-1): 
        no deletion
   else if deque has one element (front=rear):
        front = -1
        rear = -1
   else if front is at end(front=n-1):
        front = 0
   else:
        front = front + 1   
```

## Delete from Rear
``` 
1. If deque is empty (front = -1):
        no deletion
   else if deque has one element(front = rear):
        front = -1
        rear = -1
   else if rear is at front(rear=0):
        rear = n-1
   else:
        rear = rear - 1      
```

## Check Empty
- If front = -1, deque is empty
## Check Full
- If (front = 0 and rear = n-1) or (front = rear + 1) then deque is full
## Time Complexity
- All above operations have time complexity of constant, eg, O(1)
## Application 
- Undo operations in software
- Store history in browsers
- Implementing stacks and queues.
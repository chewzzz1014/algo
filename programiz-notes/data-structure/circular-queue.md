## Circular Queue
- Extended version of regular queue, where last element is connected to first element

## Working
- Circular increment: when trying to increase pointer and reach end of queue, we can start from beginning of queue
- Circular increment is performed by modulo division w/ queue size.
```
if REAR +1 == 5(overflow)
    REAR = (REAR+1)%5 
```

## Operation
- Two pointers, FRONT and REAR.
- FRONT: Track the first element of queue
- REAR: Track the last element of queue
- Initialize FRONT and REAR with -1

## Enqueue
- CHeck if the queue is full
- For first element, set FRONT = 0
- Circularly increase the REAR index by 1. (If it reaches the end, then it would be at the start of queue)
- Add element at position with index=REAR
## Dequeue
- Check if the queue is empty
- Return the value pointed by FRONT
- Circularly increase the FRONT index by 1
- For the last element, reset FRONT and REAR to -1

```
Check for full queue:
Case 1: FRONT=0 AND REAR == SIZE -1
Case 2: FRONT = REAR + 1 
```

## Complexity Analysis
- Array implementation's enqueue and dequeue: O(1)
## Application
- CPU Scheduling
- Memory Management
- Traffic Management
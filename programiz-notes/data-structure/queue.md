## Queue
- First In First Out principle
- Enqueue: Putting items in queue
- Dequeue: Removing items from queue

## Operations
- Enqueue
- Dequeue
- Peek: Get the value of the front of the queue w/o removing it
- IsEmpty
- IsFull

## Working of Queue
- FRONT: track first element of queue
- REAR: track last element of queue
- Initialize FRONT and READ with -1

## Enqueue
- Check is the queue empty
- For first element, set value of FRONT to 0
- Increase REAR index by 1
- Add new element into position pointed by REAR
##Dequeue
- Check if the queue is empty
- Return value pointed by FRONT
- Increase FRONT index by 1
- For last element, reset values of FRONT and REAR to -1

## Limitations
- After a bit of enqueuing and dequeuing, the size of the queue has been reduced.
- we can only add indexes 0 and 1 only when the queue is reset (when all the elements have been dequeued).
## Time Complexity
- Enqueue and dequeue using array: `O(1)`
- Use pop(N) in python code: `O(n)`
## Application
- CPU and disk scheduling
- When data is transferred asynchronously between two processes, eg,  IO Buffers, pipes, file IO
- Handling of interrupts in real-time systems.



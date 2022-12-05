## Stack 
- Last In First Out
- Operations: push, peek, isEmpty, isFull
- Push: Putting an item on top of stack
- Pop: Removing an item from the top of stack
- Peek: Get the value of item on the top of stack

## Working
- Use a pointer, `TOP` to keep track of the index of top element in stack.
- Start with TOP = -1
- Pushing element, TOP+=1
- Popping element , TOP-=1
- If TOP<0, stack is empty

## Time Complexity
- Push and pop operations take constant time, eg, `O(1)`

## Applications
- To reverse a word
- In compilers
- In browser
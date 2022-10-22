## Hash Function `O(1)`
- A function that maps string to number.
- Hash function needs to be consistent. We will get the same number every time we inputted the same string.
- Hash function should map diffrent words to different numbers.
- Also knowns as hash maps, maps, dictionaries, associative arrays.

### Collision
- Two keys been assigned to the same slot(value)
- Solution: If multiple keys map to the same slot, start a linked list at that slot
- However, what is one slot has too many elements in its linked list?

### Performance

|Operation|Average Case|Worse Case|
|---------|------------|----------|
|Search| O(1)|O(n)|
|Insert| O(1)|O(n)|
|Delete| O(1)|O(n)|

- To avoid collision:
    1. A low load factor
        - ` Load Factor = # of items in hash table / total # of slots`
        - Load factor = 1 indicates more items than slots in array
        - When load factor >0.7, it's time to resize the hash table
    2. A good hash function
        

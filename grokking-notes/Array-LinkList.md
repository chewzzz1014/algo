- Array: Elements are stored contiguously in memory. Faster access time and allow random access.
- Linked List: Elements are not stored contiguously. Every element will point to the address of next element. Slower access time and only allow sequential access.
- Selection sort takes `O(n^2)` time. (Takes O(n) time to look for maximum item and repeat for n times.)

|Operation|Arrays|List|
|---------|------|----|
|Reading| O(1) | O(n)|
|Insertion| O(n) | O(1) |
|Deletion|O(n)|O(1)|
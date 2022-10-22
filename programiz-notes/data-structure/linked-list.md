## Linked List
- A series of connected nodes, where each node stores the data and the address for the next node.
- Address of first node = HEAD
- Last node points to NULL
- Linked list can be of type:
  - Singly
  - Doubly
  - Circular linked list

## Representation of Linked List 
- A node consists of its data item and address for next node
```
struct node
{
    int data;
    struct node *next;
} 
```
- Pseudocode:
```
# initialize nodes
struct node *head;
struct node *one = NULL;
struct node *two = NULL;
struct node *three = NULL;

# Allocate memory 
one = malloc(sizeof(struct node));
two = malloc(sizeof(struct node));
three = malloc(sizeof(struct node));

# Assign data values 
one->data = 1;
two->data = 2;
three->data=3;

# Connect nodes 
one->next = two;
two->next = three;
three->next = NULL;

/* Save address of first node in head */
head = one; 
```

## Complexity
|Operation|Worst Case | Average Case|
|---|---|---|
|Search|O(n)|O(n)|
|Insert|O(1)|O(1)|
|Deletion|O(1)|O(1)|

## Application
- Dynamic memory allocation
- Implemented in stack and queue
- Undo functionality of softwares
- Hash tables and graphs


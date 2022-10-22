## Linked List  Operations: Traverse, Insert, Delete
- Traversal: Access each element of the linked list
- Insertion: Add new element
- Deletion: Remove existing element
- Search: Find a node in linked list
- Sort: Sort the nodes

## HEAD and NEXT in Linked List
- `head`: Point to first node of linked list
- `next`: Point to the next node. Since pointer of last node is NULL, thus, `nodeA.next = null indicates that nodeA is the last node`
## Traverse a Linked List
- Keep moving the temp node to the next one until when temp = NULL
```
temp = linkedList.head
while(temp != NULL):    
    temp = temp.next 
```

## Insert Element (Beginning/Middle/End)
1. Insert at Beginning
```
1. Allocate memory for new node
2. Store data
3. newNode.next = head
4. head = newNode
```

2. Insert at the End
```
1. Allocate memory for new node
2. Store data
3. Traverse to last node:
    temp = head
    while(temp.next != NULL)
        temp = temp.next
4. Changes next of last node to recently created node:
    temp.next = newNode
```

3. Insert at Middle
```
1. Allocate memory and store data for new node
2. Traverse to node just before the required position of new node.
3. newNode.next = temp.next
4. temp.next = newNode
```

## Delete (From beginning, middle or end)
1. Delete from Beginning
``` 
1. Point head to second node:
    head = head.next
```

2. Delete from End
```
1. Traverse to second last element
2. Changes its next pointer to null

temp = head
while(temp.next.next != NULL):
    temp = temp.next
temp.next = NULL 
```

3. Delete from Middle
```
1. Traverse to element before the element to be deleted.
2. Change next pointers to exclude the node from chain 

for(int i=2; i<positionl i++)
    if (temp.next != NULL)
        temp = temp.next

temp.next = temp.next.next;  
```


## Search an Element
```
1. current = head
2. while(current != NULL):
    if (current.data == key)
        return true
   return false
```

## Sort Elements
- Use bubble sort
```
1. current = head, initialize index  
2. if head == NULL
        return
   else
      while(current!=NULL)
            index = current.next
            while(current!=NULL)
                if(current.data>index.data)
                    temp = current.data
                    current.data = index.data
                    index.data = temp
                 index = index.next
             current = current.next
```
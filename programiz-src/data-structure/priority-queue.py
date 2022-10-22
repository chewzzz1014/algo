# implementation of priority queue

def heapify(arr, n, i):
    # find the largest among root, left child and right child
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    if l<n and arr[i]<arr[l]:
        largest = l

    if r<n and arr[largest]<arr[r]:
        largest = r

    # swap and continue heapfiying if root is not largest
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def insert(array, ele):
    size = len(array)
    if size == 0:
        array.append(ele)

    else:
        array.append(ele)
        for i in range((size//2)-1, -1, -1):
            heapify(array, size, i)

def deleteNode(array, num):
    size = len(array)
    i=0

    for i in range(0, size):
        if num == array[i]:
            break

    array[i], array[size-1] = array[size-1], array[i]

    array.remove(size-1)

    for i in range( (size//2)-1, -1, -1):
        heapify(array, len(array), i)


arr = []
for i in range(5):
    insert(arr, i)

print("Max-Heap array:", str(arr))

deleteNode(arr, 2)
print("After deleting an element:", arr)
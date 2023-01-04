def selection_sort(arr):
    for n in range(len(arr)-1, 0, -1):
        maxPos = 0
        for i in range(1, n+1):
            if arr[i]>arr[maxPos]:
                maxPos = i

        tmp = arr[n]
        arr[n] = arr[maxPos]
        arr[maxPos] = tmp

arr = [54,26,93,17,77,31,44,55,20]
selection_sort(arr)
print(arr)


# my version: start from front 
def ss(arr):
    for current in range(0, len(arr)-1):
        minPos = current
        for i in range(current+1, len(arr)):
            if arr[i]<arr[minPos]:
                minPos = i

        tmp = arr[current]
        arr[current] = arr[minPos]
        arr[minPos] = tmp

arr_1 = [54,26,93,17,77,31,44,55,20]
ss(arr_1)
print(arr_1)



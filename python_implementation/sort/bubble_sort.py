def bubble_sort(arr):
    for n in range(len(arr)-1, 0, -1):
        for i in range(n):
            if arr[i]>arr[i+1]:
                tmp = arr[i]
                arr[i] = arr[i+1]
                arr[i+1] = tmp

arr = [54,26,93,17,77,31,44,55,20]
bubble_sort(arr)
print(arr)
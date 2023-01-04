def bubble_sort(arr):
    for n in range(len(arr)-1, 0, -1):
        for i in range(n):
            if arr[i]>arr[i+1]:
                tmp = arr[i]
                arr[i] = arr[i+1]
                arr[i+1] = tmp

def short_bubble_sort(arr):
    exchange = True
    n = len(arr)-1
    while n > 0 and exchange:
        exchange = False
        for i in range(n):
            if arr[i]>arr[i+1]:
                exchange=True
                tmp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = tmp
        n = n - 1

arr = [54,26,93,17,77,31,44,55,20]
bubble_sort(arr)
print(arr)

arr=[20,30,40,90,50,60,70,80,100,110]
short_bubble_sort(arr)
print(arr)
def insertion_sort(arr):
    for current in range(1, len(arr)):
        currentVal = arr[current]
        pos = current

        while pos>0 and arr[pos-1]>currentVal:
            arr[pos] = arr[pos-1]
            pos = pos -1

        arr[pos] = currentVal

alist = [54,26,93,17,77,31,44,55,20]
insertion_sort(alist)
print(alist)

# def my_insertion_sort(arr):
#     for current in range(1, len(arr)):
#         currentVal = arr[current]
#         for i in range(current-1, -1, -1):
#             if currentVal<arr[i]:
#                 arr[current]=arr[i]
#
#         arr[i] = currentVal
#
# arr = [54,26,93,17,77,31,44,55,20]
# my_insertion_sort(arr)
# print(arr)

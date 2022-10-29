# selection sort that sort from minimum to maximum

# method to find the min element
def findSmallestIdx(arr):
    smallest_idx = 0
    for i in range(1, len(arr)):
        if arr[i] < arr[smallest_idx]:
            smallest_idx = i
    return smallest_idx

# perform selection sort
# move minimum element into new array. Repeat till old array is empty
def selection_sort(arr):
    sortedArr = []
    for i in range(len(arr)):
        smallestIdx = findSmallestIdx(arr)
        sortedArr.append(arr.pop(smallestIdx))
    return sortedArr


print("Sorted:", selection_sort([3, 662, 1293, 3, 9, 46, 0, 24]))
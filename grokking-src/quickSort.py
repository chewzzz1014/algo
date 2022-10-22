# implements quick sort that uses Divide and Conquer

def quick_sort(arr):

    # base case: if the size is 0 or 1, nothing to sort
    if len(arr) < 2:
        return arr

    # recursive case
    else:
        # pivot
        pivot = arr[0]

        # sub-array of elements less than pivot
        less = [i for i in arr[1:] if i<= pivot]

        # sub-array of elements greater than pivot
        greater = [i for i in arr[1:] if i>pivot]

        # recursively sort 2 sub-arrays
        return quick_sort(less) + [pivot] + quick_sort(greater)

print("Sorted:", quick_sort([13, 4, 0, 2, 0, 56, 232, 233]))



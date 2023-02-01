def binary_search(arr, item):
    first = 0
    last = len(arr)-1
    is_found = False

    while first<=last and not is_found:
        mid = (first+last)//2
        if arr[mid] == item:
            is_found = True
        else:
            if arr[mid]<item:
                first = mid + 1
            else:
                last = mid - 1

        return is_found

testlist = [0, 1, 2, 8, 13, 17, 19, 32, 42,]
print(binarySearch(testlist, 3))
print(binarySearch(testlist, 13))
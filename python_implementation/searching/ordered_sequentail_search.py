def sequential_search(arr, item):
    idx = 0
    found = False
    stop = False

    while idx < len(arr) and not found and not stop:
        if arr[idx] == item:
            found = True
        else:
            if arr[idx] < item:
                stop = True
            else:
                idx += 1

    return found

testlist = [0, 1, 2, 8, 13, 17, 19, 32, 42,]
print(orderedSequentialSearch(testlist, 3))
print(orderedSequentialSearch(testlist, 13))
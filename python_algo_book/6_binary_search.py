def binary_search(data, target, low=0, high=None):
    if high is None:
        high = len(data) - 1
    if low > high:
        return -1
    mid = (low+high) // 2
    if data[mid] == target:
        return mid
    elif data[mid] > target:
        return binary_search(data, target, low, mid-1)
    else:
        return binary_search(data, target, mid+1, high)
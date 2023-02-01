# take sorted array (list) and the target item (target)
# return the position of target in the list or None if not found
def binary_search(list, target):
    # low and high as boundary for ranges of list we search
    low = 0
    high = len(list)-1      # last index

    while low <= high:

        mid = low + high // 2
        guess = list[mid]

        if guess == target:
            # the target is the middle value
            return mid

        if guess > target:
            # target at lower halves of list
            high = mid - 1

        else:
            # target at higher halves of list
            low = mid + 1

        # if item doesn't exist
    return None

print( "Position of 2: ", binary_search([4, 2, 5, 31, 65, 5, 0, 4], 2) )

print( "Position of 0: ", binary_search([4, 2, 5, 31, 65, 5, 0, 4], 0) )
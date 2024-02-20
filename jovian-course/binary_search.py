def binary_search(lo, hi, condition):
    while lo <= hi:
        mid = (lo+hi) // 2
        result = condition(mid)
        if result == 'found':
            return mid
        elif result == 'left':
            hi = mid - 1
        elif result == 'right':
            lo = mid + 1
    return -1

def locate_cards(cards, target):
    def condition(mid):
        if cards[mid] == target:
            # this is not first occurrence
            if mid - 1 >= 0 and cards[mid - 1] == target:
                return 'left'
            else:
                return 'found'
        elif cards[mid] > target:
            return 'left'
        else:
            return 'right'
    return binary_search(0, len(cards)-1, condition)


# given a sorted list which was rotated N times, find N
# using binary search: If the middle element is smaller than its predecessor, then it is the answer. However, if it isn't, this check is not sufficient to determine whether the answer lies to the left or the right of it. Consider the following examples.
#
# [7, 8, 1, 3, 4, 5, 6] (answer lies to the left of the middle element)
#
# [1, 2, 3, 4, 5, -1, 0] (answer lies to the right of the middle element)
#
# Here's a check that will help us determine if the answer lies to the left or the right: If the middle element of the list is smaller than the last element of the range, then the answer lies to the left of it. Otherwise, the answer lies to the right.
def count_rotations_binary(nums):
    lo = 0
    hi = len(nums) - 1

    while lo <= hi:
        mid = (lo + hi) // 2
        mid_number = nums[mid]

        # Uncomment the next line for logging the values and fixing errors.
        print("lo:", lo, ", hi:", hi, ", mid:", mid, ", mid_number:", mid_number)

        if mid > 0 and mid_number < nums[mid - 1]:
            # The middle position is the answer
            return mid

        elif mid_number < nums[lo]:
            # Answer lies in the left half
            hi = mid - 1

        else:
            # Answer lies in the right half
            lo = mid + 1

    return 0
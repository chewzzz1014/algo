# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
#
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
#
# You can return the answer in any order.

def twoSum(nums: List[int], target: int) -> List[int]:
    # store elements and their indices
    pairs = {}
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in pairs:
            return [pairs[complement], i]
        pairs[nums[i]] = i
    return []
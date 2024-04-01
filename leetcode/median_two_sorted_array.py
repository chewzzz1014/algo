# Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
#
# The overall run time complexity should be O(log (m+n)).

'''
Solution:
1. Use binary search to partition the smaller of the two input arrays into two parts.
2. Find the partition of the larger array such that the sum of elements on the left side of the partition in both arrays is half of the total elements.
3. Check if this partition is valid by verifying if the largest number on the left side is smaller than the smallest number on the right side.
4. If the partition is valid, calculate and return the median.
'''


def findMedianSortedArrays(nums1, nums2):
    n1 = len(nums1)
    n2 = len(nums2)

    # ensure nums1 is smaller array
    if n1 > n2:
        return findMedianSortedArrays(nums2, nums1)

    n = n1 + n2
    left = (n1 + n2 + 1) // 2 # calc the left partition size
    low = 0
    high = n1

    while low <= high:
        mid1 = (low + high) // 2 # mid index for nums1
        mid2 = left - mid1

        l1 = float('-inf')
        l2 = float('-inf')
        r1 = float('inf')
        r2 = float('inf')

        # determine values of l1, l2, r1, r2
        if mid1 < n1:
            r1 = nums1[mid1]
        if mid2 < n2:
            r2 = nums2[mid2]
        if mid1-1 >= 0:
            l1 = nums1[mid1 - 1]
        if mid2-1 >= 0:
            l2 = nums2[mid2 - 1]

        if l1<=r2 and l2<=r1:
            # if partition is correct, we found median
            if n%2 == 1:
                return max(l1, l2)
            else:
                return (max(l1, l2) + min(r1, r2)) / 2.0
        elif l1>r2:
            # move towards left side of nums1
            high = mid1 - 1
        else:
            # move towards right side of nums1
            low = mid1 + 1
    return 0
# given a seq S, determine whether there's no duplicated value
from collections import Set

# O(n^2)
def unique1(S):
    for i in range(len(S)):
        for j in range(i+1, len(S)):
            if S[i] == S[j]:
                return False
    return True


# O(n log n)
# sorted list will have same element next to each other
def unique2(S):
    temp = sorted(S)
    for i in range(1, len(temp)):
        if S[i-1] == S[j]:
            return False
    return True


def unique3(S):
    set_S = Set(S)
    return len(S) == len(set_S)


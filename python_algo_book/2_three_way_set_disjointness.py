# 3 seq of numbers: A, B, C. None has duplicated values
# determine if the intersection of A, B, C is empty (no element will exist in all three of seqs)

from collections import Set

# O(n^3)
def disjoint1(A, B, C):
    for a in A:
        for b in B:
            for c in C:
                if a == b == c:
                    return False
    return True


# O(n^2)
def disjoint2(A, B, C):
    for a in A:
        for b in B:
            if a == b:
                for c in C:
                    if a == c:
                        return False
    return True


def disjoin3(A, B, C):
    set_A = Set(A)
    set_B = Set(B)
    set_C = Set(C)
    intersection = set_A & set_B & set_C
    return len(intersection) == 0


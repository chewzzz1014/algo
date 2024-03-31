# given sequence S of n elements, compute sequence A such that A[j] is the avg of elements S[0], ..., S[j]

# O(n^2)
def prefix_average1(S):
    n = len(S) # O(1)
    A = [0] * n # O(n)
    # O(n^2)
    for j in range(n):
        total = 0
        for i in range(j+1):
            total += S[i]
        A[j] = total / (j+1)
    return A

# O(n^2)
def prefix_average2(S):
    n = len(S)
    A = [0] * n
    for j in range(n):
        # sum takes O(j+1), list slicing takes O(j+1)
        A[j] = sum(S[:j+1]) / (j+1)
    return A

# O(n)
def prefix_average3(S):
    n = len(S)
    A = [0] * n
    total = 0
    for j in range(n):
        total += S[j]
        A[j] = total / (j+1)
    return A
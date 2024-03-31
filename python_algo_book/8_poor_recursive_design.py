# determine whether all elements are unique in a seq
# OO(2^n)
def unique(S, start, stop):
    if stop - start <= 1:
        return True
    elif not unique(S, start, stop-1):
        return False
    elif not unique(S, start+1, stop):
        return False
    else:
        return S[start] != S[stop-1]


# O(2^n)
def bad_fibonacci(n):
    if n <= 1:
        return n
    else:
        return bad_fibonacci(n−2) + bad_fibonacci(n−1)
# O(n)
def good_fibonacci(n):
    if n <= 1:
        return n, 0
    else:
        a, b = good_fibonacci(n-1)
        return a+b, a

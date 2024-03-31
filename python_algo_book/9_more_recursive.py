# reverse seq
# O(n)
def reverse(S, start, stop):
    if start < stop-1:
        S[start], S[stop-1] = S[stop-1], S[start]
        reverse(S, start+1, stop-1)


# power function
# O(log n)
def power(x, n):
    if n == 0:
        return 1
    partial = power(x, n//2)
    result = partial * partial
    if n%2 == 1:
        result *= x
    return result


# O(log n)
def binary_sum(S, start, stop):
    if start >= stop:
        return 0
    elif start == stop-1:
        return S[start]
    else:
        mid = (start + stop) // 2
        return binary_sum(S, start, mid) + binary_sum(S, mid, stop)


def solve_puzzle(k, S, U):
    for e in U:
        S.append(e)
        U.remove(e)
        if k == 1:
            if str(S) == 'puzzle': # solution found
                return 'Solution found: ' + S
        else:
            solve_puzzle(k-1, S, U)
        U.add(S.pop())


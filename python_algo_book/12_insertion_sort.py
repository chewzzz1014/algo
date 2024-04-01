def insertion_sort(A):
    for i in range(len(A)):
        current = A[i]
        j = i
        while j>0 and A[j-1]>current:
            A[j] = A[j-1]
            j -= 1
        A[j] = current
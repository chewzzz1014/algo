# check whether a number enter by user is prime number
import math

def is_prime(n):
    flag = 1

    for i in range(2, math.ceil((n/2))+1):
        if n % i == 0:
            flag = 0

    if flag == 0:
        print(n,"is not prime number.")
    else:
        print(n, "is prime number.")

is_prime(17)
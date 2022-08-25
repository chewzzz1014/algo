# Hash Table Implementation

hashTable = [[], ] * 10

def check_prime(n):
    if n == 0 or n == 1:
        return 0

    for i in range(2, int(n/2)):
        if n % i == 0:
            return 0

    return 1

def get_prime(n):
    # if n is even number, make it odd
    if n % 2 == 0:
        n = n + 1

    while not check_prime(n):
        n += 2

    return n

def hash_function(key):
    capacity = get_prime(10)
    return key % capacity

def insert_data(key, data):
    index = hash_function(key)
    hashTable[index] = [key, data]

def remove_data(key):
    index = hash_function(key)
    hashTable[index] = 0


insert_data(123, "apple")
insert_data(432, "mango")
insert_data(213, "banana")
insert_data(654, "guava")

print(hashTable)

remove_data(123)

print(hashTable)
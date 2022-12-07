class HashTable:
    def __init__(self):
        self.size = 11
        self.slots = [None] * self.size
        self.data = [None] * self.size

    def put(self, k, v):
        hashvalue = self.hashfunction(k, len(self.slots))

        # if doesn't exist, put it
        if self.slots[hashvalue] == None:
            self.slots[hashvalue] = k
            self.data[hashvalue] = v

        # it's occupied. Rehash
        else:
            nextslot = self.rehash(hashvalue, len(self.slots))
            while self.slots[nextslot] != None and self.slots[nextslot] != k:
                nextslot = self.rehash(nextslot, len(self.slots))

            if self.slots[nextslot] == None:
                self.slots[nextslot] = k
                self.data[nextslot] = v
            else:
                self.data[nextslot] = v

    def hashfunction(self, k, size):
        return k % size

    def rehash(self, oldHash, size):
        return (oldHash+1)%size
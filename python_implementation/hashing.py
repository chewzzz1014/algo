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

    def get(self, k):
        start_slot = self.hashfunction(k, len(self.slots))

        v = None
        stop = False
        found = False
        position = start_slot
        while self.slots[position] != None and not found and not stop:
            if self.slots[position] == k:
                found = True
                v = self.data[position]
            else:
                position = self.rehash(position, len(self.slots))
                if position == start_slot:
                    stop = True
        return v

    def __getitem__(self, k):
        return self.get(k)

    def __setitem__(self, k, v):
        self.put(k, v)


H=HashTable()
H[54]="cat"
H[26]="dog"
H[93]="lion"
H[17]="tiger"
H[77]="bird"
H[31]="cow"
H[44]="goat"
H[55]="pig"
H[20]="chicken"


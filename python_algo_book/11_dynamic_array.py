import ctypes

class DynamicArray:
    def __init__(self):
        self._n = 0
        self._capacity = 1
        self._A = self._make_array(self._capacity)

    def __len__(self):
        return self._n

    def __getitem__(self, idx):
        if not 0 <= idx <= self._n:
            raise IndexError('invalid index')
        return self._A[idx]

    def append(self, item):
        if self._n == self._capacity:
            self._resize(2 * self._capacity)
        self._A[self._n] = item
        self._n += 1

    def _resize(self, c):
        B = self._make_array(c)
        for i in range(self._n):
            B[i] = self._A[i]
        self._A = B
        self._capacity = c

    def _make_array(self, c):
        return (c * ctypes.py_object)()
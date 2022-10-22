## Hash Table
- Store elements in key-value pairs
- Key: Unique integer that's used for indexing the values
- Value: Data associated with keys

## Hashing (Hash Function)
- Hashing: a new index is processed using keys [key => index]
- Let `k` be key, and `h(x)` is the hash function. `h(k)` will hash a new index to store element linked with `k`
## Hash Collision
- When hash function generates the same index for multiple keys
- Techniques to resolve hash collisions"
  - Chaining (collision resolution)
  - Open Address: Linear/Quadratic Probing/Double Hashing

## Collision Resolution by Chaining
- If a hash produces the same index for multiple elements, these elements are stored in the same index by using a doubly-linked list.
```
1. Let j be slot for multiple elements. 
2. If element is present:
      j contains pointer to the head of list of elements.
   Else:
      j is NULL
```

## Open Addressing
- Each slot is either filled with single value or NULL

1. Linear Probing
- Collision is resolved by checking next slot.
```
h(k, i) = (h'(k) + i) mod m

where:
i = {0, 1, ...} 
h'(k) is new hash function
```
- If collision occurs at `h(k, 0)`, then `h(k, 1)` is checked.
- A cluster of adjacent slots is filled. When inserting a new element, the entire cluster must be traversed. This adds to the time required to perform operations on the hash table.

2. Quadratic Probing
   - Works similar to linear probing, but spacing between slots is increased
   - h(k, i) = (h'(k) + c<sub>1</sub> i + c<sub>2</sub> i<sup>2</sup>) mode m
   - c<sub>1</sub> and c<sub>2</sub> are positive auxiliary constants
   - i = {0, 1, ...}
## Good Hash Function
- may not prevent the collisions completely however it can reduce the number of collisions.
1. Division Method
   - Hash Function:
```
h(k) = k mod m

where:
k: key
m: size of hash table
```

2. Multiplication Method
```
h(k) = ⌊ m(kA mode 1) ⌋ 

where:
kA mod 1: Gives fractional part kA
⌊ ⌋: Gives floor value
A: Any constant that lies between 0 and 1.  But, an optimal choice will be ≈ (√5-1)/2 suggested by Knuth.
```

## Application
- Constant time lookup and insertion os required
- Cryptography application
- Indexing data is required

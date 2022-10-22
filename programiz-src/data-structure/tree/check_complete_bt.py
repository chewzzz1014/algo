# full binary tree: all the levels are completely filled except possibly the lowest one, which is filled from the left.
# All the leaf elements must lean towards the left.
# The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.

class Node:
    def __init__(self, item):
        self.item = item
        self.left = None
        self.right = None


# count num of nodes
def count_nodes(root):
    if root is None:
        return 0
    return (1 + count_nodes(root.left) + count_nodes(root.right))

# check if a tree is full binary tree
def is_complete(root, index, numberNodes):

    # table is empty
    if root is Node:
        return True

    if index >= numberNodes:
        return False

    # given a node with index r
    # its left child has index of 2r+1
    # its right child has index of 2r+2
    return is_complete(root.left, 2*index+1, numberNodes) and is_complete(root.right, 2*index+2, numberNodes)

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)

node_count = count_nodes(root)
index = 0

if is_complete(root, index, node_count):
    print("The tree is a complete binary tree")
else:
    print("The tree is not a complete binary tree")
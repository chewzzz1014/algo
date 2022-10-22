# prefect binary tree: every internal node has exactly two child nodes and all the leaf nodes are at the same level.


class newNode:
    def __init__(self, k):
        self.key = k
        self.right = self.left = None

# calculate depth of a node
def calcDepth(node):
    d = 0
    while (node is not None):
        d += 1
        node = node.left
    return d

#  is the tree is perfect binary tree?
def isPerfect(root, d, level=0):

    # if tree is empty
    if root is None:
        return True

    # check presence of tree
    if root.left is None and root.right is None:
        return d == (level+1)
    if root.left is None or root.right is None:
        return False

    return isPerfect(root.left, d, level+1) and isPerfect(root.right, d, level+1)

root = None
root = newNode(1)
root.left = newNode(2)
root.right = newNode(3)
root.left.left = newNode(4)
root.left.right = newNode(5)

if (isPerfect(root, calcDepth(root))):
    print("The tree is a perfect binary tree")
else:
    print("The tree is not a perfect binary tree")
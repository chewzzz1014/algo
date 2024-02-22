class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

# tuple to tree
def parse_tuple(data):
    print(data)
    if isinstance(data, tuple) and len(data) == 3:
        node = TreeNode(data[1])
        node.left = parse_tuple(data[0])
        node.right = parse_tuple(data[2])
    elif data is None:
        node = None
    else:
        node = TreeNode(data)
    return node


# tree to tuple
def tree_to_tuple(node):
    if node is None:
        return None
    if isinstance(node, TreeNode):
        # is leave
        if node.left is None and node.right is None:
            return node.key
        # is internal node
        left = None
        right = None
        if node.left is not None:
            left = tree_to_tuple(node.left)
        if node.right is not None:
            right = tree_to_tuple(node.right)
        return (left, node.key, right)


# display as tree
def display_keys(node, space='\t', level=0):
    # print(node.key if node else None, level)

    # If the node is empty
    if node is None:
        print(space * level + '∅')
        return

        # If the node is a leaf
    if node.left is None and node.right is None:
        print(space * level + str(node.key))
        return

    # If the node has children
    display_keys(node.right, space, level + 1)
    print(space * level + str(node.key))
    display_keys(node.left, space, level + 1)
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


# travesal: in order, pre order, post order
def traverse_in_order(node):
    if node is None:
        return []
    return(traverse_in_order(node.left) +
           [node.key] +
           traverse_in_order(node.right))
def traverse_pre_order(node):
    if node is None:
        return []
    return ([node.key] +
            traverse_pre_order(node.left) +
            traverse_pre_order(node.right))
def traverse_post_order(node):
    if node is None:
        return []
    return (traverse_post_order(node.left) +
           traverse_post_order(node.right) +
           [node.key])


# check is bst, return min and max node
def is_bst(node):
    def remove_none(arr):
        return [x for x in arr if x is not None]
    if node is None:
        return True, None, None
    is_bst_l, min_l, max_l = is_bst(node.left)
    is_bst_r, min_r, max_r = is_bst(node.right)
    is_bst_node = (is_bst_l and is_bst_r) and (max_l is None or node.key>max_l) and (min_r is None or node.key<min_r)
    min_key = min(remove_none([min_l, node.key, min_r]))
    max_key = max(remove_none([max_l, node.key, max_r]))
    return is_bst_node, min_key, max_key


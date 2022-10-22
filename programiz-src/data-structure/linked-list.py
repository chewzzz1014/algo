# implementation of Linked List

class Node:
    # create node
    def __init__(self, item):
        self.item = item
        self.next = None


class LinkedList():

    def __init__(self):
        self.head = None


if __name__ == "__main__":

    linked_list = LinkedList()

    # assign values to items
    linked_list.head = Node(346)
    second = Node(2)
    third = Node(368)

    # connect nodes
    linked_list.head.next = second
    second.next = third

    # print nodes
    while linked_list.head != None:
        print(linked_list.head.item, end=" ")
        linked_list.head = linked_list.head.next
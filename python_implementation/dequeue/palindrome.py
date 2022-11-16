from dequeue import Dequeue

def is_palindrome(string):
    dequeue = Dequeue()

    for s in string:
        dequeue.addFront(s)

    still_same = True
    while dequeue.size() > 1 and still_same:
        front = dequeue.removeFront()
        rear = dequeue.removeRear()

        if front != rear:
            still_same = False

    return still_same

print(is_palindrome("lsdkjfskf"))
print(is_palindrome("radar"))
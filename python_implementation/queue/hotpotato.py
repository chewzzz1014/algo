from queue import Queue

def hotPotato(namelist, num):
    myQueue = Queue()

    for name in namelist:
        myQueue.enqueue(name)

    while myQueue.size() > 1:
        for i in range(num):
            myQueue.enqueue(myQueue.dequeue())

        myQueue.dequeue()

    return myQueue.dequeue()

print(hotPotato(["Bill","David","Susan","Jane","Kent","Brad"],7))
from printing_task_classes import Task, Printer
from queue import Queue
import random

def simulation(numSeconds, pagesPerMinute):
    lab_printer = Printer(pagesPerMinute)
    print_queue = Queue()
    waitingTimes = []

    for currentSecond in range(numSeconds):
        if newPrintTask():
            task = Task(currentSecond)
            print_queue.enqueue(task)

        if not lab_printer.busy() and not print_queue.isEmpty():
            next_task = print_queue.dequeue()
            waitingTimes.append(next_task.wait_time(currentSecond))
            lab_printer.startNext(next_task)

        lab_printer.tick()

    average_wait = sum(waitingTimes) / len(waitingTimes)
    print("Average Wait %6.2f secs %3d tasks remaining."%(average_wait,print_queue.size()))


def newPrintTask():
    num = random.randrange(1, 181)
    if num == 180:
        return True
    else:
        return False

# 10 students want to print using printer
for i in range(10):
    simulation(3600, 5)
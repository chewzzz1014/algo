## Queue
Most people that keep a daily planner are used to doing things in the order in which they write them there. All of us have stood in line at the store checkout at some point. Chefs put ingredients in a dish sequentially in the order they are specified in the recipe. Everyone knows the concept of a queue, because it is an intuitive sequence of actions: we perform what comes first, and then we do the next task. Thus, you can safely forget about what you have already done, so while performing a task, you are focused only on it, not on previous or following ones. The queue works on the FIFO principle, which means First In, First Out.

It is convenient to perform actions as they arrive not only in real life, but also in programming. Let's figure out exactly how queues are defined in computer science and in which cases they are flexible to use.

## FIFO and Queues

Even if you do opt for an easier word "line", you still probably know what a queue is: according to the Cambridge Dictionary, it is "a row of people waiting for something, one behind the other". Let's imagine a queue as a line of people in a movie theater. The first one in line is the first one to enter the theater: first come first served, as we sometimes say in life. This is exactly how the FIFO principle works when we're talking about queues in programming.

Formally, First In, First Out principle, commonly known as FIFO, is taken from economics, where it defines a method in which products produced or acquired first are sold, used, or disposed of first. As the name of the method supposes, there are two main operations in First In, First Out principle: In and Out themselves. So if we want to add an element, we perform some kind of insertion operation, and if we want to exclude an element from the storage, we use deletion.

There are a few more data structures close to queue, such as deque, circular queue, or priority queue. However, the focus of this topic is a simple queue, and we will return to more complex queues in the following topics.

## Queue operations

A queue is a fundamental data structure with two basic operations:
- enqueue inserts an element;
- dequeue removes an element.

Elements are inserted at the end of a queue and removed from the top of it.


![image](https://user-images.githubusercontent.com/92832451/188078605-0b6fde79-00a3-4cb9-8b93-4ce6a15a09a1.png)

Here, element 1 was added before any other, and hence it will be dequeued first. At the same time, element 4 was added last, which means it is last to be dequeued.

Since we insert elements at the end and delete them strictly from the top of a queue, the complexity of performing these operations is O(1). To find an item in the queue, you will need to perform a number of operations that directly depends on the number of items in the queue. So, it is O(n).

Insertion of elements into the queue occurs sequentially, element by element. The first queue element, i.e. the last element that has been added to the queue, is called the head, and the endmost one is called the tail. The elements are removed in reverse order, starting from the tail. 


## Realization of queue

It's not in all programming languages that we can define a queue. However, there are several ways to implement queues.

### Array

A queue can be represented in the form of a fixed-size array and two integer variables: startstartstart and endendend. Usually, startstartstart points to the head of the queue, while endendend to the element that will be filled when a new element enters the queue.

![image](https://user-images.githubusercontent.com/92832451/188078708-aaae9435-dfdf-48ef-b44a-343010a8991e.png)

When we add an item to the queue, the new item is put to q[end], and the endendend is decreased by one. If the value of endendend becomes less than 1, the value of the variable becomes equal to nnn.

The extraction of an element from the queue is performed in the same way: after extracting the element q[start] from the queue, the variable startstartstart is decreased by 1. With such algorithms, one cell out of n will always be unoccupied (since a queue with n elements cannot be distinguished from an empty one).

Let's take a look at an example. At first, we have just one element in the queue. However, the queue is already determined to have 4 cells. start is zero and end equals to queue's size.


![image](https://user-images.githubusercontent.com/92832451/188078860-02eb683d-13a8-4e9e-91b2-5de197c1f52e.png)

When we delete elements from the queue, startstartstart will decrease by one.


![image](https://user-images.githubusercontent.com/92832451/188078908-2592a7e3-2203-4636-863e-c03fb736883d.png)


However, this method has a great disadvantage: the maximum number of items in the queue is limited by the size of the array. When it overflows, memory is reallocated and all elements are copied to a new fixed-size array.

### Linked list

The second method is based on working with dynamic memory. The queue is represented as a linked list, in which the addition or removal of elements goes strictly from its corresponding ends. In this method, the queue size is limited only by the amount of memory, however, more memory is required and working with the queue is somewhat slower.

![image](https://user-images.githubusercontent.com/92832451/188078960-fe8025ca-2d11-402f-9b92-5ab20fe05339.png)


## Why queue?

We use queues in programming, like in real life, when we need to perform some actions sequentially in the order of their appearance. Below are some examples:

- Organization of events in Windows. When a user performs an action, the corresponding procedure is not called in this action's application. However, a message containing information about the action performed is sent to them, this message is queued, and only when the messages that came earlier are processed, the application will perform the necessary action.
- The operating system uses a queue to store keystroke data as you type on the keyboard. Recall typing something in a text editor while the computer is busy doing another task: the keystrokes still aren't lost. This happens because the system stores them in queue order until they can be processed.
- Print tasks are stored on a print queue while waiting for printing.
- Handling website traffic is managed with the help of queue to process all the income requests.

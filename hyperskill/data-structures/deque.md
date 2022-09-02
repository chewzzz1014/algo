## Deque
No doubts that all of us have been stuck in a queue at some point. While studying queues, we imagined them as, for example, lines of people in front of a ticket office. What if, after buying a ticket, you realize that you've forgotten something or come back to ask a question? You have an advantage and shouldn't wait back in the line, right? However, the queue data structure doesn't store information about the last person to have bought a ticket. We need a structure that remembers both the first member of the queue and the last person to have left the queue. Let's think for a moment about how we can achieve this.

![image](https://user-images.githubusercontent.com/92832451/188080491-d5874f58-ce0d-464c-b57a-d5d128f829ca.png)

They say it takes both sides to build a bridge. So far, we have considered the two sides separately, namely First-In, First-Out (FIFO) and Last-In, First-Out (LIFO) principles. What if we combine them? We end up with a new data structure, called deque, with full access to both the first and the last elements. In this topic, we will get to know the properties of this data structure, as well as its ability to effectively build "bridges". 

## Definition and types
Deque is a generalization of the queue that allows us to insert and remove elements from both ends of it. Deques combine access rules provided by queues (FIFO) and stacks (LIFO). The name itself is quite intriguing, and, oddly enough, is pronounced /dɛk/. The term deque is an abbreviation for "double-ended queue". However, some sources use the terms dequeue or head-tail linked list instead.

The following picture demonstrates a deque (let's call it ddd) with seven elements, namely the integers from 0 to 6:

![image](https://user-images.githubusercontent.com/92832451/188080651-29319b72-1de4-4600-9653-a73ad631138a.png)

1. Input-restricted deque — insertion is restricted at a single end, meanwhile, deletion can be performed from both sides.
2. Output-restricted deque — insertion can be done from both ends, but deletion is restricted at a single end.

## Main operations

The simpler the structure, the easier the operations. Only by looking at the definition, you might guess that there are four natural basic operations that we can perform on deque:

- `insert_front(d, a)` — inserts the element aaa at the front of the deque ddd;
- `insert_back(d, a)` — inserts the element aaa at the back of the deque ddd;
- `remove_front(d)` — deletes the first element of the deque ddd;
- `remove_back(d)` — deletes the last element of the deque ddd.

For the sake of illustration, let's take a look at an example. Suppose we execute the following operations on the deque introduced above:

```
remove_front(d) -> remove_front(d) -> remove_front(d) -> insert_front(d, 20) -> remove_back(d) -> remove_back(d) -> insert_back(d, 30)
```

The result is shown below (try it!):

![image](https://user-images.githubusercontent.com/92832451/188080924-ed29fac0-52bc-4eed-a192-1ae1d7886be3.png)

A deque often has some additional operations that allow us to simply examine the first and the last elements, as well as to check whether it is full or empty. Usually, deques do not support indexing, but some implementations may provide it. You might want to check a [visualization](https://visualgo.net/en/list?slide=1-1) of the main operations, if you'd like.

Speaking about implementations of deque, there are a couple of them that use other types of data structures, however, this goes beyond the scope of this topic. What is important for us to know is that all the operations mentioned above can obviously be performed in O(1), no matter what implementation method we choose.

## Why deque

Thanks to its uncomplicated structure, deque is supported by many languages. In other words, most of the programming languages come with libraries or packages providing different implementations of our data structure and its operations. However, it is essential to understand when to use it and what its role in computer science is.

Programmers widely use deques in many areas including computer software to:

- implement other data structures, like stacks, queues, etc. You might come across the topic about this on your journey around our platform someday.
- store web browser's history: newly visited URLs are inserted at the top, and older links are removed from the list.
- undo-redo operations in software, like graphic editors, IDEs, etc. They need access to only the first and the last element, therefore, deque is ideal for this task.
- steal task scheduling algorithms: a processor takes the first task from its deque and performs it; when one of the processors completes the execution of its own tasks, it steals the last task from the deque of another processor and executes it. This is extremely important in the area of parallel computing.


Yet, of course, there are still many other cases where deques can help you.

It is worth mentioning that very often two or more different data structures are capable of performing the same task for the same amount of time. However, you should never forget that there are factors other than time complexity that play an important role in determining the efficiency of a certain action. For example, you can read this discussion on the advantages of using a deque over a stack. 



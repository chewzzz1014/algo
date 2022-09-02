## Shortest path problem 
One of the most important algorithmic tasks is finding the shortest path between a pair of vertices in a weighted graph. As a matter of fact, taking shortcuts is quite essential and goes beyond computer science. Indeed, aren't we always looking for the quickest route, the cheapest combination, the most efficient way of doing something, and so on?

![image](https://user-images.githubusercontent.com/92832451/188067703-baca0b0e-dcbb-4a45-a8b0-36f28221afa2.png)


## Variation of problems

As we already mentioned, the shortest path problem consists in finding a path between two objects such that its weight is the least possible. These objects very often happen to be cells of a grid or nodes of a huge graph as in the picture above. There are numerous varieties of this problem; however, the most common types studied in computer science are:

- SSSP −-− Single-source shortest path: Given a weighted graph G=(V,E), the source node sss, and the set of w<sub>u, v</sub> representing the weights of every edge (u,v). Find the shortest paths from the source node sss to all other nodes.
- MSSP −-− Multiple-source shortest path: Given a weighted graph G=(V,E), the starting nodes s<sub>1</sub>,…,s<sub>n</sub>, and the set of w<sub>u, v</sub> representing the weights of every edge (u,v). Find the shortest paths from each starting node to all other nodes. Usually, it is required to compute the shortest paths between all pairs of nodes. This instance is known as All-Pairs Shortest Path.
- Maze-Routing: Given a maze −-− a 2D grid with obstacles, the source cell S, and the target cell T. Find the shortest route from the source to the target cell.


![image](https://user-images.githubusercontent.com/92832451/188067727-72f8925b-6519-4b8c-b694-136257ef8463.png)


Unluckily, difficulties and obstacles pretty often arise not only in mazes but in real life as well. For example, negative weight cycles in graphs make it impossible for us to find the shortest path at all.

## Why the negative edges?

Naturally, a simple question arises: if distances are always positive, why do we use negative weights? Is this some useless theoretical feature? Obviously not. Besides networks, graphs are widely used in economics, physics, chemistry, and many other areas to represent phenomena like energy exchange, heat absorption, or even gravitational interaction, which very often tend to be negative.

Negative cycles can lead to incorrect shortest path algorithms, as they infinitely reduce the weight of the shortest path. Let's take a look at a simple example. Consider the graph below:

![image](https://user-images.githubusercontent.com/92832451/188067785-12d0f5e8-fc68-4895-9e28-5183bb10066f.png)


We notice straightaway the blue cycle 2→3→4→2, whose total weight is −6+3+2=−1. We can infinitely run around this cycle, reducing the weight of our path by −1 at the end of every iteration. Therefore, the shortest path from starting node 1 to nodes 2,3,4 or 5 cannot exist.


## Solving the problem

With the conditions already introduced, we are ready to solve the shortest path problem. The easiest strategy is to check all the possible paths and pick the one with the lowest weight. This is known as the naive approach. As usual, its time complexity is exponential, making it remarkably inefficient while working with huge graphs.

They say time is money, therefore we need to think of more practical solutions. There are a number of well-known algorithms that solve our problem and its instances, each one with its particular features and limitations. The main drawback is the inability of some of them to detect the presence of negative cycles. As a consequence, there are relatively fast algorithms which work incorrectly with graphs containing such cycles. On the other hand, there are correct algorithms able to notify us that negative cycles have been found. Unsurprisingly, their time complexity is slightly slower.


![image](https://user-images.githubusercontent.com/92832451/188067904-622bc525-7a90-4fe0-8f38-842fa7acccc7.png)


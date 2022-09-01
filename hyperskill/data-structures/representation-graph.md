## Representation of graphs 
We demonstrated previously that graphs provide a convenient visual approach to represent and solve a variety of problems. Yet some problems, particularly large ones, can be very difficult to solve manually. Fortunately, your computer can help if you represent your problem as a graph in the computer memory and implement a specific algorithm to solve it. But how can graphs be presented in computer memory?

Assume we need to write a program that solves a certain graph theory problem, and we have a graph like this:


![image](https://user-images.githubusercontent.com/92832451/187855516-a61293f7-c937-4ffc-808c-c155372b2ddd.png)


Obviously, we can't use this beautiful picture of letters, circles, and links as input for our program. Hence, we need to think of more practical methods to do so. 

## Basic operations on graphs

Before considering specific techniques to represent graphs, it is essential to understand the operations we plan to perform on them. Here are some of the most common ones:

![image](https://user-images.githubusercontent.com/92832451/187855609-9276615e-a8ad-4049-927d-cd69b782557f.png)


## Adjacency matrix

The first way of representation is known as the adjacency matrix. This is a matrix where each entry indicates whether a particular edge exists in the graph. The value 111 in a cell shows that the edge exists, while 000 means there's no such edge. Here is the adjacency matrix for the graph above:


![image](https://user-images.githubusercontent.com/92832451/187855681-6d19eb90-64e3-4d74-b563-f949a7c9dcd9.png)

For undirected graphs, the adjacency matrix is always symmetric: A[i,j]=A[j,i]. Since we normally don't allow for loops, the diagonal elements A[i,i] are all zeros, but the opposite is possible in the general case. On the other hand, a matrix for directed graphs doesn't have to be symmetric.

What are the advantages of using this way of representation? First of all, we can easily implement it using a two-dimensional array. Moreover, when we have an adjacency matrix, we can establish whether two nodes are connected by an edge just by looking at the appropriate slot in the matrix. In other words, this matrix allows us to check whether two nodes are adjacent in constant time O(1). Just as little time is needed to add or remove an edge. We can also list all neighbors of a node by scanning the corresponding row or column in O(n), where nnn is the number of nodes in the graph.


On the other hand, O(n<sup>2</sup>) is required to add or remove a node, as we have to resize and copy the matrix. The graph representation in the form of an adjacency matrix needs O(n<sup>2</sup>) memory. Such a representation is especially well-suited for graphs where the number of edges is close to the maximum, also known as dense graphs.


## Adjacency lists

What if we are out of memory? In practice, we sometimes need to represent huge graphs with thousands or millions of nodes, and O(n<sup>2</sup>) memory is quite a lot. Another common way to represent a graph in the computer memory is with adjacency lists. This is an array of nnn lists, where each list stores the neighbors of the corresponding node. Here are the adjacency lists for the graph above:  

![image](https://user-images.githubusercontent.com/92832451/187856081-25563714-860e-4a54-8482-2c711d3c7fad.png)


For undirected graphs, every edge is stored twice (like 'a'→'b' and 'b→'a' in the top example). For directed graphs, edges are stored only once; if the direction in our initial graph was from 'b' to 'a', then the first adjacency list would be 'a'→'c'.

For a graph with nnn nodes and mmm edges, its representation in the form of an adjacency list needs O(n+m) computer memory. It is more effective than the adjacency matrix for sparse graphs that have a lot fewer edges than the number of nodes squared. This is not the only advantage of the adjacency lists: you can add nodes or edges in O(1), since you only need to add an additional list for a new node, or a new element on the corresponding list for a new edge. In addition, removing a node is possible in O(m), as it is enough to scan the edges and remove those which are incident to the given node.

It is also worth noting that this representation has a drawback that can be serious for some types of problems. We cannot check whether one node is connected to another without passing through the elements of the adjacency list. This is a bit more difficult than simply using the adjacency matrix, namely it requires O(n) time. Removing an edge is also slower, compared to the adjacency matrix. It takes O(n), because we need to scan all the nodes.

## Other representations

Nevertheless, adjacency matrices and lists are not the only existing ways to represent graphs. The simplest one would be a list of all edges in a graph: 'a'→'b', 'a'→'c', 'b'→'c', and so on. It is the easiest method to implement; however, the time taken by every operation is considerably large.

Similarly to an adjacency matrix, you can define an incidence matrix as shown in the picture below.

![image](https://user-images.githubusercontent.com/92832451/187856261-af041e72-1407-4a6d-af08-f1acf64d3a92.png)

Additionally, a degree matrix is a matrix of dimension n×nn\times nn×n. Its diagonal entries are equal to the degree of the corresponding node, while the other entries are zeros. It is worth noting that these representations are useful only in some very particular situations; generally, they are remarkably ineffective. For example, when using an incidence matrix, almost all the previously mentioned operations can be executed in O(mn).

Some problems might also need a more specific graph representation for efficiency, depending on the situation.


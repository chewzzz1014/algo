## Floyd–Warshall algorithm 
Assume that each node on the graph below is an airport of some city and the weight of each edge is the distance between two airports:

![image](https://user-images.githubusercontent.com/92832451/188069215-0b27095c-a9a4-4df9-8257-91e167444f6b.png)

Suppose you are asked to make a schedule for planes of these airports. To minimize the time needed for each plane to get from one city to another, you need to know the shortest paths between all pairs of airports. How such paths can be found? One of the algorithms that allow us to solve this problem is the Floyd-Warshall algorithm. It is designed to find the shortest paths between all pairs of nodes and works even if a graph contains negatively weighted edges. Let's consider a more detailed description of this algorithm.

## The algorithm description

Any shortest path u→w1→...→w<sub>k</sub>→v between uuu and vvv includes some number of intermediate nodes (possibly none). The main idea of the Floyd–Warshall algorithm is to construct the shortest paths gradually, at each step considering only some nodes as intermediates.

At the first step, none of the nodes can be used as intermediate. In this case, the length of the shortest path for two nodes is equal either to the weight of an edge connecting the nodes or ∞ if no edge between the nodes exists. At each of the following steps, one new node is allowed as intermediate. Then, the algorithm checks whether this new node can be used to shorten the current paths and updates them if necessary. The process continues until all the nodes are used as intermediates.

Let's consider the update step in more detail. For convenience, we will denote dist(u,v) as the current distance between the nodes u and v. Assume that at the current step the nodes {0,1,...,k−1} are allowed as intermediates. How will distances change if the node k is also allowed? For nodes u and v, dist(u,v)d may either remain the same or decrease if the shortest path between u and v through the allowed nodes contains k as intermediate. The last may be easily checked since we already know dist(u,k). If dist(u,k)+dist(k,v)<dist(u,v), the current distance between u and v needs to be set to a smaller value. At each step of the algorithm, all pairs of nodes have to be checked in this way and updated if necessary.

To sum, the steps of the Floyd-Warshall algorithm are:

1. For each pair of nodes u and v, set dist(u,v) either to the weight of an edge connecting the nodes or ∞ if no edge between the nodes exists.
2. Start with an empty set of intermediate nodes.
3. Expand the current set of intermediate nodes by a new node k. For each pair of nodes u and vvv, check whether k can be used to shorten the distance between u and v. That is, if dist(u,k)+dist(k,v)<dist(u,v), update dist(u,v) to a smaller value.
4. Repeat the 3rd step until all the nodes are used as intermediates.

After the algorithm is finished, for each pair of nodes u and v, dist(u,v) is the length of the shortest paths between the nodes.


# An example

To cover all the details of the algorithm, we will consider how it works for the following directed graph G with a negative edge (as for the example above, you will be asked to find the shortest paths for the graph yourself).

![image](https://user-images.githubusercontent.com/92832451/188069943-068dc49a-07ca-485b-acb9-ef32a6fd90de.png)

To store the current distances between all pairs of nodes, we will use 5×5 matrix dist (see the figures below), where dist(u,v) is the current distance between the nodes u and v.

Initially, dist(u,v)=weight(u,v) if there is an edge from uuu to vvv or ∞ otherwise. Note that the initial distances are the same as the weights in the adjacency matrix of G.

At the next step (k=0), we include the node 0 to the set of intermediate nodes. We can see that the only distance that can be updated (shown in blue) is dist(1,2), since dist(1,0)+dist(0,2)=2+4=6, which is less than dist(1,2)=7.

Next (k=1), we expand the set of intermediate nodes with the node 111. We can see that dist(3,1)+dist(1,0)=−3, which is less than dist(3,0)= ∞. So, dist(3,0) is set to −3. Similarly, dist(3,2) is set to 2. At this step, these are the only distances that can be updated.


![image](https://user-images.githubusercontent.com/92832451/188070223-9d1e6a0f-0e63-4e6e-9a29-1dcec7d88f91.png)

Continuing the same process we will finally get the shortest distance matrix (the rightmost on the figure above) that contains the lengths of the shortest paths between all pairs of nodes.

The final matrix doesn't allow us to get the shortest paths themselves. To reconstruct them, we need to use an additional matrix prev, that for each pair of nodes u and v keeps the node prev(u,v), that was set as intermediate. Then, the shortest path between u and v consists of the shortest path between u and prev(u,v), prev(u,v) itself and prev(u,v) and v. The 1st and the 3rd paths can be found similarly using the matrix.

Note that although the graph above is directed, the same algorithm can be applied for an undirected graph. Another important thing to mention is that the Floyd-Warshall algorithm cannot be applied for graphs that contain a negative weight cycle. In such graphs, the shortest paths between some nodes might not be defined, since we can infinitely decrease the length of a path by traversing this cycle.

Those who are interested in a more interactive example of how the algorithm works may take a look at a [visualization](https://www.cs.usfca.edu/~galles/visualization/Floyd.html).

## The complexity analysis
Assume that the Floyd-Warshall algorithm is applied to a graph G with n nodes. At each step, the algorithm expands the current set of intermediate nodes by a new one, performing nnn steps in total. At each of these steps, all pairs of nodes need to be checked and updated (if necessary). Since the total number of node pairs is n⋅(n−1), the overall running time is n⋅n⋅(n−1)=O(n<sub>3</sub>).

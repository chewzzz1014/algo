## Weighted graph 
Recall that a graph is a set of nodes and edges, where each edge represents a connection between two nodes. A weighted graph is a graph where each edge has a numerical value called a weight. Given below is an example of a weighted graph:

![image](https://user-images.githubusercontent.com/92832451/187859911-be7e776a-c67d-42e2-8473-7fc2d7a1f782.png)

The graph consists of five nodes and seven edges. Each edge has a weight. For example, the edge {0,3} has the weight 777, the edge {1,2} has the weight 111.

Weighted graphs are often used to model real objects and processes. For example, the graph above can be considered as a map, where the nodes are cities and the edges are roads. The weight of each edge is the distance between two cities.

The graph above is an undirected graph. But weighted graphs can also be directed. Given below is an example of a directed weighted graph:

![image](https://user-images.githubusercontent.com/92832451/187860024-0453b8e9-508d-4d3c-b236-5924405ffce7.png)


Weighted directed graphs can also be used to model some real processes. For instance, the node 0 in the graph above can be considered as a storage place, from where we need to transfer some resources to the destination point, say to the node 2. The remaining nodes can be considered as intermediate places. Each edge shows a direction in which the resources can be transferred. The weight of an edge shows the maximum amount of resources that can be sent through the edge.

Note that for the graphs above all the weights are positive, but negative and zero weights are also allowed. 

## A representation of weighted graphs

An unweighted graph can be represented using an adjacency matrix or an adjacency list. A weighted graph can also be represented using both of these structures.

For a weighted graph with n nodes, an adjacency matrix is a n×n matrix A, where A[i,j] is the weight of an edge between nodes i and j. If there is no edge between iii and jjj, the corresponding value is set to ∞. The diagonal elements of the matrix are assigned to 0 (here we assume that there are no self-loops in a graph). For the directed graph above, an adjacency matrix is the following:

![image](https://user-images.githubusercontent.com/92832451/187860332-c02ebfc0-c082-4eb1-a0c1-867a1734f075.png)

The first row and column of the matrix correspond to the nodes of the graph. The remaining cells correspond to the weights. For example, A[1,3]=4 since there is an edge between the nodes 1 and 3 with the weight 4. A[3,1]=∞ since there is no edge between 3 and 1.

Adjacency lists for weighted and unweighted graphs are similar. The only difference is that we need to store an additional value in each node of a list corresponding to the weight of an edge. For the directed graph above, an adjacency list looks like this:


![image](https://user-images.githubusercontent.com/92832451/187860530-282b7c7d-c07f-472c-a6ab-b46a978762ac.png)

Each node of the list contains two values. The first value is the label of a node of the graph, the second one is the weight of the corresponding edge. For example, the first node in the first list corresponds to the edge {0,1} that has the weight 3. The second node in the same list corresponds to the edge {0,3} that has the weight 7. Since the node 2 of the graph has no neighbors, the corresponding list of neighbors is empty. 

## Paths in weighted graphs

A path in a weighted graph is the same as in an unweighted one. The only difference is that in a weighted graph a path has a weight that is equal to the sum of the edge weights in the path. For example, consider a path 0→4→3→2 (shown in blue) for a directed graph:

![image](https://user-images.githubusercontent.com/92832451/187860728-69921f53-f5d8-4239-9c0e-a959320cb786.png)


The path consists of three edges. The total weight of the path is the sum of the edges' weights: 8+3+2=13. One may note that there is another path from the node 0 to the node 2: 0→1→20  (shown in red):

![image](https://user-images.githubusercontent.com/92832451/187860902-41c80754-7ccf-4bb8-a68b-8e20dea61787.png)

The weigh of the path is 3+1=4 , which is less than the weight of the blue path.

The problem of finding the shortest path (a path with the minimum weight) between two nodes in a graph often arises in programming practice. There are several algorithms solving the shortest path problem. We will consider them in more detail in the next topics. 

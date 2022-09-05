## Connectivity in graphs 
For now, we've already learned what a graph is and discussed some basic terminology. One more important concept that we should cover is connectivity. This concept is often used in graph theory and arises in different graph algorithms, so it is important to become familiar with it. In this topic, we will discuss this concept in detail: first, for undirected graphs and then for directed ones.

## Connectivity in undirected graphs

In an undirected graph, two nodes are said to be connected if there exists a path between these nodes. For example, the nodes 1 and 3 of G<sub>1</sub> are connected since there is a path 1−2−3:

![image](https://user-images.githubusercontent.com/92832451/188389571-a36002cf-a5cd-4431-bc03-db9a19193775.png)

An example of nodes that are not connected is 3 and 6: as you can see there is no path that's connecting them.

A subgraph of a graph is called a connected component if
- each pair of nodes in this subgraph is connected;
- no other nodes can be added to this component without breaking its property of being connected.

According to this definition, G<sub>1</sub> consists of two connected components. The first one includes the nodes 0, 1, 2 and 3, since
- there is a path between each pair of these nodes;
- if we add one more node from G<sub>1</sub> to this subgraph, it will not be connected.

The second connected component contains the nodes 4, 5, 6, and 7.

A graph G is called connected if it consists of only one connected component. As you can see, G<sub>1</sub> does not fit this definition, thus it's disconnected.

## Directed graphs: weak connectivity

As for directed graphs, the concept of connectivity is a bit more complex than for undirected ones. There are two different types of connectivity for directed graphs: weak and strong.

A directed graph is weakly connected if there exists an undirected path between each pair of nodes in the graph. In other words, if we transform a directed graph into an undirected by removing the direction of each edge and get a connected graph, then the directed graph is weakly connected. Let's consider the following example:

![image](https://user-images.githubusercontent.com/92832451/188390738-175b6f86-2657-4953-8e78-ece0dec59744.png)

If we remove the direction of each edge of the graph G<sub>1</sub> we will get a connected undirected graph G<sub>2</sub>. Therefore, G<sub>1</sub> is weakly connected.

## Directed graphs: strong connectivity

A directed graph is strongly connected if there exists a directed path between each pair of nodes in the graph. According to this definition, G<sub>1</sub> is not strongly connected. For example, there is a path 3→0→1→2between the nodes 3 and 2, but there is no path between 2 and 3.

A subgraph of a directed graph is a strongly connected component (shortly, SCC) if:
- there exists a directed path between each pair of nodes in this subgraph;
- no other nodes or edges can be added to this subgraph without breaking its property of being strongly connected.

The graph G<sub>1</sub>, for example, consists of two strongly connected components:

![image](https://user-images.githubusercontent.com/92832451/188391128-e46f810d-6334-4a87-8568-a1235519a1d4.png)

The blue nodes 0, 3, and 4 belong to the first component, while the red nodes 1, 2, and 5 represent the second one. If we merge the nodes of each strongly connected component into one, we will get a directed acyclic graph, a condensation of G<sub>1</sub>:


![image](https://user-images.githubusercontent.com/92832451/188391299-500a76f4-e463-45e7-855c-94c259c51715.png)


Note: by definition of a strongly connected component, a subgraph containing only one node can also be a strongly connected component in a directed graph!

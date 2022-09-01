## Nodes, cycles and paths 
Previously, we learned some basics about graphs and considered several cases where they come in handy. You might remember the example on social networks that we looked at. Now, you probably know that Facebook is a social network that allows users to connect with friends online. Instagram is a similar platform, but users follow other users without having to add them as friends. Well, instead of spending your precious time on these networks, let's learn more about the way they work from the inside.

![image](https://user-images.githubusercontent.com/92832451/187849704-1ffca0b8-c4c6-4391-9085-2c2c938160a4.png)

In this topic, we will continue with graphs and talk about some basic terminology using the graph above as an illustration. Although learning terms might seem a bit tedious, it is a very important step. Once you get familiar with the basic terms, you will be able to understand more sophisticated algorithms and concepts concerning graphs.

## Simple graphs

Up until now, we talked about small graphs with plain structure. However, some graphs look a bit tricky, as shown in the picture below. There are two things to note. First: the edge {0,0} connects the node 0 with itself. Such an edge is called a loop. Also, there are three edges connecting the same pair of nodes: 0 and 1. These are known as multiple edges. If a graph contains loops or some edges appear multiple times, it is called a multigraph. Otherwise, we call it a simple graph.

![image](https://user-images.githubusercontent.com/92832451/187849810-3b214589-af1d-44af-a97a-ac15dd16a131.png)


It is worth noticing that simple graphs are very common, but they are not enough. Have you ever mentioned somebody in a story on Instagram? In that case, an edge is automatically created to indicate that some interaction between users has happened. This is when they receive the message "@bob mentioned you in their story". What if you are sharing a memory from your own archive? The interaction happens between you and you; hence, it creates a loop.

Similarly, representing multiple edges is more than necessary. Let's stick to social networks. If your accounts are connected, and you follow the same person on Instagram, Facebook, and other apps, multiple edges will be used to store the information, just like in the example above with the blue, magenta, and green edges.

## Nodes and edges' relationship

We already know what the graphs in Facebook's databases look like: nodes representing users that are connected by an edge with other users if and only if they are friends. Now, how do these terms and phenomena sound in the language of graphs? Let's find out.

![image](https://user-images.githubusercontent.com/92832451/187849880-63144825-4b2b-4a3d-a7cd-21eaba52726a.png)

Two nodes of a graph are adjacent if they are connected by an edge. For example, the nodes 0 and 1 in the graph above are adjacent, since they are connected by the edge {0,1}. Basically, this indicates that Bob and Ann are friends. If an edge {x,y} connects the nodes xxx and yyy, these nodes are incident to this edge. For example, the node 111 is incident to three edges: {0,1}, {1,3}, and {1,2}. The degree of a node is the number of edges incident to it. For instance, the degree of the node 2 is equal to 3, since the node is incident to three edges. This means that Alice has 3 friends on Facebook, which is not much, to be honest.

![image](https://user-images.githubusercontent.com/92832451/187850044-b23d2c06-61dd-4cf9-bc18-ce97a3ae29a1.png)

What if you prefer Instagram, instead? It is possible to follow someone even if they don't follow you back. In this case, directed graphs come in handy, as we need to store information about the follower and the user who is followed using directed edges. In a nutshell, their adjacency is not symmetric: if y is adjacent to x, x is not necessarily adjacent to y. In directed graphs, each node has an indegree – the number of followers, in this case, and an outdegree – the number of users they follow. Formally, for a node x, the indegree is the number of nodes adjacent to x, and the number of outgoing edges of x is called the outdegree. As an illustration, the indegree of node 2 is 3, and its outdegree is 1. In other words, Alice has three followers and follows one user, namely Ann. Apparently, she is ignoring the boys.

## Paths and cycles

A path is a path. Literally... Jokes aside, a path in a graph is an alternating sequence of nodes and edges. Consider the following examples:

![image](https://user-images.githubusercontent.com/92832451/187850206-dd8974f5-82d1-4b77-bbbc-569e8eee464b.png)

The blue nodes and edges correspond to the path 6−4−5−8−7. If each node in a path appears only once, this path is called simple. The path above is a simple path since there are no nodes appearing multiple times. If we add the edge {6,5} to this path, it will stop being simple, since now the node 5 appears twice.

If the path starts and ends at the same node, this path is called a cycle. For example, the green nodes and edges form a cycle 4−5−8−6−4.

For directed graphs, the terms are the same. Notice that the edges are directed; therefore, the alternating sequence should look like this: (node 1) — (outgoing edge from node 1) — (node 2) — (outgoing edge from node 2) and so on. Let's get back to our Instagraph:


![image](https://user-images.githubusercontent.com/92832451/187850307-cd496c0a-66be-4f22-9780-2ececaa8b5cf.png)

Assume that you follow Alex, Alex follows Dora, she follows Kate, and Kate listens to songs of L&D, a popular band that posts its songs on Instagram. Recently, they posted a song called "Just the beginning". What are the chances that this song shows up on your feed? Well, Kate will obviously repost it. If Dora and Alex decide to do so as well, the post with the original song will appear on your feed thanks to the repost from Alex. Therefore, the song will have a chance to get a like from you. Formally, a path from you to L&D will be created, namely, You → Alex → Dora → Kate → L&D. This is the basic idea of how the algorithms that intend to raise users' popularity on social media work. They tend to find users that are potential reposters and have friends with similar qualities as well.


## Connectivity in graphs

Consider the initial graph. You may think that there are two graphs, but you would be wrong. Actually, this is a disconnected graph with two components. Let's try to define formally what connectivity means.

![image](https://user-images.githubusercontent.com/92832451/187850440-9833ba6a-8fcc-4533-9496-ef8528145c46.png)

In an undirected graph, two nodes x and y are said to be connected if there is a path between them. A set of nodes where each pair is connected by a path forms a connected component. A graph G is called a connected graph if it contains exactly one connected component. Otherwise, the graph is disconnected.

Disconnected graphs arise pretty often. Let the users in the graph above be computer science students. Assume they've had a disagreement leading to the creation of two groups of friends. Everyone from the first group unfriended the students from the other group and vice versa. In one word, teen stuff. From the graphs' point of view, this implies the formation of two connected components: {0,1,2,3} and {4,5,6,7,8,9} as shown in the picture.

Note that now we are talking only about undirected graphs. As for directed graphs, a definition of a connected component is a bit trickier: we will discuss it in the following topics. 

## Subgraphs

Filters play an essential role in searching, don't they? What happens with a graph of users when filtering? Let's suppose we want to search among the female users. From the initial structure, we are left with the graph G<sub>1</sub> on the left. Or assume you want to find users whose name contains four letters. We end up with the mini-graph G<sub>2</sub> on the right.

![image](https://user-images.githubusercontent.com/92832451/187850680-3517fb93-43b7-4290-b5c2-c0f0034a8dd6.png)

Formally, a graph obtained from another graph by removing nodes or edges is called a subgraph. From the example above, the graphs G<sub>1</sub> and G<sub>2</sub> are subgraphs of our initial graph, because we get them by removing some nodes and edges: it shouldn't be difficult for you to see which ones.

Note that when we remove a node from a graph, we also remove all edges incident to this node. 



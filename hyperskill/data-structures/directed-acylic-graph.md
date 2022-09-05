## Directed Acylic Graph
Have you ever thought about the work process in large IT companies? There are a lot of different teams that deal with diverse parts of the same application, and in the end all parts are combined into one system. What happens if one of the programmers makes a mistake? Does this mean that the entire application will stop working? If so, then none of the systems in the whole IT world would work properly. To avoid this, version control systems are organized in the form of a directed acyclic graph. A version control system can be represented as a graph, in which there are no directed cycles, but there may be parallel paths leaving one node and coming to the final node in different ways. There are some branches of development, for instance, bug fixing or adding new features. At any time, it is possible to create a new branch or to merge the current one with others.

![image](https://user-images.githubusercontent.com/92832451/188380745-ee8e54d2-ddde-4d7d-ae08-830c2396e53c.png)


## Formal definition

A Directed Acyclic Graph (DAG) has a name that speaks for itself: it is a directed graph that contains no cycles. Despite this acyclic property, a DAG may contain parallel paths. Parallel paths are paths starting and finishing at the same nodes without forming a cycle. Thus, in directed acyclic graphs there are no directed edges that begin and end at the same vertex, but parallel paths can exist. Do you see the difference?

The images below show a few examples of DAGs, some of which contain parallel paths for you to check out:

![image](https://user-images.githubusercontent.com/92832451/188380810-2f9c70b0-694c-44a7-bece-9d7b4d3bdde0.png)

Here, blue and light blue arrows represent pairs of parallel paths. For example, in the first picture, paths 2−42  and 2−3−5−4 start in the node 2 and finish in the node 4, which means they are parallel paths. The same holds for 5−7−8 and 5−8.

In the second picture, there aren't any parallel paths at all. However, there are parallel paths in the last picture as well. Try to find them!

## Basic concepts

So far, it all seems so easy, doesn't it? Let's throw in some more definitions, essential for understanding this topic:

- We call a node reachable if there is a directed edge that leads to it.
- We also can order nodes by their reachability. It is called partial order. If there is a directed edge from node uuu to node vvv, then you can compare these nodes: u≤vu \leq vu≤v.
- Topological sorting (or order) is an ordering of graph nodes, where for each directed edge from node uuu to node vvv, uuu stands before vvv. Topological sorting makes a lot of sense in DAG and graph theory in general, so a few following topics get back to it. Topological sorting can be processed in linear time with O(n)O(n)O(n) complexity.

## Tree or graph?

In order not to get confused, you need to understand how a DAG differs from an ordinary graph and an ordinary tree. Let's look at the illustrations of this family:

![image](https://user-images.githubusercontent.com/92832451/188381033-c59018fd-30da-4b5b-ba4f-1e6d4c1d5d02.png)

As you can see on family trees, a tree always has only one entrance to each node. In general, it makes sense to say so only about directed graphs, which have a direction indicated on each edge. Undirected graphs work differently.

In a directed graph, every node has one or more predecessor nodes and successor nodes. A graph is traversed by using the depth-first search and breadth-first search algorithms. A tree is a special kind of graph that constitutes a hierarchical model. It can be undirected or directed, but always acyclic, i.e. similarly to DAGs, it doesn't contain cycles.

It is essential to be able to judge when it is better to use a tree, a graph, or a DAG. For instance, when you need each vertex to depend strictly on one input to the node, then you can use the simplest tree.

## Applications
Strangely, a wide variety of fields make use of directed acyclic graphs. Let's see how these graphs are used in some areas:

- Social networking. You can see friendship trees as directed acyclic graphs, with a vertex for every friend and an edge for every relationship.
- Scheduling and management. DAGs are used in project management to plan, design, and implement complex projects or tasks.
- Data compression. In this sphere, you can use directed acyclic graphs as a compact representation of a collection of sequences. When many of the sequences share the same subsequences, you can represent these shared subsequences by a shared part of the DAG. This allows the representation to use less space than it would take to list all of them separately.
- DAGs are also useful in genealogy and version history, data processing networks, machine learning, and other fields.


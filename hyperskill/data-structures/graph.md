## Graph
We can concisely depict many real-life problems as collections of objects and links between them. Such representations are known as graphs. A graph can be considered as a set of objects, usually named nodes or vertices, and links (edges) that connect these objects with each other.

To fully understand the importance of graphs, it is sufficient to mention that there exists a branch of theoretical computer science known as Graph Theory. Furthermore, this is undoubtedly one of the fields with the largest number of unsolved problems, and scientists from all over the world work on them from day to day. Here, however, we will focus on the very basics of this theory — only on the elements necessary to understand the algorithms that use this data structure.

## An important graph problem

Now, let's take a look at one of the most discussed problems in modern graph theory — the map-coloring problem. The task can be stated as follows: we need to assign a color to every country, taking an obvious restriction into account — two neighbors should have different colors. Consider the following example:

![image](https://user-images.githubusercontent.com/92832451/187847748-6ec2faa2-87d6-41bf-b70f-aa94bdd2455a.png)

Here is a partial map of Europe. To get rid of the unnecessary details of a map, we represent each country as a node and connect two countries if they are neighbors. This results in the following graph:

![image](https://user-images.githubusercontent.com/92832451/187847790-a104c325-f1e1-4565-aa61-dc57f8d377a3.png)

The figure on the left corresponds to a map with borders represented as links between countries, and the figure on the right is a graph where we've substituted each country for a node. Thus, we reduce the problem of coloring a political map to the problem of coloring the nodes of a graph. Although the example above is quite simple, such representation would be indispensable for larger maps: it allows us not only to keep the important details, but also to automate the solution to this problem.

## More applications

Unsurprisingly, graphs come in handy in many areas other than theoretical computer science. Assume that you need to drive from one city to another. Chances are, you'd probably rely on services like Google Maps or MapQuest. We all use them, but have you ever thought about how they work under the hood? A possible way is to represent the map as a graph with nodes corresponding to cities and edges showing the roads. Then, in terms of graphs, our question is: what is the shortest path between the start node and the destination node?

![image](https://user-images.githubusercontent.com/92832451/187847847-e8633722-0624-4052-9874-cff045a9ff60.png)

Map coloring and finding the shortest path are not the only problems where graphs appear useful. For instance, we could represent the World Wide Web as a graph, with nodes symbolizing the sites and edges as links between these sites. In social networks, you can view people as nodes, and a link between two people meaning that one of them follows the other. In other words, a graph is a convenient structure, suitable for modeling various real-life problems.

## Formal definition

Using formal language is essential when it comes to working with graphs conveniently, storing them on a computer, or describing algorithms for graph processing. Formally, a graph G is a pair of two sets: G=(V,E). Here, VVV is a set of nodes and E is a set of edges. Each edge is a pair of nodes connected by a link. Consider the following three examples:

![image](https://user-images.githubusercontent.com/92832451/187847966-b3670ef1-e995-4962-9dd3-5c4fd2f4f3e2.png)

Here we have three graphs. The first graph G1G_1G1​ consists of three nodes and has no edges. So,

![image](https://user-images.githubusercontent.com/92832451/187848004-b95540fe-e743-4056-8bc8-28aae7957a8d.png)

![image](https://user-images.githubusercontent.com/92832451/187848070-f3f7c220-e91e-43e8-ade6-33941072225c.png)

Depending on a particular problem you need to solve, different types of labels might be convenient.

## Directed Graph
Up until this moment, we've talked only about graphs where edges don't have any direction. For example, consider the edge {0,1} of G<sub>2</sub> that connects the nodes 000 and 111. If we swap the nodes, it won't change anything: the edge {1,0} still connects the same nodes. Such graphs, where the order of nodes is not important, are called undirected graphs. A political map is a structure that we can naturally reduce to an undirected graph. If one country is a neighbor of another, the direction of the edge showing this relation is not important.

However, in some other cases, undirected graphs don't suffice. Assume that we want to model a social network as a graph. We can represent people as nodes and put an edge between two people if one of them follows the other. In this case, the direction is important. If a user xxx follows yyy, it doesn't mean that yyy follows xxx. To model this and similar situations, directed graphs suit much better. On the right you can see an example of a directed graph:

The given graph consists of four nodes and four directed edges:

```
V={0,1,2,3}, E={(0,1),(0,2),(1,2),(3,2)}
```

![image](https://user-images.githubusercontent.com/92832451/187848443-e4124464-be6b-4caf-a4ea-a54843e1a5cb.png)

To show that an edge is directed, we use round brackets instead of curly ones.

As mentioned before, different types of graphs are better suited for modeling different problems. Depending on the task you need to solve, you can choose either directed or undirected graphs.

As weird as it may sound, undirected graphs can be easily converted into directed ones. Indeed, instead of every undirected edge {u,v}, just add two directed ones, namely (u,v) and (v,u). Obviously, the contrary assumption is not true: directed graphs pretty often cannot be remodeled into undirected graphs. It is impossible to save the information on directions using undirected edges.

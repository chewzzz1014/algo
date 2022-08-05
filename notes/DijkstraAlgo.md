- Breadth-first search find the path with the fewest segments but Dijkstra Algorithm find the fastest path.

## How it Works?
- Goal: Travel from start to finish in the shortest possible time.
1. Find the "cheapest node", the node that requires the least amount of time to reach there.
2. Update the costs of the neighbors of this "cheapest" node.
3. Repeat until we've done Step 3 for every node in the graph.
4. Calculate the final path.



- Weights: Number associated with each edge (line connecting nodes)
- Breadth-first search calculates the shortest path in an unweighted graph. Dijkstra's algorithm calculates the shortest path in a weighted graph.
- Dijkstra algorithm can't be used for graph with negative weights. In scenarios like these, use Bellman-Ford algorithm instead.
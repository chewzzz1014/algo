- Breadth-first search find the path with the fewest segments but Dijkstra Algorithm find the fastest path.
- Weights: Number associated with each edge (line connecting nodes)
- Breadth-first search calculates the shortest path in an unweighted graph. Dijkstra's algorithm calculates the shortest path in a weighted graph.
- Dijkstra algorithm can't be used for graph with negative weights. In scenarios like these, use Bellman-Ford algorithm instead.

## How it Works?
- Goal: Travel from start to finish in the shortest possible time.
1. Find the "cheapest node", the node that requires the least amount of time to reach there.
2. Update the costs of the neighbors of this "cheapest" node.
3. Repeat until we've done Step 3 for every node in the graph.
4. Calculate the final path.

## Implementation Steps
1. While we have nodes to process
2. Grab the node that's closest to the start
3. Update costs for its neighbors
4. If any of the neighhbors' costs were updated, update the parents too
5. Mark this node processes
6. Repeat step 1-5 for other nodes




# Implementation of Dijkstra algorithm

'''
Involve 3 hash tables:

1. Graph: To store the costs of each node from itself to all of its neighbouring nodes.

2. Costs: To store the costs of the edge belongs to each node

3. Parents: To store the parent of each node
'''

# nodes in graph: starting node, node A, node B and finish node

# making Graph hash table
# graph = { "start": {"a": 6, "b": 2} }
graph = {}
graph["start"] = {}
graph["start"]["a"] = 6
graph["start"]["b"] = 2

'''
graph = { "start": {"a": 6, "b": 2},
          "a": {"fin": 1}
        }
'''
graph["a"] = {}
graph["a"]["fin"] = 1

'''
graph = { "start": {"a": 6, "b": 2},
          "a": {"fin": 1},
          "b": {"a": 3, "fin": 5}
        }
'''
graph["b"] = {}
graph["b"]["a"] = 3
graph["b"]["fin"] = 5

'''
graph = { "start": {"a": 6, "b": 2},
          "a": {"fin": 1},
          "b": {"a": 3, "fin": 5},
          "fin": {}
        }
'''
graph["fin"] = {}


# making Costs hash map that will be updated throughout the searching process
# if we don't know the cost yet, put infinity
infinity = float("inf")
costs = dict()
costs["a"] = 6
costs["b"] = 2
costs["fin"] = infinity


# making Parents hash table
parents = {}
parents["a"] = "start"
parents["b"] = "start"
parents["fin"] = None

# record nodes that already processed
processed = []

def find_lowest_cost_node(costs):
    lowest_cost = float("inf")
    lowest_cost_node = None
    for node in costs:
        cost = costs[node]
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost
            lowest_cost_node = node
    return lowest_cost_node

# find the lowest-cost node that haven't been processes
node = find_lowest_cost_node(costs)
while node is not None:
    cost = costs[node]
    neighbors = graph[node]

    # check for all neighbors of this node
    for n in neighbors.keys():
        new_cost = cost + neighbors[n]
        # if it's cheaper to get to this neighbor by going throught this node
        if costs[n] > new_cost:
            # update the cost for this node
            costs[n] = new_cost
            # this node become the new parent for this neighbor
            parents[n] = node
    processed.append(node)
    # find the next node to process and loop
    node = find_lowest_cost_node(costs)
# Implementation of greedy algorithm
'''
Scenario:
Suppose you’re starting a radio show. You want to  reach listeners in all 50 states.
You have to decide what stations to play on to reach all those listeners. It costs
money to be on each station, so you’re trying to minimize the
number of stations you play on. You have a list of stations.

Each station covers a region, and there’s overlap.
How do you figure out the smallest set of stations you can play on to cover all 50 states?
Here’s how to do it:
1. List every possible subset of stations. This is called the power set. There are
2^n possible subsets

2. From these, pick the set with the smallest number of stations that
covers all 50 states.

Approximation algorithm
1. Pick the station that covers the most states that haven’t been covered
yet. It’s OK if the station covers some states that have been covered
already.
2. Repeat until all the states are covered
'''

# list of states we want to cover (element can't be repeated)
states_needed = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])

# list of stations we're choosing from
stations = {}
stations["kone"] = set(["id", "nv", "ut"])
stations["ktwo"] = set(["wa", "id", "mt"])
stations["kthree"] = set(["or", "nv", "ca"])
stations["kfour"] = set(["nv", "ut"])
stations["kfive"] = set(["ca", "az"])

# final set of stations to be used
final_stations = set()

best_station = None
states_covered = set()

# while there's station that we haven't cover
while states_needed:
    best_station = None
    states_covered = set()

    for station, states_for_station in stations.items():
        # set intersection
        # set of uncovered states that this station covers
        covered = states_needed & states_for_station
        if len(covered)>len(states_covered):
            best_station = station
            station_covered = states_for_station

states_needed -= states_needed
final_stations.add(best_station)


# print(final_stations)

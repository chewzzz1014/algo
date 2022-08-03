# Implementing graph in Python using queue
# Implementing breadth-first search
from collections import deque

# illustrate the graph using dictionary
# the list associated with an key refer to its connection.
# eg, my connection include alice, bob and claire
graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "johnny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["johnny"] = []

# using breadth-first search to find ur connection
def person_is_connection(name):
    # let's assume that all my connection has name ends with letter "c"
    return (name[-1] == "c")

def search_connection(name):
    # create a new queue
    search_queue = deque()

    # add all of ur neighbors to queue
    search_queue += graph["you"]

    # before checking a person, make sure they haven't been checked already
    # keep a list of people already checked
    searched = []

    # while queue is not empty
    while search_queue:
        # pop the first person from the queue
        person = search_queue.popleft()

        # only search this person if haven't search them
        if not (person in searched):
            # is the person is my connection?
            if person_is_connection(person):
                # yes it's
                print(person+"is my connection!")
                return True
            else:
                # nope. add all of this person's connection to search queue
                search_queue += graph[person]
                # marked this person as searched
                searched.append(person)

    return False


print("Is my connection found?", search_connection("you") )
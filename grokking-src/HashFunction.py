# dictionary hash function equivalent in Python
# it's O(1), since we could access its value almost instantly
# demostrating use case of hash function and its implementation

# voter identity checker: have the voter vote?

voted = {}

def check_voter(name):
    if voted.get(name):
        print("Kick them out!")
    else:
        voted[name] = True
        print("Let them vote!")

# hash table as cache
cache = {}

def get_page(url):
    if cache.get(url):
        return cache[url]
    else:
        data = get_data_from_server(url)
        cache[url] = data
        return data

def get_data_from_server(url):
    # get something...
    return None
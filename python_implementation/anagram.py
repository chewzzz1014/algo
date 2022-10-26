# One string is an anagram of another if the second is simply a rearrangement of the first

def is_anagram(s1, s2):
    if len(s1) != len(s2):
        return False
    else:
        s1 = s1.lower()
        s2 = s2.lower()

        list_s1 = s1.split()
        list_s2 = s2.split()

        list_s1.sort()
        list_s2.sort()

        print(list_s1)
        print(list_s2)

        #return "".join(s1_list) == "".join(s2_list)


#print(is_anagram("heart", "earth"))
is_anagram("heart", "earth")
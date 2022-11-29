# convert an integer to a string in base 2-16

def toStr(n, base):
    convertStr = '0123456789ABCDEF'
    if n < base:
        return convertStr[n]
    else:
        return toStr(n//base, base) + convertStr[n%base]

print(toStr(1453, 16))
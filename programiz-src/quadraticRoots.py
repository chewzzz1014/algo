# calculating the roots of quadratic equation: ax^2 + bx + c = 0

# var: a, b, c, D, x1, x2, rp, ip
def find_roots(a, b, c):
    # calculate discriminant
    D = b*2 - 4*a*c

    if D >= 0:
        r1 = (-b + (D**0.5)) / (2*a)
        r2 = (-b - (D**0.5)) / (2*a)
        print("Root 1:", r1, "Root 2:", r2)

    else:
        # calculate real part and imaginary part
        rp = (-b) / (2*a)
        ip = (-D ** 0.5) / (2*a)
        print("Root 1:", round(rp, 2), "+", ip)
        print("Root 1:", round(rp, 2), "-", ip)


find_roots(1, 2, 3)
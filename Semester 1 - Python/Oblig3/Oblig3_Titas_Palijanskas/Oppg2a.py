import random

noenGanger = random.randrange(2, 5)

def RNG(tilfeldigGenerertTall):
    print(f"--/[ {tilfeldigGenerertTall} ]\\--")

for i in range(noenGanger):
    RNG(random.randrange(0, 101))
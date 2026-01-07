import random

antallSpillere = input("Hvor mange spillere er det som spiller?: ")
maksPiler = 3
sluttScore = 0
antallKastet = 1

for j in range(int(antallSpillere)): # j vil alltid starte på 0, må juste basert på spiller ved å legge til 1.
    print(f"\n\033[1m{j+1}. spiller:\033[0m")
    sluttScore = 0
    antallKastet = 1

    for i in range(int(maksPiler)): # Basert på hvor mange piler kastes vil poeng kalkuleres slik.
        poeng = random.randrange(0,60)
        print(f"{antallKastet}. kast: {poeng} poeng")
        antallKastet += 1
        sluttScore += poeng

    if sluttScore < 60: # Fargene avgjør hvor godt spilleren har gjort det.
        print(f"\033[91m{j+1}. spillers poeng: {sluttScore}\033[0m\n")
    elif sluttScore >= 60 and sluttScore < 120:
        print(f"\033[93m{j+1}. spillers poeng: {sluttScore}\033[0m\n")
    elif sluttScore >= 120:
        print(f"\033[92m{j+1}. spillers poeng: {sluttScore}\033[0m\n")


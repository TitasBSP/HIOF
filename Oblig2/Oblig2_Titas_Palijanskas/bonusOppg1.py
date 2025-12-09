import random

antallSpillere = int(input("\nHvor mange spillere er det som spiller?: "))
antallPiler = int(input("Hvor mange piler skal enhver spiller kaste?: "))
antallRunder = int(input("Hvor mange runder skal det spilles?: "))
sluttScore = 0
antallKastet = 1

miss = 0
outer_bullseye = 25
inner_bullseye = 50

def Dart2():

    for y in range(antallRunder): # Løkken for runder
        print(f"\n\033[1m{y+1}. runde:\033[0m")

        for j in range(int(antallSpillere)): # Løkken for enhver spiller
            print(f"\033[1m{j+1}. spiller:\033[0m")
            sluttScore = 0
            antallKastet = 1

            for i in range(int(antallPiler)):
                global outer_board 
                outer_board = random.randrange(1,21) # 1-20p

                flaks_outer_board = random.randrange(0,3) # Mulighet for å doble eller triple poeng

                if flaks_outer_board == 1:
                    outer_board *= 2
                elif flaks_outer_board == 2:
                    outer_board *= 3

                poeng_liste = [miss, outer_board, outer_bullseye, inner_bullseye]

                randomizer = random.randrange(0,51) # Forbedret RNG ved å definere sjansene for å få de forskjellige mål. Omtrent 10% for miss, 70% for vanlig poeng osv.
                if randomizer <= 5:
                    skudd = 0
                elif randomizer <= 40:
                    skudd = 1
                elif randomizer <= 49:
                    skudd = 2
                elif randomizer == 50:
                    skudd = 3

                poeng = poeng_liste[skudd] # Poeng trekkes ut fra det som er blitt utvalgt av randomizer
                
                print(f"{antallKastet}. kast: {poeng} poeng")
                antallKastet += 1
                sluttScore += poeng

            print(f"\033[92m{j+1}. spillers poeng: {sluttScore}\033[0m\n") # Summen skrives ut til slutt her!

Dart2()
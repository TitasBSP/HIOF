
for i in range(3):
    def regne3Dobjekt(l, b, h):
        volum = l * b * h
        return print(f"\n\033[1m{volum}\033[0m")

    lengde = 0
    while lengde <= 0:
        lengde = int(input("\nSkriv inn \033[1mlengden\033[0m på objektet: ")) # Sikrer at tallet er integer og er større enn 0
        if lengde <= 0:
            print("Tallet må være større enn 0")

    bredde = 0
    while not bredde:
        bredde = int(input("\nSkriv inn \033[1mbredden\033[0m på objektet: "))
        if bredde <= 0:
            print("Tallet må være større enn 0")

    hoyde = 0
    while not hoyde:
        hoyde = int(input("\nSkriv inn \033[1mhøyden\033[0m på objektet: "))
        if hoyde <= 0:
            print("Tallet må være større enn 0")

    regne3Dobjekt(lengde, bredde, hoyde)
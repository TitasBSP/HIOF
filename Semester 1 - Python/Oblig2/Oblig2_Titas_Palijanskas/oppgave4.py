a_List = ["The Hobbit", "Farmer Giles of Ham", "Lord of the Rings: The Fellowship of the Ring", "Lord of the Rings: The Two Towers", "Lord of the Rings: The Return of the King", "The Adventures of Tom Bobadil", "Tree and Leaf"]

print("\n1. FOR-Løkke")
for i in range(len(a_List)): # Måler antall bøker i listen for å utføre løkken så mange ganger
    if "Lord of the Rings" in a_List[i]: # Sorterer etter bøkene som oppfyller kriteriene av å ha LOTR i navnet
        print(f"{a_List[i]}")
    else:
        continue

print("\n2. FOR-Løkke")
for books in a_List: # Denne bruker en veldig enkel one-line if-statement som sparer plass, samme i praksis
    print(f"{books}") if "Lord of the Rings" in books else ...
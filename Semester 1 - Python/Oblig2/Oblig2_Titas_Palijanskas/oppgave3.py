boker = ["The Hobbit", "Farmer Giles of Ham", "The Fellowship of the Ring", "The Two Towers", "The Return of the King", "The Adventures of Tom Bobadil", "Tree and Leaf"]

print(f"{boker[0]}, {boker[1]}")
boker.reverse() # Python har en innebygd kommando for dette
print(f"{boker[0]}, {boker[1]}")

boker.reverse()
boker.append("The Silmarillion")
boker.append("Unfinished Tales") # Vi legger til nye bøker via .append kommandoen

boker[2] = "Lord of the Rings: The Fellowship of the Ring"
boker[3] = "Lord of the Rings: The Two Towers"
boker[4] = "Lord of the Rings: The Return of the King" # Vi endrer også på de eksisterende elementene.

print(f"\n{boker}")
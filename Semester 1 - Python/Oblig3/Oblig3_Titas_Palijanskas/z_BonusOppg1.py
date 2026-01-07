filmliste = [
    {"name": "Inception", "year": "2010", "rating": "8.7"},
    {"name": "Inside Out", "year": "2015", "rating": "8.1"},
    {"name": "Con Air", "year": "1997", "rating": "6.9"}
]

def appendFilm(liste, name, year, command = "a", rating = "5.0"):

    nyFilm = {
        "name" : name,
        "year": year,
        "rating": rating
    }

    if command == "a": # Legger til en ny dictionary til listen
        liste.append(nyFilm)

    elif command == "r":
        if nyFilm in liste: # Matcher dictionary med eksisterende dictionary i listen
            liste.remove(nyFilm)

    elif command == "c":
        if nyFilm in liste:
            changeCMD = input("Hva skal du endre? (name / year / rating): ")
            match changeCMD: # Matcher CMD (command) til det som er skrevet
                case "name":
                    newParameter = input("Enter the new name: ")
                    for film in liste:
                        if film["name"] == name:
                            film["name"] = newParameter
                case "year":
                    newParameter = input("Enter the new year: ")
                    for film in liste:
                        if film["year"] == str(year):
                            film["year"] = newParameter
                case "rating":
                    newParameter = input("Enter the new rating: ")
                    for film in liste:
                        if film["rating"] == str(rating):
                            film["rating"] = newParameter



appendFilm(filmliste, "Shrek", "2001", "a", "10.0")
appendFilm(filmliste, "Big", "1988", "a", "9.2")
appendFilm(filmliste, "Star Wars Episode IV: A New Hope ", "1977", "a", "8.7")

appendFilm(filmliste, "Blucher", "2025", "a") # Uten rating
appendFilm(filmliste, "Con Air", "1997", "r", "6.9")
appendFilm(filmliste, "Blucher", "2025", "c")

for film in filmliste:
    print(f"{film}\n")
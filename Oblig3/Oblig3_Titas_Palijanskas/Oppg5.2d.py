filmliste = [
    {"name": "Inception", "year": 2010, "rating": 8.7},
    {"name": "Inside Out", "year": 2015, "rating": 8.1},
    {"name": "Con Air", "year": 1997, "rating": 6.9},
    {"name": "The Lion King", "year": 1994, "rating": 8.5},
    {"name": "The Matrix", "year": 1999, "rating": 8.7},
    {"name": "Interstellar", "year": 2014, "rating": 8.6}
]

# Fra 5.1: Funksjon for å legge til film
def appendFilm(liste, name, year, rating = 5.0):
    nyFilm = {
        "name" : name,
        "year": year,
        "rating": rating
    }
    liste.append(nyFilm)

# Fra 5.1: Funksjon for å printe filmer formatert
def printFormattedFilm(liste):
    for i in range(len(liste)):
        print(f"{liste[i]['name']} - {liste[i]['year']} has a rating of {liste[i]['rating']}")

# Fra 5.1: Funksjon for gjennomsnittlig rating
def avgFilmRating(liste):
    avgRating = 0
    for i in range(len(liste)):
        avgRating += liste[i]["rating"]
    avgRating /= len(liste)
    print(f"Gjennomsnittsrating: {avgRating}")

# 5.2 A) Lag en funksjon som printer ut alle filmene i en gitt liste med filmer
def print_filmer(liste):
    for film in liste:
        print(f"{film['name']} - {film['year']} has a rating of {film['rating']}")

# 5.2 B) Lag en funksjon som tar en liste med filmer som parameter og regner ut 
# gjennomsnittsratingen for alle filmene i lista og returnerer dette
def gjennomsnitt_rating(liste):
    total = 0
    for film in liste:
        total += film['rating']
    return total / len(liste)

# 5.2 C) Lag en funksjon som tar en liste med filmer og et årstall som parametere,
# og returnerer en ny liste med alle filmer fra og med det gitte årstallet
def filmer_fra_aar(liste, aar):
    nye_filmer = []
    for film in liste:
        if film['year'] >= aar:
            nye_filmer.append(film)
    return nye_filmer

# Test fra 5.1
appendFilm(filmliste, "Shrek", 2001, 10.0)
appendFilm(filmliste, "Big", 1988, 9.2)
appendFilm(filmliste, "Star Wars Episode IV: A New Hope", 1977, 8.7)
appendFilm(filmliste, "Blucher", 2025) # Uten rating

print("Alle filmer:")
printFormattedFilm(filmliste)
print()

avgFilmRating(filmliste)
print()

# Test fra 5.2 B
print(f"Gjennomsnittsrating (returnert): {gjennomsnitt_rating(filmliste)}")
print()

# Test fra 5.2 C
filmer_fra_2010 = filmer_fra_aar(filmliste, 2010)
print("Filmer fra og med 2010:")
print_filmer(filmer_fra_2010)
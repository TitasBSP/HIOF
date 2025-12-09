filmliste = [
    {"name": "Inception", "year": 2010, "rating": 8.7},
    {"name": "Inside Out", "year": 2015, "rating": 8.1},
    {"name": "Con Air", "year": 1997, "rating": 6.9}
]

def appendFilm(liste, name, year, rating = 5.0):

    nyFilm = {
        "name" : name,
        "year": year,
        "rating": rating
    }

    liste.append(nyFilm)

def printFormattedFilm(liste):

    for i in range(len(liste)): # Denne blokkdelen tar lengden av listen og går gjennom hver dictionary og formaterer den på en fin måte
        print(f"\n{liste[i]["name"]} - {liste[i]["year"]} has a rating of {liste[i]["rating"]}")


def avgFilmRating(liste, avgRating = 0): # Denne funksjonen summerer alle ratingene i en variabel og deler på antall elementer i listen, altså gjennomsnitt.
    for i in range(len(liste)):
        avgRating += liste[i]["rating"]

    avgRating /= len(liste)
    print(f"\nAverage rating of all movies: {round(avgRating, 1)}")
    

def yearFilter(liste, year): # Et gitt parameter "year" vil avgrense hvilke filmer vises basert på gitt år og årene etter det.
    nyFilmListe = []

    for i in range(len(liste)):
        if liste[i]["year"] >= year:
            nyFilmListe.append(liste[i])
    
    print(f"\n\033[1mFilmer laget etter {year}\033[0m: ")
    printFormattedFilm(nyFilmListe)
            
appendFilm(filmliste, "Shrek", 2001, 10.0)
appendFilm(filmliste, "Big", 1988, 9.2)
appendFilm(filmliste, "Star Wars Episode IV: A New Hope", 1977, 9.8)

appendFilm(filmliste, "Blucher", 2025) # Uten rating

printFormattedFilm(filmliste)

avgFilmRating(filmliste)

yearFilter(filmliste, 2010)

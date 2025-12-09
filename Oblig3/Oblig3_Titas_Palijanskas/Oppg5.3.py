filmliste = [
    {"name": "Inception", "year": 2010, "rating": 8.7},
    {"name": "Inside Out", "year": 2015, "rating": 8.1},
    {"name": "Con Air", "year": 1997, "rating": 6.9}
]

skriveFilmListe = []

def appendFilm(liste, name, year, rating = 5.0):

    nyFilm = {
        "name" : name,
        "year": year,
        "rating": rating
    }

    liste.append(nyFilm)

def printFormattedFilm(liste): # Vi oppretter en tom liste der vi formaterer dictionaries

    for i in range(len(liste)):
        skriveFilmListe.append(f"\n{liste[i]["name"]} - {liste[i]["year"]} has a rating of {liste[i]["rating"]}")
        
        print(f"\n{liste[i]["name"]} - {liste[i]["year"]} has a rating of {liste[i]["rating"]}")

def avgFilmRating(liste, avgRating = 0):
    for i in range(len(liste)):
        avgRating += liste[i]["rating"]

    avgRating /= len(liste)
    print(f"\nAverage rating of all movies: {round(avgRating, 1)}")

def yearFilter(liste, year):
    nyFilmListe = []
    
    for i in range(len(liste)):
        if liste[i]["year"] >= year:
            nyFilmListe.append(liste[i])
    
    print(f"\n\033[1mFilmer laget etter {year}\033[0m: ")
    printFormattedFilm(nyFilmListe)

def writeFilmToFile(liste, fileName): # Tar en liste og filmnavn, deretter skriver den til filen, og hvis noe eksisterer på denne filen, vil den skrive over den.
    with open(f"{str(fileName)}.txt", "w") as f:

        for item in liste:
            f.write(item)
    
def readFilmFile(fileName): # Samt lese filen hvis funksjonen brukes!
    with open(f"{str(fileName)}.txt") as f:
        print(f.read())

            
appendFilm(filmliste, "Shrek", 2001, 10.0)
appendFilm(filmliste, "Big", 1988, 9.2)
appendFilm(filmliste, "Star Wars Episode IV: A New Hope", 1977, 9.8)

appendFilm(filmliste, "Blucher", 2025) # Uten rating

printFormattedFilm(filmliste)

avgFilmRating(filmliste)

yearFilter(filmliste, 2010)

writeFilmToFile(skriveFilmListe, "movies")

readFilmFile("movies")



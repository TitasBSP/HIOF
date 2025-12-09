filmliste = [
    {"name": "Inception", "year": "2010", "rating": "8.7"},
    {"name": "Inside Out", "year": "2015", "rating": "8.1"},
    {"name": "Con Air", "year": "1997", "rating": "6.9"}
]

def appendFilm(liste, name, year, rating = "5.0"): # Lager en ny dictionary med gitte parametre

    nyFilm = {
        "name" : name,
        "year": year,
        "rating": rating
    }

    liste.append(nyFilm)

appendFilm(filmliste, "Shrek", "2001", "10.0")
appendFilm(filmliste, "Big", "1988", "9.2")
appendFilm(filmliste, "Star Wars Episode IV: A New Hope ", "1977", "8.7")
appendFilm(filmliste, "Blucher", "2025") # Her kan man se at jeg ikke inkluderte rating, men funksjonen vil likevel legge til en default rating.

for film in filmliste:
    print(f"{film}\n")
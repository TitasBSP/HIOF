# A) Opprett en liste med filmer
filmer = [
    {"name": "Inception", "year": 2010, "rating": 8.7},
    {"name": "Inside Out", "year": 2015, "rating": 8.1},
    {"name": "Con Air", "year": 1997, "rating": 6.9}
]

# B) Opprett en funksjon som legger til en film i filmlisten
def legg_til_film(liste, name, year, rating):
    film = {"name": name, "year": year, "rating": rating}
    liste.append(film)

# Benytt funksjonen til å legge til 3 filmer du selv bestemmer
legg_til_film(filmer, "The Matrix", 1999, 8.7)
legg_til_film(filmer, "Interstellar", 2014, 8.6)
legg_til_film(filmer, "The Shawshank Redemption", 1994, 9.3)

# C) Modifiser funksjonen til å sette default-ratingen til 5.0
def legg_til_film(liste, name, year, rating=5.0):
    film = {"name": name, "year": year, "rating": rating}
    liste.append(film)

# Test at dette fungerer ved å legge til en film uten å spesifisere rating
legg_til_film(filmer, "Test Film", 2020)

print(filmer)
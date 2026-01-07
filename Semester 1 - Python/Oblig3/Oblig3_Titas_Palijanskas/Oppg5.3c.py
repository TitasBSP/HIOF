filmliste = [
    {"name": "Inception", "year": 2010, "rating": 8.7},
    {"name": "Inside Out", "year": 2015, "rating": 8.1},
    {"name": "Con Air", "year": 1997, "rating": 6.9}
]

# Fra 5.1 B) Opprett en funksjon som legger til en film i filmlisten
def legg_til_film(liste, name, year, rating=5.0):
    film = {"name": name, "year": year, "rating": rating}
    liste.append(film)

# Benytt funksjonen til å legge til 3 filmer
legg_til_film(filmliste, "The Matrix", 1999, 8.7)
legg_til_film(filmliste, "Interstellar", 2014, 8.6)
legg_til_film(filmliste, "The Shawshank Redemption", 1994, 9.3)

# Test at default-ratingen fungerer
legg_til_film(filmliste, "Test Film", 2020)

# 5.2 A) Lag en funksjon som printer ut alle filmene
def print_filmer(liste):
    for film in liste:
        print(f"{film['name']} - {film['year']} has a rating of {film['rating']}")

# 5.2 B) Lag en funksjon som regner ut gjennomsnittsratingen
def gjennomsnitt_rating(liste):
    total = 0
    for film in liste:
        total += film['rating']
    return total / len(liste)

# Test funksjonen og skriv ut gjennomsnittet
print("Alle filmer:")
print_filmer(filmliste)
print(f"\nGjennomsnittsrating: {gjennomsnitt_rating(filmliste)}")

# 5.2 C) Lag en funksjon som returnerer filmer fra og med et gitt årstall
def filmer_fra_aar(liste, aar):
    nye_filmer = []
    for film in liste:
        if film['year'] >= aar:
            nye_filmer.append(film)
    return nye_filmer

# Benytt funksjonen og print ut filmer fra og med 2010
filmer_fra_2010 = filmer_fra_aar(filmliste, 2010)
print("\nFilmer fra og med 2010:")
print_filmer(filmer_fra_2010)

# 5.3 A) Opprett en funksjon som skriver alle filmene til en fil
def skriv_filmer_til_fil(liste, filnavn):
    with open(filnavn, 'w') as fil:
        for film in liste:
            fil.write(f"{film['name']} - {film['year']} has a rating of {film['rating']}\n")

# Benytt funksjonen til å skrive alle filmene til en fil
skriv_filmer_til_fil(filmliste, "movies.txt")

# 5.3 B) Lag en funksjon som leser filen og skriver ut innholdet til terminalen
def les_og_skriv_fil(filnavn):
    with open(filnavn, 'r') as fil:
        innhold = fil.read()
        print(innhold)

# Test funksjonen
print("\nInnhold fra fil:")
les_og_skriv_fil("movies.txt")
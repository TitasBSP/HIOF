# 1. Lag en dictionary med informasjon om en student
student = {
    "fornavn": "Titas",
    "etternavn": "Palijanskas",
    "favorittkurs": "Programmering 1"
}

# 2. Skriv ut studentens fullstendige navn
print(student["fornavn"], student["etternavn"])

# 3. Programmatisk endre studentens favorittkurs til å inkludere kursets emnekode
student["favorittkurs"] = "ITF10219 Programmering 1"

# 4. Programmatisk legg til en alder for studenten i dictionarien
student["alder"] = 19
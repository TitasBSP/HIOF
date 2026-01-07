class Film:
    def __init__(self, filmtittel, utgivelsesaar, rating): # Initialiserer alle variablene uten å måtte ha en spesifikk verdi med en gang
        self.filmtittel = str(filmtittel)
        self.utgivelsesaar = int(utgivelsesaar)
        self.rating = float(rating)
        
    def printList(self): # Skriver ut den forespurte setningen
        return f"\n{self.filmtittel} was released in {self.utgivelsesaar} and currently has a score of {self.rating}"   
    
film1 = Film("Inception", 2010, 8.8) # Lager nye objekter for klassen
film2 = Film("The Martian", 2015, 8.0)
film3 = Film("Joker", 2019, 8.4)   

print(film1.printList(), film2.printList(), film3.printList()) # Sparer linjer ved å printe alt ut
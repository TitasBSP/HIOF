maxTall = 102 # 102 for å få til 101 før programmet slutter
iterasjonsTall = 9

while not maxTall <= iterasjonsTall:
    print(int(iterasjonsTall))
    iterasjonsTall += 2 # Oddetall er alltid 2 tall etter hverandre, derav er det praktisk å iterere gjennom tallene slikt

for i in range(9, maxTall, 2): # Samme skjer her, fordi vi starter på 9, slutter når maxtall er nådd og "step"'er med 2 hver gang.
    print(i)

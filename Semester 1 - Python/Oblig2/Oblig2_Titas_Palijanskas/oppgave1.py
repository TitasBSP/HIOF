tall = input("Hva er svaret på det ultimate spørsmålet om livet, universet og alle ting? Hint: Det er et tall\n:: ")


if int(tall) == 42: 
    print("Det stemmer, meningen med livet er 42!")
elif int(tall) >= 30 and int(tall) <= 50:
    print("Nærme, men feil.")
else:
    print("FEIL!")
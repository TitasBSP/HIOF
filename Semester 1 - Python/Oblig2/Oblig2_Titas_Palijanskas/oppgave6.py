import time

packingList = []
running = True

while running: # 4 forskjellige kommandoer som kjører i uendelig løkke.
    userInput = input("\n[TAST INN KOMMANDO] (/help for hjelp): ")

    if userInput == "/help":
        print("\nKommandoer:\n/add: Lar deg legge til noe\n/remove: Fjerner et utvalgt ting fra listen\n/list: Viser here listen\n/exit: Avslutte programmet")

    elif userInput == "/add":
        addInput = input("Navngi objekten: ")

        if len(addInput) > 0:
            packingList.append(addInput)
            print(f"'{addInput}' har blitt lagt til listen!")
        else:
            print("UGYLDIG NAVN!")

    elif userInput == "/remove":
        print(packingList)
        removeInput = input("Velg et objekt å fjerne: ")
        packingList_lower = list(map(str.lower, packingList))

        for i in range(len(packingList)):
            if removeInput.lower() == packingList_lower[i].lower(): # Jeg er litt usikker på hvorfor det ikke virker å ha .lower() uten å definere en egen variabel for det, men det hjalp!
                print(f"{packingList[i]} fjernet fra listen!") # Sjekker at objektet heter det samme ved å konvertere både brukerens input og elementet til lowercase.
                packingList.remove(packingList[i])

    elif userInput == "/list":
        print(f"Her er objektene som ligger i listen!:\n{packingList}")
        time.sleep(2)

    elif userInput == "/exit":
        quit()
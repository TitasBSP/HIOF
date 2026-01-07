import json

names = ["Ole, Johannes, Steffen, Tor"]
emptyDictionary = {}

def writeToFile(fileName, listName):
    if fileName.endswith(".txt"): # Hvis man skriver inn filnavn med .txt på slutten så vil den erstatte .txt-en, lettere å behandle navn både med og uten .txt
        fileName = fileName.replace(".txt", "")

    with open(f"{str(fileName)}.txt", "w") as file:
        file.write('\n'.join(listName))
    
def readFromFile(fileName): # Samme her, men med lesing
    if fileName.endswith(".txt"):
        fileName = fileName.replace(".txt", "")

    with open(f"{str(fileName)}.txt", "r") as file:
        print(file.read())

def writeJsonToFile(fileName, dictionary): # Samme kompatibilitet med .json
    if fileName.endswith(".json"):
        fileName = fileName.replace(".json", "")

    with open(f"{str(fileName)}.json", "w") as file: # Istedenfor file.write, bruker json ".dump()" for å skrive og formatere i json format
        json.dump(dictionary, file)

def readFromJsonFile(fileName, dicts): # Samme gjelder her, men med lesing
    if fileName.endswith(".json"):
        fileName = fileName.replace(".json", "")

    with open(f"{str(fileName)}.json", "r") as file:
        dicts = json.load(file)
        print(dicts)

writeToFile("brothers", names)

readFromFile("brothers")

writeJsonToFile("sister", {"Name": "Evelyn", "Age": "24"})

readFromJsonFile("sister", emptyDictionary)

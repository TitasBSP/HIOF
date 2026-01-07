from datetime import date

car_register = {
    "toyotaBZ4X": {
        "brand": "Toyota",
        "model": "Corolla",
        "price": 96_000,
        "year": 2012,
        "month": 8,
        "new": False,
        "km": 163_000
    },
    "peugeot408": {
        "brand": "Pugeot",
        "model": "408",
        "price": 330_000,
        "year": 2019,
        "month": 1,
        "new": False,
        "km": 40_000
    },
    "audiRS3": {
        "brand": "Audi",
        "model": "RS3",
        "price": 473_000,
        "year": 2022,
        "month": 2,
        "new": True,
        "km": 0
    },
}

TOTAL_PRICE_FEE = 10783
RENT_CAR_PERCENTAGE = 0.4
RENT_NEW_CAR__FEE = 1000

# Oppg1
def print_car_information(car):
    if is_new(car) == True: # Sant gir brand new, ellers used.
        print(f"Brand: {car['brand']}, \nModel: {car['model']} \nPrice: {car['price']},- \nManufactured: {car['year']}-{car['month']} \nCondition: Brand New")
    else:
        print(f"Brand: {car['brand']}, \nModel: {car['model']} \nPrice: {car['price']},- \nManufactured: {car['year']}-{car['month']} \nCondition: Used")

# Oppg2
def create_car(car_register, brand, model, price, year, month, new, km):
    car_register = {} # Oppretter, dictionary, forsøkte å legge alt i en linje, men tydeligvis ville ikke update-funksjonen akseptere mer enn en argument.
    car_register.update({'brand': brand})
    car_register.update({"model": model})
    car_register.update({"price": price})
    car_register.update({"year": year})
    car_register.update({"month": month})
    car_register.update({"new": new})
    car_register.update({"km": km})
    
    return car_register

# Oppg3
def get_car_age(car): # Henter dagens dato, tar delta av nåværende år og bilens produksjonsår
    today = date.today()
    age = today.year - car["year"]

    return age

# Oppg4
def rent_car_monthly_price(car): # Basisprisen er bilenspris ganger med 0.4 for å få 40%, også delen man det over 12 måneder. 
    baseMonthlyPrice = (car["price"] * RENT_CAR_PERCENTAGE) / 12
    newCarMonthlyPrice = baseMonthlyPrice + RENT_NEW_CAR__FEE # Avgiften som skulle legges til uansett hva
    
    return round(newCarMonthlyPrice, 2)
    
# Oppg5
def next_eu_control(car): # Henter produksjonsår og måned, øker produksjonsåret helt til forskjellen mellom de er 1 år (måneder ekskl. fordi 2 år hadde latt det være 2år1mnd. osv.)
    manufactureYear = car["year"]
    manufactureMonth = car["month"]
    
    today = date.today()
    while (today.year - manufactureYear) > 1:
        manufactureYear += 2
        
    manufactureDate = date(manufactureYear, manufactureMonth, 1) 
    nextTime = today - manufactureDate # Neste eu-kontroll regnes basert på deltaen mellom dagens dato og den nye produksjonsdato.
    
    return nextTime

# Oppg6
def calculate_total_price(car): # Basert på deltaen mellom nåværende år og produksjonsår vil avgiften beregnes.
    today = date.today()
    deltaAge = today.year - car["year"]
    totalPrice = car["price"]
    
    if car["new"] == True:
        totalprice += TOTAL_PRICE_FEE
        
    elif car["new"] == False:
        if deltaAge <= 3:
            totalPrice += 6681
        elif 4 >= deltaAge <= 11:
            totalPrice += 4034
        elif 12 >= deltaAge <= 29:
            totalPrice += 2729
            
    return totalPrice

# Oppg7, slik jeg forsto oppgaven skulle jeg lage klasse, og metoder uten å legge logikken inn (?)
class Car:
    def __init__(self, brand, model, price, year, month, new, km):
        self.brand = brand
        self.model = model
        self.price = price
        self.year = year
        self.month = month
        self.new = new
        self.km = km
        
    def eu_control(self):
        pass
        # Bruker ikke selve modellen som nøkkel, dermed er det lettvint og lettere å forstå når det er lagt til som metode
    
    def car_age(self):
        pass
        # Samme gjelder for denne, og det blir mer forståelig med self.month enn car["month"] siden man vet hvilken klasse man referer til.
        
    def print_info(self):
        pass
        # Litt mindre karakterer, bedre formatert = bedre kode!   
          

def is_new(car):
    return car['new']

if __name__ == '__main__':
    create_car(car_register, "Volvo", "V90", 850_000, 2021, 12, True, 0)
    toyota = car_register['toyotaBZ4X']
    print_car_information(toyota)
    print(f"\nThe total price for this {toyota['brand']} {toyota['model']} is {calculate_total_price(toyota)}kr.")
    print(f"Next EU-control for the {toyota['brand']} {toyota['model']} is {next_eu_control(toyota)}")
    print(f"If you want to rent the {toyota['brand']} {toyota['model']} the monthly fee will be {rent_car_monthly_price(toyota)}.")
    audi = car_register['audiRS3']
    print_car_information(audi)
    print(f"\nThe total price for this {audi['brand']} {audi['model']} is {calculate_total_price(audi)}kr.")
    print(f"Next EU-control for the {audi['brand']} {audi['model']} is {next_eu_control(audi)}")
    print(f"If you want to rent the {audi['brand']} {audi['model']} the monthly fee will be {rent_car_monthly_price(audi)}kr.")

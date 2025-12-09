from wallet import wallet

all_wares = {
    "amd_processor": {
    "name": "AMD Ryzen 9 5900X Processor",
    "price": 5590.0,
    "number_in_stock": 50,
    "ratings": [4.5, 4.0, 5.0, 5.0, 4.5, 3.0],
    "description": "All the cores and threads you'll need!",
    },
    "playstation_5": {
    "name": "PlayStation 5",
    "price": 5999.0,
    "number_in_stock": 0,
    "ratings": [5.0, 5.0, 4.5, 2.0, 5.0, 4.5, 4.0],
    "description": "Next generation console, never in stock!",
    },
    "hdmi_cable": {
    "name": "Belkin Ultra High Speed HDMI Cable - 2m",
    "price": 349.0,
    "number_in_stock": 3,
    "ratings": [5.0, 5.0, 4.5, 5.0, 5.0, 5.0],
    "description": "A high speed overprices HDMI cable!",
    }
}

shopping_cart = {}

#------------------------------------------
# Predefinerte funksjoner
#------------------------------------------

def is_ware_in_stock(ware):
        
    '''Returnerer en Boolean-verdi som representerer om en vare er på lager.'''
    if ware["number_in_stock"] >= 1:
        return True
    else:
        return False
def clear_shopping_cart(shopping_cart):
    shopping_cart.clear()
'''Tømmer en handlevogn.'''

# Oppg1, prøvde å eksperimentere med list.
def print_ware_information(ware):
    valueList = list(ware.values())
    print(f"Name: {valueList[0]} \nPrice: {valueList[1]} \nNumber in stock: {valueList[2]} \nDescription: {valueList[4]}\n")

# Oppg2
def calculate_average_ware_rating(ware): # Summerer alle ratings og deler det på lengden av ratings-array, med unntak av hvis det finnes ingen ratings.
    average = 0
    try:
        average += sum(ware["ratings"])
        average /= len(ware["ratings"])
    except ZeroDivisionError:
        print("Error: The list given has no ratings and therefore the average cannot be calculated.")
    
    return round(average, 1)

# Oppg3
def get_all_wares_in_stock(all_wares): # Lager dictionary, lister alle varene, og alle varene som er på lager legges til i dictionary.
    wares = {}
    items = list(all_wares)
    for i in range(len(all_wares)):
        if all_wares[items[i]]["number_in_stock"] > 0:
            wares.update({items[i]: all_wares[items[i]]
            })
    
    return wares

# Oppg4
def is_number_of_ware_in_stock(ware, number_of_ware): # Lister verdiene, sjekker om antall på lager er mindre enn det som er bedt, og returnerer basert på det.
    values = list(ware.values())
    if values[2] < number_of_ware:
        return False
    else:
        return True

# Oppg5
def add_number_of_ware_to_shopping_cart(ware_key, ware, shopping_cart, number_of_ware=1): # Hvis antall ønsket varer er mer enn der som er på lager, blir det maksimum antallet på lager lagt til med en melding som viser at kjøpet var ikke fullstendig.
    stockNum = list(ware.values())[2]
    if stockNum < number_of_ware:
        print("Given number exceeds the amount in stock, maximum amount of items in stock will be added.")
        shopping_cart.update({ware_key: stockNum})
        return stockNum
    else: # Ellers legger den bare til det ønsket antallet.
        shopping_cart.update({ware_key: number_of_ware})
        return number_of_ware

# Oppg6
def calculate_shopping_cart_price(shopping_cart, all_wares, tax): # Kalkulerer både prisen til enhver produkt samt ganger det med antall, og evt. legger til avgift / skatt.
    price = 0
    for ware_key, quantity in shopping_cart.items():
        price += all_wares[ware_key]["price"] * quantity
    price_after_tax = price * tax
    return price_after_tax

# Oppg7
def can_afford_shopping_cart(shopping_cart_price, wallet): # Bestemmer om man har råd til handlekurven ved å hente gjenstående penger i lommebokken-objektet
    return shopping_cart_price <= wallet.get_amount()
    
# Oppg8
def buy_shopping_cart(shopping_cart, ware_key, tax, wallet, item_amount, pay):
    global all_wares
    ware = all_wares[ware_key]

    if is_ware_in_stock(ware): # Sjekker om varen er på lager, og dermed legger til varene i handlekurven
        actual_added = add_number_of_ware_to_shopping_cart(ware_key, ware, shopping_cart, item_amount)

        ware["number_in_stock"] -= actual_added # Trekker antallet lagt til handlekurven fra antallet på lager

        shopping_cart_price = calculate_shopping_cart_price(shopping_cart, all_wares, tax) # Lagrer prisen til handlekurven i en variabel

        if pay == True: # Hvis personen vil betale for handlekurven med engang, sjekker vi at de har råd for den, også trekker vi summen fra lommeboken før vi tømmer handlekurven. 
            if can_afford_shopping_cart(shopping_cart_price, wallet):
                wallet.subtract_amount(shopping_cart_price)
                print("Transaction complete, item(s) in cart are bought and the cart is empty now.")
                shopping_cart.clear()
            else: # Alle de andre prosessene vil gi en feilmelding dersom det mangler noe fra brukeren.
                print("Insufficient funds for the current purchase")

        else:
            print("The transaction declined by request")  

    elif ware_key in shopping_cart:
        print("Cannot add more of this item as there is not more of this item in stock.")

    else:
        shopping_cart.pop(ware_key, None)
    
# Fix task 6

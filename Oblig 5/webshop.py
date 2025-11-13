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

# Oppg1
def print_ware_information(ware):
    valueList = list(ware.values())
    print(f"\nName: {valueList[0]} \nPrice: {valueList[1]} \nNumber in stock: {valueList[2]} \nDescription: {valueList[4]}\n")
    
print_ware_information(all_wares["amd_processor"]) # Test

# Oppg2
def calculate_average_ware_rating(ware):
    average = 0
    try:
        average += sum(ware["ratings"])
        average /= len(ware["ratings"])
    except ZeroDivisionError:
        print("Error: The list given has no ratings and therefore the average cannot be calculated.")
    
    return round(average, 1)
    
calculate_average_ware_rating(all_wares["hdmi_cable"]) # Test

# Oppg3
def get_all_wares_in_stock(all_wares):
    wares = {}
    items = list(all_wares)
    for i in range(len(all_wares)):
        if all_wares[items[i]]["number_in_stock"] > 0:
            wares.update({items[i]: all_wares[items[i]]
            })
    
    return wares
    
get_all_wares_in_stock(all_wares) # Test

# Oppg4
def is_number_of_ware_in_stock(ware, number_of_ware):
    values = list(ware.values())
    if values[2] < number_of_ware:
        return False
    else:
        return True

is_number_of_ware_in_stock(all_wares["hdmi_cable"], 4)

# Oppg5
def add_number_of_ware_to_shopping_cart(ware_key, ware, shopping_cart, number_of_ware=1):
    stockNum = list(ware.values())[2]
    if stockNum < number_of_ware:
        print("Given number exceeds the amount in stock, please enter an amount equal or less than the stock.")
    else:
        shopping_cart.update({ware_key: number_of_ware})
    
    return print(shopping_cart)

add_number_of_ware_to_shopping_cart("amd_processor", all_wares["amd_processor"], shopping_cart)


def calculate_shopping_cart_price(shopping_cart, all_wares, tax):
    ...
'''Returnerer prisen av en handlevogn basert på varene i den.'''
def can_afford_shopping_cart(shopping_cart_price, wallet):
    ...
'''Returnerer en Boolean-verdi basert på om det er nok penger i en gitt
lommebok for å kjøpe en handlevogn.'''
def buy_shopping_cart():
    ...
'''Kjøper varene i en handlevogn. Parameterene defineres i oppgaven.'''
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

"""

import random

def tallgenerering():
    tall = random.randrange(0, 101)
    return "*" * tall

# Kall funksjonen noen ganger
print(tallgenerering())
print(tallgenerering())
print(tallgenerering())

""" # Første forsøk, skrev bare stjernet og ikke tall

import random

def tallgenerering():
    tall = random.randrange(0, 101)
    return tall

# Kall funksjonen noen ganger
print(tallgenerering())
print(tallgenerering())
print(tallgenerering())

# Andre forsøk, virker fullstendig etter forespørsel
import random as rand
import time
import os

inSession = True
stand = False
balance = 100
prizePool = 0
playerCards = []
dealersCards = []
playerHandValue = 0
dealerHandValue = 0

suits = ["♠", "♥", "♦", "♣"]
cardValues = {}

for suit in suits:
    cardValues[f"2{suit}"] = 2
    cardValues[f"3{suit}"] = 3
    cardValues[f"4{suit}"] = 4
    cardValues[f"5{suit}"] = 5
    cardValues[f"6{suit}"] = 6
    cardValues[f"7{suit}"] = 7
    cardValues[f"8{suit}"] = 8
    cardValues[f"9{suit}"] = 9
    cardValues[f"10{suit}"] = 10
    cardValues[f"J{suit}"] = 10
    cardValues[f"Q{suit}"] = 10
    cardValues[f"K{suit}"] = 10
    cardValues[f"A{suit}"] = 11

def checkImmediateWin(hand1, hand2):
    global prizePool

    if ((hand1 == 21) and (hand2 == 21)) or (hand1 == hand2) and (hand1 > 0):
        print("Equal hand value! Nobody wins :(")
        playAgain()

    elif hand1 == 21:
        print(f"Blackjack, you won!")
        balance += 2*prizePool
        playAgain()

    elif hand2 == 21:
        print(f"BLACKJACK, the dealer won?!")
        prizePool = 0
        playAgain()

    if hand1 > hand2:
        print(f"Your hand; {getHandValue(playerHandValue)} was greater than dealer's hand with a value of {getHandValue(dealerHandValue)}")
        playAgain()
        

def playAgain():
    global inSession
    inLoop = True
    inSession = False
    
    while inLoop:
        choice = input("Play again? (Y/N): ")
        if choice.lower() == "y":
            inSession = True
            break
        elif choice.lower() == "n":
            print("Goodbye, User!")
            quit()
        else:
            print("Invalid input, please try again!")


def shuffleCards(cards):
    cardArr = list(cardValues.keys())
    rand.shuffle(cardArr)

    for i in range(2):
        playerCards.append(cardArr.pop())
        dealersCards.append(cardArr.pop())

    return cardArr, playerCards, dealersCards 

def getHandValue(arr, handValue):
    global playerHandValue
    global dealerHandValue

    for i in range(len(arr)):
        handValue += cardValues[arr[i]]

    return handValue

def session(bet, cardArr):
    global stand

    while not stand:
        os.system('clear')
        print(f"Dealer's Card: [{dealersCards[0]}]")
        print(f"Your cards: {playerCards}\nYour hand value: {getHandValue(playerCards, playerHandValue)}")
        initChoice = input(f"\n(1) - Hit, (2) - Stand -: ")

        if initChoice != 1 or initChoice != 2:
            print(f"\nInvalid input, please follow the shown choices.")
            time.sleep(2)
        elif initChoice == 1:
            playerCards.append(cardArr.pop())
            dealersCards.append(cardArr.pop())

            print(f"\nYou chose to Hit!")
            time.sleep(1)
            yourHand = getHandValue(playerCards, playerHandValue)
            theirHand = getHandValue(dealerCards, dealerHandValue)

            if yourHand > 21:
                print(f"Sorry bucko, you busted!")
            elif theirHand > 21:
                print(f"Lucky for you.. the dealer busted!")
                balance += prizePool
                prizePool = 0

        elif initChoice == 2:
            stand = True


cards, playerCards, dealerCards = shuffleCards(cardValues)

while inSession:
    os.system('clear')
    try:
       bet = int(input(f"\nPlease present your bet (Must be greater than 0 and below your current balance: {balance}): "))
           
    except ValueError:
        print("\nError, non-integer presented, please enter an integer")
        continue

    if bet <= 0 or bet >= balance:
        print(f"\nYour bet is larger than your current balance. Balance: {balance}")
    else:
        balance -= bet
        prizePool += bet*2
        checkImmediateWin(playerHandValue, dealerHandValue)
        session(bet, cards)

## TO-DO:
'''
Figure out how to search multiple aces in a hand, decrease score by 10 when there are 2 and more aces.
'''
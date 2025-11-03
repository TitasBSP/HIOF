import random as rand
import time
import os

inSession = False
inRound = False
stand = False
balance = 100
prizePool = 0
playerCards = []
dealerCards = []
playerHandValue = 0
dealerHandValue = 0
aceCounter = 0

suits = ["♠", "♥", "♦", "♣"] # Sets up the different types of cards, then the for loop adds these values to a dictionary
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

def playAgain(): # Safe function to reset most values and ensure the player can go back to the initial loop or exit
    global inSession
    global bet
    global stand
    global balance
    global prizePool
    global playerCards      
    global dealerCards
    global aceCounter
    global inRound

    inLoop = True
    
    while inLoop:
        choice = input("Play again? (Y/N): ")
        if choice.lower() == "y":
            bet = 0
            prizePool = 0
            aceCounter = 0
            inLoop = False
            stand = False
            inRound = False
            return True
        elif choice.lower() == "n":
            print("Goodbye, User!")
            quit()
        else:
            print("Invalid input, please try again!")

def checkWin(hand1, hand2): # Possible outcomes: Equal hand value, player wins, or dealer wins
    os.system('cls')
    global prizePool
    global balance
    global playerCards
    global dealerCards
    global playerHandValue
    global dealerHandValue

    if ((hand1 == 21) and (hand2 == 21)) or (hand1 == hand2) and (hand1 > 0):
        print("Equal hand value! Nobody wins :(")
        balance += prizePool//2
        playAgain()
        return True

    elif hand1 > hand2:
        print(f"Your hand; {getHandValue(playerCards, playerHandValue)} was greater than dealer's hand with a value of {getHandValue(dealerCards, dealerHandValue)}")
        balance += prizePool
        playAgain()
        return True
    
    elif hand1 < hand2:
        print(f"The dealer's hand; {getHandValue(dealerCards, dealerHandValue)} was greater than your hand with a value of {getHandValue(playerCards, playerHandValue)}")
        playAgain()
        return True
        
def checkBlackjack(hand1, hand2): # Possible outcomes: Player blackjacks, or dealer blackjacks, or BOTH. But what are the odds, really? :)
    os.system('cls')
    global balance
    global prizePool
    
    if (hand1 > 21) and (hand2 > 21):
        print(f"Both blackjacked..? Impossible..")
        balance += prizePool//2
        playAgain()
        return True

    if hand1 == 21:
        print(f"Blackjack, you won!")
        balance += 2*prizePool
        playAgain()
        return True

    elif hand2 == 21:
        print(f"BLACKJACK, the dealer won?!")
        playAgain()
        return True

def checkBust(yourHand, theirHand): # Possible outcomes: Player busts, dealer busts, or both bust.
    os.system('cls')
    global balance
    global prizePool
    
    if (yourHand > 21) and (theirHand > 21):
        print(f"Gentlemen, you have both busted! Better luck next time :)")
        balance += prizePool//2
        playAgain()
        return True

    elif yourHand > 21:
        print(f"Sorry bucko, you busted!")
        playAgain()
        return True

    elif theirHand > 21:
        print(f"Lucky for you.. the dealer busted!")
        balance += prizePool
        playAgain()
        return True

def shuffleCards(): # Lists the keys of a dictionary, then shuffles them. Clears player and dealer hands for a fresh start each round. Then 2 hands are given to each player
    global playerCards
    global dealerCards
    global cardValues
    
    cardArr = list(cardValues.keys())
    rand.shuffle(cardArr)
    playerCards.clear()
    dealerCards.clear()

    for i in range(2):
        playerCards.append(cardArr.pop())
        dealerCards.append(cardArr.pop())

    return cardArr, playerCards, dealerCards 

def getHandValue(arr, handValue): # Simple calculation for hand value. Takes each element in array and adds the assigned value to the hand, logic for ace counting applies in the event that 1 point might be advantageous.
    global playerHandValue
    global dealerHandValue
    global aceCounter

    for i in range(len(arr)):
        if "A" in arr[i]:
            aceCounter += 1

        if aceCounter > 1:
            handValue -= 10
            aceCounter -= 1
        
        handValue += cardValues[arr[i]]

    aceCounter = 0

    return handValue

def session(bet, cardArr): # Main game part until someone stands.
    global stand
    global balance
    global prizePool
    global playerCards      
    global dealerCards
    global playerHandValue 
    global dealerHandValue
    global inSession
    global inRound

    stand = False

    while inRound: # We first get the players' hand values, then instantly check for possible blackjacks or busts.
        yourHand = getHandValue(playerCards, playerHandValue)
        theirHand = getHandValue(dealerCards, dealerHandValue)

        if checkBlackjack(yourHand, theirHand):
            inRound = False
            return
        if checkBust(yourHand, theirHand):
            inRound = False
            return

        os.system('cls') # First dealer's card is shown as requested.
        print(f"Dealer's Card: [{dealerCards[0]}]")
        print(f"Your cards: {playerCards}\nYour hand value: {yourHand}")
        initChoice = input(f"\n(1) - Hit, (2) - Stand -: ")
            
        if initChoice == '1': # Added to players' hands, removed from card array to remove doubling.
            playerCards.append(cardArr.pop())
            dealerCards.append(cardArr.pop())
            time.sleep(1)

        elif initChoice == '2': # Recalculate hands, then check for busts, blackjacks or wins
            stand = True
            
            yourHand = getHandValue(playerCards, playerHandValue)
            theirHand = getHandValue(dealerCards, dealerHandValue)
            
            if checkBust(yourHand, theirHand):
                inRound = False
                return
            if checkBlackjack(yourHand, theirHand):
                inRound = False
                return
            if checkWin(yourHand, theirHand):
                inRound = False
                return

        else:
            print(f"\nInvalid input, please follow the shown choices.")
            time.sleep(2)

instruct = input("Would you like to get a briefing of the rules? (Y/N): ") # Instruction for newcomers

if instruct.lower() == 'y':
    print(f"What you need to know:\n- Each card is worth itself, except J,Q and K which are worth 10, and A being worth 1 or 11 depending on what's advantageous for your hand\n- If you or the dealer hit a Blackjack, i.e. a hand that is worth 21, the hand holder wins, or nobody depending if you both hold the same value.\n- You can choose to either hit (get a new card), or stand (show off your card value and determine the winner that way).\n- If a player has a hand over the value of 21, they bust, as in they lose the game and their bet :(\n- You start with 100 chips, do your best and maybe get a HIGH SCORE!")
    yn = input("\nType anything to continue: ")
    inSession = True
elif instruct.lower() == 'n':
    inSession = True

while inSession: # Main starting loop, takes balance checks and stores variables from previously mentioned functions
    if balance <= 0:
        print("Game Over...")
        quit()
    os.system('cls')
    try:
       bet = int(input(f"Please present your bet (Must be greater than 0 and below your current balance: {balance}): "))
    except ValueError:
        print("\nError, non-integer presented, please enter an integer")
        continue

    if bet <= 0 or bet > balance:
        print(f"\nYour bet is larger than your current balance. Balance: {balance}")
    else:
        balance -= bet
        prizePool += bet*2
        cards, playerCards, dealerCards = shuffleCards()
        inRound = True
        session(bet, cards)

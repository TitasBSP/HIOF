cantChangeThis = ("you", "can't", "touch", "this") # Can't change this tuple

def useThisList(tuple):
    x = f"The untouchable list: {(list(tuple))}"
    x = x.replace(',', '')
    x = x.replace('"', '')
    x = x.replace('[', '')
    x = x.replace(']', '')
    print(x)
    
if __name__ == "__main__":
    useThisList(cantChangeThis)
    
class Human:
    def __init__(self, age):
        self.age = age
        
    def sayAge(self):
        print(f"I am {self.age} years old")
        
class Fetus(Human):
    def __init__(self, age):      
        super().__init__(age)
    
xD = Fetus(age=0)

xD.sayAge() 
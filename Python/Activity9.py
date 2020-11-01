listOne = list(input("Enter first list separated by commas: ").split(','))
listTwo = list(input("Enter second list separated by commas: ").split(','))

print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (int(num) % 2 != 0):
        thirdList.append(num)
        
for num in listTwo:
    if (int(num) % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)
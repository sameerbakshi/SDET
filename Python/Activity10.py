num_tuple = tuple(input("Enter a tuple separated by commas: ").split(','))

print("You have entered: ",num_tuple)

print("Element(s) that are divisible by 5: ")

for num in num_tuple:
    if(int(num)%5==0):
        print(num)
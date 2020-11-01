num = int(input("Enter a number: "))
if(num%2 == 0):
    str = "{} is an even number"
elif(num%2 == 1):
    str = "{} is an odd number"
print(str.format(num))
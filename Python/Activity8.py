numbers = list(input("Enter a sequence of comma separated values: ").split(','))

first=numbers[0]
last=numbers[-1]

if(first==last):
    print(True)
else:
    print(False)
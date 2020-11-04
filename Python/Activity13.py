def calSum(numbers):
    sum=0
    for number in numbers:
        sum+=int(number)
    return sum

numList = list(input("Enter a list of numbers separated by comma: ").split(","))

result = "The sum of the numbers you have entered is : {}"

print(result.format(calSum(numList)))
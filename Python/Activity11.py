fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}
 
key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, "+key_to_check+" is available")
else:
    print("No, "+key_to_check+" is not available")
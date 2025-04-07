n = input()
targetN = input()
convertStr = ""

for i in n:
    if i.isalpha():
        convertStr += i

start = 0
for i in range(len(targetN) - 1, len(convertStr)):
    if convertStr[start:i + 1] == targetN:
        print(1)
        exit()
    else:
        start += 1


print(0)



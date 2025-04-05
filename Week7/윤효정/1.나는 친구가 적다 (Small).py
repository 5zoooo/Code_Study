k = input()
s = input()
keyword = ''

for ch in k :
    if ch.isalpha() :
        keyword += ch

if s in keyword :
    print(1)
else :
    print(0)

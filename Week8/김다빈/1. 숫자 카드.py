n = int(input())
cards = set(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))

for i in target:
    if i in cards:
        print(1, end=" ")
    else:
        print(0, end=" ")
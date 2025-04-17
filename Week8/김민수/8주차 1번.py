# 8주차 1번

N = int(input())
list_N = set(input().split())  

M = int(input())
list_M = input().split()

result = []

for i in list_M:
    if i in list_N:
        result.append(1)
    else:
        result.append(0)

print(' '.join(map(str, result)))

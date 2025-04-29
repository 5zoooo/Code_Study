# 9주차 1번

N = int(input())
M = list(map(int, input().split()))

total = sum(M)  
result = 0

for i in range(N):
    total -= M[i]           
    result += M[i] * total  

print(result)

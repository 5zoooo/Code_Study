# 9주차 2번

N, M = map(int, input().split())

A = []

for _ in range(N):
    A.append(list(map(int, input().split())))

K = int(input())

for _ in range(K):
    i, j, x, y = map(int, input().split())
    total = 0
    for row in range(i-1, x):        
        for col in range(j-1, y):     
            total += A[row][col]
    print(total)
# 9주차 4번

N, M = map(int, input().split())

A = []

for _ in range(N):
    A.append(list(map(int, input().split())))

prefix = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        prefix[i][j] = (
            prefix[i - 1][j] +    
            prefix[i][j - 1] -    
            prefix[i - 1][j - 1] + 
            A[i - 1][j - 1]       
        )

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    
    total = (
        prefix[x2][y2]
        - prefix[x1 - 1][y2]
        - prefix[x2][y1 - 1]
        + prefix[x1 - 1][y1 - 1]
    )
    
    print(total)
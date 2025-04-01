# 6주차 5번
# 정석 + 정렬 ver

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort() 

visited = [False] * N
result = []

def backtrack(depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            result.append(numbers[i])
            
            backtrack(depth + 1)
            
            visited[i] = False
            result.pop()

backtrack(0)

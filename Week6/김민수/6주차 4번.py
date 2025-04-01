# 6주차 4번
# 같은 수 허용 + 오름차순 ver

N, M = map(int, input().split())
result = []

def backtrack(start, depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    for i in range(start, N + 1):
        result.append(i)
        backtrack(i, depth + 1)  
        result.pop()

backtrack(1, 0)

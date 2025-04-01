#6주차 3번
# 같은 수 허용 ver

N, M = map(int, input().split())
result = []

def backtrack(depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    for i in range(1, N + 1):
        result.append(i)
        backtrack(depth + 1)
        result.pop()

backtrack(0)

# 6주차 6번
# 정렬 + 오름차순 ver

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

result = []

def backtrack(start, depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    for i in range(start, N):
        result.append(numbers[i])
        backtrack(i + 1, depth + 1)
        result.pop()

backtrack(0, 0)

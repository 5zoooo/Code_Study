# 6주차 9번
# 정렬 + 같은 수 허용 X , but 입력된 수가 같으면 허용 ver

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

visited = [False] * N
result = []

def backtrack(depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    prev = 0  

    for i in range(N):
        if not visited[i] and numbers[i] != prev:
            visited[i] = True
            result.append(numbers[i])
            prev = numbers[i]

            backtrack(depth + 1)

            visited[i] = False
            result.pop()

backtrack(0)

# 6주차 10번
# 정렬 + 오름차순 + 같은 수 허용 X , but 입력된 수가 같으면 허용 ver

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

result = []

def backtrack(start, depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    prev = 0  

    for i in range(start, N):
        if numbers[i] != prev:
            result.append(numbers[i])
            prev = numbers[i]
            backtrack(i + 1, depth + 1)
            result.pop()

backtrack(0, 0)

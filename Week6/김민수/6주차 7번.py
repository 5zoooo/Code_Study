# 6주차 7번
# 정렬 + 같은 수 허용 ver

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort() 

result = []

def backtrack(depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return

    for i in range(N):
            result.append(numbers[i])            
            backtrack(depth + 1)           
            result.pop()

backtrack(0)

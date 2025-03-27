n, m = map(int, input().split())
arr = list(range(1, n + 1))
arr.sort()
answerSet = set()
visited = [0] * (n + 1)


def backtracking(lst):
    if len(lst) == m:
        if tuple(lst) not in answerSet:
            answerSet.add(tuple(lst))
        return

    if len(lst) > m:
        return

    for i in range(len(arr)):
        if visited[i] == 0:
            visited[i] = 1
            backtracking(lst + [arr[i]])
            visited[i] = 0





backtracking([])
answer = sorted(answerSet)

for i in answer:
    print(*i)



